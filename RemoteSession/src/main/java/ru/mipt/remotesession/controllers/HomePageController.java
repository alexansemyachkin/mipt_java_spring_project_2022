package ru.mipt.remotesession.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String startPage(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
}
