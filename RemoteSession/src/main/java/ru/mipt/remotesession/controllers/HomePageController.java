package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.mipt.remotesession.models.Role;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;
import ru.mipt.remotesession.service.classes.UserServiceImpl;

import java.util.List;

/**
 * HomePageController Controller class
 */
@Controller
@SessionAttributes("user")
public class HomePageController {

    /** Field userService */
    @Autowired
    private UserServiceImpl userService;

    /** Fiels subjectService */
    @Autowired
    private SubjectServiceImpl subjectService;

    /**
     * @return User object
     */
    @ModelAttribute("user")
    public User user() {
        return userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }


    /**
     * @param user User model
     * @param model Subject model
     * @return view of the home page
     */
    @GetMapping("/home")
    public String homePage(@ModelAttribute("user") User user, Model model){
        model.addAttribute("subjectList", subjectService.findAll());
        List<Role> roles = user.getRoles().stream().toList();
        for (Role role: roles){
            if (role.getName().equals("ROLE_ADMIN")){
                return "redirect:/admin/home";
            }
        }
        return "home";
    }

}

