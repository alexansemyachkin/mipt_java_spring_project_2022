package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.repos.UserRepo;

import java.sql.SQLException;

@Controller
public class RegistrationController {

   @Autowired
   private RestartEndpoint restartEndpoint;

   @Autowired
   private RefreshEndpoint refreshEndpoint;

    @Autowired
    UserRepo userRepo;



    @GetMapping("/registration")
    public String registrationController(Model model) {
        return "registration";
    }

    @GetMapping("registration/form")
    public String registratonGetController(@RequestParam("name") String name, @RequestParam("email")
            String email, @RequestParam("groupNumber") String groupNumber, @RequestParam("password") String password, Model model) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setGroupNumber(Integer.parseInt(groupNumber));
        user.setPassword(password);
        userRepo.save(user);
        refreshEndpoint.refresh();
        return "redirect:/";
    }

}
