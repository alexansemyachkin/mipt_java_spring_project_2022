package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.repos.SubjectRepo;
import ru.mipt.remotesession.service.SubjectServiceImpl;
import ru.mipt.remotesession.service.UserService;

import java.util.List;

/**
 * SubjectController Controller class
 */
@Controller
public class SubjectsController {

    /** Field subjectRepo */
    @Autowired
    SubjectRepo subjectRepo;


    /**
     * @param subjectServiceImpl
     * @return view of page with subjects to pass exam
     */
    @GetMapping("/subjects")
    public String getAllSubjects(SubjectServiceImpl subjectServiceImpl){
        List<Subject> subjectList = subjectServiceImpl.findAll(subjectRepo);
        return "subjects";
    }
}
