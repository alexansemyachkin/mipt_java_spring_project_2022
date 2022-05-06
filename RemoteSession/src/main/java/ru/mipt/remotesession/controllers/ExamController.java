package ru.mipt.remotesession.controllers;

import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.remotesession.models.Exam;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.repos.PossibleAnswersRepo;
import ru.mipt.remotesession.repos.QuestionRepo;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;
import ru.mipt.remotesession.service.interfaces.QuestionService;

import java.util.ArrayList;
import java.util.List;

/**
 * ExamController Controller class
 */
@Controller
@SessionAttributes("exam")
@RequestMapping("/home/subjects/subject{subjectId}/exam")
public class ExamController {


    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private SubjectServiceImpl subjectService;


    @ModelAttribute("exam")
    public Exam exam() {
        return new Exam();
    }

    @GetMapping
    public String welcomeExamPage(@ModelAttribute("exam") Exam exam ,@PathVariable int subjectId) {
        exam.setQuestionList(questionService.findQuestionBySubjectId(subjectId));
        exam.setSubjectName(subjectService.findSubjectById(subjectId).getName());
        System.out.println(subjectId);
        return "welcome_exam";
    }

    @GetMapping("question" + "{questionId}")
    public String examPage(@ModelAttribute("exam") Exam exam, @PathVariable int questionId, Model model) {
        int givenAnswerCounter = exam.getGivenAnswerCounter();
        PossibleAnswers possibleAnswers = questionService.findPossibleAnswersByQuestionId(questionId);
        String questionToAnswer = exam.getQuestionList().get(givenAnswerCounter).getQuestionToAnswer();
        exam.setGivenAnswerCounter(givenAnswerCounter + 1);
        model.addAttribute("possibleAnswers", possibleAnswers);
        model.addAttribute("question", questionToAnswer);
        System.out.println(exam.getQuestionList().get(givenAnswerCounter).getId());
        return "exam";
    }

    @PostMapping
    public void sendAnswers(@ModelAttribute("rightAnswerCounter") int rightAnswerCounter) {

    }
}
