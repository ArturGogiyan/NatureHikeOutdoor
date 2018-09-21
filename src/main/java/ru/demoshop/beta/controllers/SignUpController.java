package ru.demoshop.beta.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.demoshop.beta.dataBaseInterface.DAO.AppUsersDAO;
import ru.demoshop.beta.dataBaseInterface.DAO.PasswordDAO;
import ru.demoshop.beta.dataBaseInterface.DAO.UserRoleDAO;
import ru.demoshop.beta.dataBaseInterface.DTO.CommonUSerData;
import ru.demoshop.beta.dataBaseInterface.DTO.UserDto;
import ru.demoshop.beta.dataBaseInterface.entities.AppUsers;
import ru.demoshop.beta.dataBaseInterface.entities.Password;
import ru.demoshop.beta.dataBaseInterface.entities.UserRole;
import ru.demoshop.beta.utils.CashedUsers;
import ru.demoshop.beta.utils.EncrytedPasswordUtils;

import java.util.HashMap;


@Controller
public class SignUpController {
    @Autowired
    private AppUsersDAO appUsersDAO;
    @Autowired
    private PasswordDAO passwordDAO;
    @Autowired
    private UserRoleDAO userRoleDAO;

    @RequestMapping("/login")
    public String registerAction(Model model) {
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String doRegister(UserDto user, Model model) {
        AppUsers savedUser = new AppUsers(user);
        appUsersDAO.save(savedUser);
        long id = appUsersDAO.findByEmail(user.getEmail()).getId();
        Password password = new Password();
        password.setUserId(id);
        password.setPassword(EncrytedPasswordUtils.encrytePassword(user.getPassword()));
        passwordDAO.save(password);
        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUserId(id);
        userRoleDAO.save(userRole);
        HashMap<String, CommonUSerData> users = CashedUsers.getUsers();
        users.put(user.getEmail(),new CommonUSerData(user.getLastName(), user.getFirstName(), user.getEmail()));
        return "redirect:/home"; //redirect to homepage
    }
}
