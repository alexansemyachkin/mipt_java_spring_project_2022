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
import ru.mipt.remotesession.service.classes.UserServiceImpl;
import ru.mipt.remotesession.service.interfaces.UserService;

/**
 * RegistrationController controller class
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    /** Field userService */
    @Autowired
    private UserServiceImpl userService;


    /**
     * @return UserDto Model
     */
    @ModelAttribute("user")
    public UserDTO userDTO() {
        return new UserDTO();
    }


    /**
     * @param model of User
     * @return view of registration
     */
    @GetMapping
    public String registrationController(Model model) {
        return "registration";
    }

    /**
     * Saves newely registered user
     * @param userDTO
     * @return view of start page
     */
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/";
    }
}