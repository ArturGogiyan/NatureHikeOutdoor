package ru.demoshop.beta.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.demoshop.beta.dataBaseInterface.DAO.*;
import ru.demoshop.beta.dataBaseInterface.DTO.CategoryDTO;
import ru.demoshop.beta.dataBaseInterface.DTO.ItemDTO;
import ru.demoshop.beta.dataBaseInterface.entities.*;
import ru.demoshop.beta.storage.StorageFileNotFoundException;
import ru.demoshop.beta.storage.StorageService;


@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    private CategoriesDAO categoriesDAO;


    @Autowired
    private ItemsDAO itemsDAO;

    @Autowired
    private ColorsDAO colorsDAO;

    @Autowired
    private ParametersDAO parametersDAO;

    @Autowired
    private ImagesDAO imagesDAO;


    @GetMapping("/admin/addItem")
    public String listUploadedFiles(Model model) throws IOException {
        ItemDTO itemDTO = new ItemDTO();
        List<Categories> categories = categoriesDAO.findAllByAvailable(true);
        model.addAttribute("item", itemDTO);
        model.addAttribute("category", new CategoryDTO());
        model.addAttribute("names", categories);

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));
        return "admin/addItem";
    }



//
//    @GetMapping("/uploadForm")
//    public String listUploaded(Model model) throws IOException {
//
//        model.addAttribute("files", storageService.loadAll().map(
//                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//                        "serveFile", path.getFileName().toString()).build().toString())
//                .collect(Collectors.toList()));
//
//        return "uploadForm";
//    }
//
//
//    @PostMapping("/uploadForm")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        storageService.store(file);
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file.getOriginalFilename() + "!");
//
//        return "redirect:/uploadForm";
//    }


    @RequestMapping(value = "/admin/addCategory", method = RequestMethod.POST)
    public String handleCategory(CategoryDTO category) {
        storageService.store(category.getFile());
        Categories categories = new Categories(category);
        categories.setPictireUrl("/files/"+category.getName()+category.getFile().getOriginalFilename());
        categoriesDAO.save(categories);
        return "redirect:/admin";
    }





    @PostMapping("/admin/addItem")
    public String handleItem(ItemDTO item) {
        Items i = new Items(item);
        i.setImageURL("-");
        itemsDAO.save(i);
        Colors colors;
        i = itemsDAO.findByAvailableAndName(true, item.getName());
        long id = i.getId();
        long catId = i.getCategoryId();
        int n = 0;
        String file="-";
        for(MultipartFile mf : item.getFiles()) {
            if(!mf.getOriginalFilename().equals("")) {
                if (n == 0) file = "/files/"+mf.getOriginalFilename();
                Images images = new Images("/files/" + mf.getOriginalFilename(), id);
                imagesDAO.save(images);

                if (!mf.isEmpty()) storageService.store(mf);
                n++;
            }
        }

        n=0;
        for(String col: item.getColorNames()) {
            if (!(col.equals("")) && !(item.getColorQuantities()[n].equals(""))) {
                colors = new Colors(col, Integer.parseInt(item.getColorQuantities()[n]), id, catId);
                colorsDAO.save(colors);
                n++;
            }
        }
        n=0;
        Parameters parameter;
        for(String param: item.getParameterNames()){
            if(!(param.equals("")) && !(item.getParameterValues()[n].equals(""))) {
                parameter = new Parameters(param, item.getParameterValues()[n], id);
                parametersDAO.save(parameter);
                n++;
            }
        }
        i.setImageURL(file);
        itemsDAO.save(i);
        return "redirect:/admin";
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}