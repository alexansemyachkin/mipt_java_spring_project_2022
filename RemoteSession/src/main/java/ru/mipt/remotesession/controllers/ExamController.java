package ru.mipt.remotesession.controllers;

import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/home/subjects")
public class ExamController {


    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private SubjectServiceImpl subjectService;


    @GetMapping("/subject" +"{subjectId}/exam")
    public String welcomeExamPage(@PathVariable int subjectId, Model model) {
        Subject subject = subjectService.findSubjectById(subjectId);
        List<Question> questionList = questionService.findQuestionBySubjectId(subjectId);
        int rightAnswerCounter = 0;
        int iterator = 0;
        model.addAttribute("subject", subject);
        model.addAttribute("rightAnswerCounter", rightAnswerCounter);
        model.addAttribute("questionList", questionList);
        model.addAttribute("iterator", iterator);
        return "welcome_exam";
    }

    @GetMapping("/subject" +"{subjectId}/exam/question" + "{questionId}")
    public String examPage(@PathVariable int subjectId, @PathVariable int questionId, Model model, int iterator) {
        Question question = questionService.findQuestionById(questionId);
        PossibleAnswers possibleAnswers = questionService.findPossibleAnswersByQuestionId(questionId);
        int questionNumber = questionService.findQuestionBySubjectId(subjectId).size();
        ++iterator;
        if (iterator < questionNumber) {
            return "exam";
        }
        else {
            return "exam_completed";
        }
    }

    @PostMapping
    public void sendAnswers(@ModelAttribute("rightAnswerCounter") int rightAnswerCounter) {

    }
}
