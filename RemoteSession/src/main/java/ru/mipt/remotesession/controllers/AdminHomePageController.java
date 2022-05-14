package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.remotesession.dto.*;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.service.classes.PossibleAnswersServiceImpl;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;

/**
 * AdminHomePageController controller class
 */
@Controller
public class AdminHomePageController {


    /** Field subjectService */
    @Autowired
    private SubjectServiceImpl subjectService;

    /** Field questionService */
    @Autowired
    QuestionServiceImpl questionService;

    /** Fiels possibleAnswersService */
    @Autowired
    PossibleAnswersServiceImpl possibleAnswersService;

    /**
     * @return Subject object
     */
    @ModelAttribute("subject")
    public Subject subject() {
        return new Subject();
    }

    /**
     * @return Question object
     */
    @ModelAttribute("question")
    public Question question() {
        return new Question();
    }

    /**
     * @return view of the admin home page
     */
    @GetMapping("admin/home")
    public String adminHomePage(@ModelAttribute("subject") Subject subject, @ModelAttribute("question") Question question, Model model){
        model.addAttribute("subjectList", subjectService.findAll());
        return "admin_home";
    }

    /**
     * saves subject to database
     * @param subject SubjectDTO to save model
     * @return redirects to admin home page
     */
    @PostMapping("admin/home/addSubject")
    public String addSubject(@ModelAttribute("subject") Subject subject){
        subjectService.save(new SubjectDTO(subject.getName()));
        return "redirect:/admin/home";
    }

    /**
     * saves question to database
     * @param question Question to answer
     * @param subject Subject related to Question
     * @return redirects to admin home page
     */
    @PostMapping("admin/home/addQuestion")
    public String addQuestion(@ModelAttribute("question") Question question, @ModelAttribute("subject") Subject subject){
        question.setSubject(subjectService.findSubjectByName(subject.getName()));
        PossibleAnswers possibleAnswers = question.getPossibleAnswers();
        question.setPossibleAnswers(null);
        Question questionToSave =  questionService.save(new QuestionDTO(question.getQuestionToAnswer(), question.getRightAnswerIndex(), question.getSubject(), question.getPossibleAnswers()));
        possibleAnswersService.save(new PossibleAnswersDTO(possibleAnswers.getPossibleAnswer1(), possibleAnswers.getPossibleAnswer2(),
                possibleAnswers.getPossibleAnswer3(), possibleAnswers.getPossibleAnswer4(), questionToSave));
        return "redirect:/admin/home";
    }

}
