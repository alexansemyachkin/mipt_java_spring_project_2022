package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.remotesession.dto.PossibleAnswersDTO;
import ru.mipt.remotesession.dto.QuestionDTO;
import ru.mipt.remotesession.dto.SubjectDTO;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.service.classes.PossibleAnswersServiceImpl;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;


@Controller
@RequestMapping("admin/home")
public class AdminActionsController {

    @Autowired
    private SubjectServiceImpl subjectService;

    @Autowired
    QuestionServiceImpl questionService;

    @Autowired
    PossibleAnswersServiceImpl possibleAnswersService;

    @ModelAttribute("subject")
    public Subject subject() {
        return new Subject();
    }

    @ModelAttribute("question")
    public Question question() {
        return new Question();
    }

    @GetMapping("/addSubject")
    public String addSubjectView(){
        return "new_subject";
    }

    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("subject") Subject subject){
        subjectService.save(new SubjectDTO(subject.getName()));
        return "redirect:/admin/home";
    }

    @GetMapping("/subjects/subject{subjectId}/addQuestion")
    public String addQuestionView() {
        return "new_question";
    }

    @GetMapping("/subjects")
    public String pickSubject(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "pick_subject";
    }

    @PostMapping("/subjects/subject{subjectId}/addQuestion")
    public String addQuestion(@ModelAttribute("question") Question question, @PathVariable int subjectId){
        question.setSubject(subjectService.findSubjectById(subjectId));
        questionService.save(new QuestionDTO(question.getQuestionToAnswer(), question.getRightAnswerIndex(), question.getSubject(), question.getPossibleAnswers()));
//        PossibleAnswers possibleAnswers = question.getPossibleAnswers();
//        possibleAnswersService.save(new PossibleAnswersDTO(possibleAnswers.getPossibleAnswer1(), possibleAnswers.getPossibleAnswer2(),
//                possibleAnswers.getPossibleAnswer3(), possibleAnswers.getPossibleAnswer4(), question));
        return "redirect:/admin/home";
    }
}
//admin@phystech.edu
//password