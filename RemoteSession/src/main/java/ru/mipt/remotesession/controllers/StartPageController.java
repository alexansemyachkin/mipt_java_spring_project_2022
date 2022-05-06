package ru.mipt.remotesession.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

    /**
     * Redirects to start page
     */
    @GetMapping("/")
    public String defaultPage(){
        return "redirect:/home";
    }

    /**
     * @return view of start page
     */
    @GetMapping("/start")
    public String startPage(){
        return "start";
    }
}
