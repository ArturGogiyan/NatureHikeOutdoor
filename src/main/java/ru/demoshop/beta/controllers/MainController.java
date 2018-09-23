package ru.demoshop.beta.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.demoshop.beta.dataBaseInterface.DAO.*;
import ru.demoshop.beta.dataBaseInterface.entities.*;
import ru.demoshop.beta.utils.WebUtils;

@Controller
public class MainController {

@Autowired
private CategoriesDAO categoriesDAO;

@Autowired
private ItemsDAO itemsDAO;

@Autowired
private ImagesDAO imagesDAO;

@Autowired
private ParametersDAO parametersDAO;

@Autowired
ColorsDAO colorsDAO;

@Autowired
UsersCartDAO usersCartDAO;

    @RequestMapping(value = {"/", "/welcome","/home"}, method = RequestMethod.GET)
    public String home(Model model, Principal principal) {
        model.addAttribute("userInfo",getResponse(principal));
        List<Categories> categories = categoriesDAO.findAllByAvailable(true);
        model.addAttribute("categories",categories);
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        return "about";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model, Principal principal) {
        model.addAttribute("userInfo",getResponse(principal));
        List<Categories> categories = categoriesDAO.findAllByAvailable(true);
        model.addAttribute("categories",categories);
        return "test";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category(Model model, Principal principal, @RequestParam("id") long id) {
        model.addAttribute("userInfo",getResponse(principal));
        List<Items> items = itemsDAO.findAllByAvailableAndCategoryId(true, id);
        model.addAttribute("items", items);
        return "items";
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String item(Model model, Principal principal, @RequestParam("id") long id) {

        model.addAttribute("userInfo", getResponse(principal));
        List<Images> images = imagesDAO.findAllByItemId(id);
        List<Parameters> parameters = parametersDAO.findAllByItemId(id);
        List<Colors> colors = colorsDAO.findAllByItemId(id);
        Items item = itemsDAO.findById(id);
        model.addAttribute("images", images);
        model.addAttribute("parameters", parameters);
        model.addAttribute("colors", colors);
        model.addAttribute("item", item);
        return "particularItemTest";
    }



    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }



    @RequestMapping(value = "/addIntoCart", method = RequestMethod.GET)
    public @ResponseBody String addIntoCart(Model model, Principal principal, @RequestParam("id") long id) {
        if(principal!=null) {
            System.out.print(principal.getName() + " " + colorsDAO.findById(id).getName());
            return "success";
        } else return "not_authorized";

    }

    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public String c(Model model, Principal principal, @RequestParam("id") long id) {
        model.addAttribute("userInfo",getResponse(principal));
//        List<Items> items = itemsDAO.findAllByAvailableAndCategoryId(true, id);
//        model.addAttribute("items", items);
        List<Images> images = imagesDAO.findALLByCategoryId(id);
        for(Images i :  images){
            System.out.println(i.getURL()+" ");
        }
        return "home";
    }



    private String getResponse(Principal principal){
        String response;
        if(principal==null)
            response = "        <button class=\"au-btn au-btn-icon au-btn--blue\" onclick=\"location.href='/login'\">\n" +
                    "            <i class=\"zmdi zmdi-plus\"></i>log in</button></div>";
        else response = "        <h4>"+principal.getName()+"</h4></div></li><li class=\"categories__item\"><button class=\"au-btn au-btn-icon au-btn--blue\" onclick=\"location.href='/logout'\">\n" +
                "            <i class=\"zmdi zmdi-plus\"></i>log out</button>";
        return response;
    }
}
