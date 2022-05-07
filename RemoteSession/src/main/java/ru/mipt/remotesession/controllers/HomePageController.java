package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.service.classes.UserServiceImpl;

/**
 * HomePageController Controller class
 */
@Controller
@SessionAttributes("user")
public class HomePageController {


    @Autowired
    private UserServiceImpl userService;

    @ModelAttribute("user")
    public User user() {
        return userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    /**
     * @return view of homepage
     */
    @GetMapping("/home")
    public String homePage(){
        return "home";
    }


}
