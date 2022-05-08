package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.remotesession.dto.QuestionDTO;
import ru.mipt.remotesession.dto.SubjectDTO;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;

import java.util.List;

@Controller
@RequestMapping("admin/home")
public class AdminActionsController {

    @Autowired
    private SubjectServiceImpl subjectService;

    @Autowired
    QuestionServiceImpl questionService;

    @ModelAttribute("subject")
    public Subject subject() {
        return new Subject();
    }

    @ModelAttribute("question")
    public Question question() {
        return new Question();
    }

    @GetMapping("/addSubject")
    public String addSubjectView(Model model){
        return "new_subject";
    }

    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("subject") Subject subject){
        subjectService.save(new SubjectDTO());
        return "admin/home";
    }

    @GetMapping("/addQuestion")
    public String addQuestionView(Model model) {
        model.addAttribute("subjectList", subjectService.findAll());
        return "new_question";
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@ModelAttribute("question") Question question){
        questionService.save(new QuestionDTO(question.getQuestionToAnswer(), question.getRightAnswerIndex(), question.getSubject(), question.getPossibleAnswers()));
        return "admin/home";
    }
}
