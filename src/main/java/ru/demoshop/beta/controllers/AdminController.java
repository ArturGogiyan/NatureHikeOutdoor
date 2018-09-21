package ru.demoshop.beta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.demoshop.beta.dataBaseInterface.DAO.CategoriesDAO;
import ru.demoshop.beta.dataBaseInterface.DAO.ItemsDAO;
import ru.demoshop.beta.dataBaseInterface.entities.Categories;
import ru.demoshop.beta.dataBaseInterface.entities.Items;
import ru.demoshop.beta.utils.WebUtils;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private CategoriesDAO categoriesDAO;

    @Autowired
    private ItemsDAO itemsDAO;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        List<Categories> categories = categoriesDAO.findAllByAvailable(true);
        model.addAttribute("names", categories);
        return "admin/index";
    }

    @RequestMapping(value = "/admin/getItems", method = RequestMethod.GET)
    public @ResponseBody String getItems(Model model, @RequestParam("name") long name) {
        return getItemData(name);
    }

    @RequestMapping(value = "/admin/removeItem", method = RequestMethod.GET)
    public @ResponseBody String removeItem(Model model, @RequestParam("name") long name) {
        Items item = itemsDAO.findByAvailableAndId(true, name);
        item.setAvailable(false);
        itemsDAO.save(item);
        return getItemData(item.getCategoryId());
    }

    @RequestMapping(value = "/admin/resetItems", method = RequestMethod.GET)
    public String resetItems(){
        List<Items> items = itemsDAO.findAllByAvailable(false);
        for(Items i : items){
            i.setAvailable(true);
            itemsDAO.save(i);
        }
        return "redirect:/admin";
    }

    private String getItemData(long name){
        List<Items> items = itemsDAO.findAllByAvailableAndCategoryId(true, name);
        System.out.print(items.size()+name);
        StringBuilder response= new StringBuilder("<select id=\"selectItem\">\n<option value=\"\"> -- </option>\n");
        for(Items i : items){
            response.append("<option value=\""+i.getId()+"\">"+i.getName()+" - $"+i.getPrice()+" ()</option>");
        }
        response.append("  </select>");
        return new String(response);
    }
}