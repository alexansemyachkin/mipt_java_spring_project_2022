package ru.mipt.remotesession.controllers;

import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.remotesession.models.Exam;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;


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
    public String welcomeExamPage(@ModelAttribute("exam") Exam exam, @PathVariable int subjectId) {
        exam.setQuestionList(questionService.findQuestionBySubjectId(subjectId));
        exam.setSubject(subjectService.findSubjectById(subjectId));
        return "welcome_exam";
    }

    @GetMapping("/test")
    public String examPage(@ModelAttribute("exam") Exam exam) {
        int givenAnswerCounter = exam.getGivenAnswerCounter();
        if (givenAnswerCounter == exam.getQuestionList().size()) {
            return "exam_completed";
        }

        else {
            PossibleAnswers possibleAnswers = questionService.findPossibleAnswersByQuestionId(exam.getQuestionList().get(givenAnswerCounter).getId());
            Question question = exam.getQuestionList().get(givenAnswerCounter);
            exam.setCurrentQuestion(question);
            exam.setCurrentPossibleAnswers(possibleAnswers);
            exam.setGivenAnswerCounter(givenAnswerCounter + 1);
            return "exam";
        }
    }

    @PostMapping("/test")
    public String sendAnswer(@ModelAttribute("exam") Exam exam) {
        if (questionService.compareAnswers(exam.getCurrentQuestion().getId(), exam.getCurrentAnswer())) {
            int rightAnswerCounter = exam.getRightAnswerCounter();
            exam.setRightAnswerCounter(rightAnswerCounter + 1);
        }
        return "redirect:/home/subjects/subject" + exam.getSubject().getId() + "/exam/test";
    }

}
