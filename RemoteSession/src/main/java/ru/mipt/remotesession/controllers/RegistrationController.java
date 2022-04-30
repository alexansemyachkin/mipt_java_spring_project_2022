package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.repos.UserRepo;
import ru.mipt.remotesession.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserRepo userRepo;

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDTO userDTO() {
        return new UserDTO();
    }


    @GetMapping
    public String registrationController(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/";
    }
}