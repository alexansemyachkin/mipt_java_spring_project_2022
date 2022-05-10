package ru.mipt.remotesession.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.remotesession.dto.*;

/**
 * AdminHomePageController controller class
 */
@Controller
public class AdminHomePageController {
    /**
     * @return view of the admin home page
     */
    @GetMapping("admin/home")
    public String adminHomePage(){
        return "admin_home";
    }

}
