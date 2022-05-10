package ru.mipt.remotesession.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * StartPageController controller class
 */
@Controller
public class StartPageController {

    /**
     * Redirects to start page
     */
    @GetMapping("/")
    public String defaultPage(){
        return "redirect:/start";
    }

    /**
     * @return view of start page
     */
    @GetMapping("/start")
    public String startPage(){
        return "start";
    }
}
