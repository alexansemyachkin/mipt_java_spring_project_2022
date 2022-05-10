package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.service.classes.UserServiceImpl;

/**
 * ProfileController controller class
 */
@Controller
public class ProfileController {

    /** Field userService */
    @Autowired
    private UserServiceImpl userService;

    /**
     * @return User object
     */
    @ModelAttribute
    public User user() {
        return userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    /**
     * @param user User model
     * @return view of user's profile page
     */
    @GetMapping("/profile")
    public String showInfo(@ModelAttribute("user") User user) {
        return "info";
    }

}
