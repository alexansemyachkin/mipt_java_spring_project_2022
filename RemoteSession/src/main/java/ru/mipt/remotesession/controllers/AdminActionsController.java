package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.remotesession.dto.QuestionDTO;
import ru.mipt.remotesession.dto.SubjectDTO;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;

@Controller
@RequestMapping("admin/home")
public class AdminActionsController {

    @Autowired
    private SubjectServiceImpl subjectServiceImpl;

    @Autowired
    QuestionServiceImpl questionServiceImpl;

    @ModelAttribute("subject")
    public SubjectDTO subjectDTO() {
        return new SubjectDTO();
    }

    @ModelAttribute("question")
    public QuestionDTO questionDTO() {return new QuestionDTO();}

    @ModelAttribute("possibleAnswers")
    public PossibleAnswersDTO possibleAnswersDTO(){return new PossibleAnswersDTO();}

    @GetMapping("/addSubject")
    public String addSubjectView(){
        return "";
    }

    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("subject") SubjectDTO subjectDTO){
        subjectServiceImpl.save(subjectDTO);
        return "admin/home";
    }

    @GetMapping("/addQuestion")
    public String addQuestionView() {
        return "";
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@ModelAttribute("question") QuestionDTO questionDTO){
        questionServiceImpl.save(questionDTO);
        return "admin/home";
    }
}
