package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;

import java.util.List;

/**
 * SubjectController controller class
 */
@Controller
public class SubjectController {

    /** Field subjectService */
    @Autowired
    private SubjectServiceImpl subjectService;


    /**
     * @param model Subject object model
     * @return view of subjects page
     */
    @GetMapping("/home/subjects")
    public String subjectsPage(Model model){
        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }
}
