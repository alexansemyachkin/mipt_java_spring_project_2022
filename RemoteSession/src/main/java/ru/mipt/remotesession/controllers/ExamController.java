package ru.mipt.remotesession.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.*;
import ru.mipt.remotesession.service.classes.PossibleAnswersServiceImpl;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;
import ru.mipt.remotesession.service.classes.UserServiceImpl;

import java.math.BigDecimal;
import java.util.Set;


/**
 * ExamController Controller class
 */
@Controller
@SessionAttributes("exam")
@RequestMapping("/home/subjects/subject{subjectId}/exam")
public class ExamController {

    /** Field possibleAnswersImpl */
    @Autowired
    private PossibleAnswersServiceImpl possibleAnswersService;

    /** Field questionService */
    @Autowired
    private QuestionServiceImpl questionService;

    /** Field subjectService */
    @Autowired
    private SubjectServiceImpl subjectService;

    /** Field userService */
    @Autowired
    private UserServiceImpl userService;


    /**
     * @return Exam object
     */
    @ModelAttribute("exam")
    public Exam exam() {
        return new Exam();
    }

    /**
     * @param rightAnswerCounter amount of right answers
     * @param givenAnswerCounter amount of given answers
     * @return in mark
     */
    private int putMark(int rightAnswerCounter, int givenAnswerCounter) {
        double percentage = ((double) rightAnswerCounter * 100 / (double) givenAnswerCounter);
        return (int) (percentage / 10);
    }

    /**
     * @param exam Exam model
     * @param subjectId Subject id
     * @return view of the welcome exam page
     */
    @GetMapping
    public String welcomeExamPage(@ModelAttribute("exam") Exam exam, @PathVariable int subjectId) {
        exam.setQuestionList(questionService.findQuestionBySubjectId(subjectId));
        exam.setSubject(subjectService.findSubjectById(subjectId));
        return "redirect:exam/test";
    }

    /**
     * @param exam  Exam model
     * @return view of the exam completed page or of the exam process age
     */
    @GetMapping("/test")
    public String examPage(@ModelAttribute("exam") Exam exam) {
        int givenAnswerCounter = exam.getGivenAnswerCounter();
        if (givenAnswerCounter == exam.getQuestionList().size()) {
            return "exam_completed";
        }

        else {
            PossibleAnswers possibleAnswers = possibleAnswersService.findPossibleAnswersByQuestionId(exam.getQuestionList().get(givenAnswerCounter).getId());
            Question question = exam.getQuestionList().get(givenAnswerCounter);
            exam.setCurrentQuestion(question);
            exam.setCurrentPossibleAnswers(possibleAnswers);
            exam.setGivenAnswerCounter(givenAnswerCounter + 1);
            return "exam";
        }
    }

    /**
     * @param exam Exam model
     * @return redirects to appropriate subject exam page
     */
    @PostMapping("/test")
    public String sendAnswer(@ModelAttribute("exam") Exam exam) {
        if (questionService.compareAnswers(exam.getCurrentQuestion().getId(), exam.getCurrentAnswer())) {
            int rightAnswerCounter = exam.getRightAnswerCounter();
            exam.setRightAnswerCounter(rightAnswerCounter + 1);
        }
        return "redirect:/home/subjects/subject" + exam.getSubject().getId() + "/exam/test";
    }

    /**
     * @param exam Exam model
     * @param user User model
     * @return redirects to home page after exam
     */
    @PostMapping("/completed")
    public String examCompleted(@ModelAttribute("exam") Exam exam, @SessionAttribute("user") User user) {
        int passedExamAmount = user.getPassedExamsAmount();
        int passedExamMarksSum = user.getPassedExamsMarksSum();
        user.setPassedExamsAmount(passedExamAmount + 1);
        user.setPassedExamsMarksSum(passedExamMarksSum + putMark(exam.getRightAnswerCounter(), exam.getGivenAnswerCounter()));
        user.setAverageMark(BigDecimal.valueOf( (double) user.getPassedExamsMarksSum() / (double) user.getPassedExamsAmount()));
        userService.update(new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getGroupNumber(), user.getPassword(), user.getPassedExamsAmount(), user.getPassedExamsMarksSum(), user.getRoles(), user.getAverageMark()));
        exam.clean();
        return "redirect:/home";
    }

}