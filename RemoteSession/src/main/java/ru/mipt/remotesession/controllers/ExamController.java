package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mipt.remotesession.details.UserDetail;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.Exam;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;
import ru.mipt.remotesession.service.classes.UserServiceImpl;


/**
 * ExamController Controller class
 */
@Controller
@SessionAttributes({"exam", "user"})
@RequestMapping("/home/subjects/subject{subjectId}/exam")
public class ExamController {


    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private SubjectServiceImpl subjectService;

    @Autowired
    private UserServiceImpl userService;


    @ModelAttribute("exam")
    public Exam exam() {
        return new Exam();
    }

    @ModelAttribute("user")
    public UserDTO user() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetail userDetail = (UserDetail) principal;
        User user = userService.findByEmail(userDetail.getUsername());
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getGroupNumber(), user.getPassword());
    }

    private int putMark(int rightAnswerCounter, int givenAnswerCounter) {
        double percentage = (double) (rightAnswerCounter * 100 / givenAnswerCounter);
        if (percentage >= 90) {
            return 5;
        }

        else if (percentage >= 80) {
            return 4;
        }
        else if (percentage >= 60) {
            return 3;
        }
        else {
            return 2;
        }
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

    @PostMapping("/completed")
    public String examCompleted(@ModelAttribute("exam") Exam exam, @ModelAttribute("user") UserDTO user) {
        int passedExamAmount = user.getPassedExamsAmount();
        int passedExamMarksSum = user.getPassedExamsMarksSum();
        user.setPassedExamsAmount(passedExamAmount + 1);
        user.setPassedExamsMarksSum(passedExamMarksSum + putMark(exam.getRightAnswerCounter(), exam.getGivenAnswerCounter()));
        System.out.println(user.getPassedExamsAmount());
        System.out.println(user.getPassedExamsMarksSum());
        userService.update(user);
        return "redirect:/home";
    }

}

