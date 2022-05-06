package ru.mipt.remotesession.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomePageController Controller class
 */
@Controller
public class HomePageController {



    /**
     * @return view of homepage
     */
    @GetMapping("/home")
    public String homePage(){
        return "home";
    }


}
