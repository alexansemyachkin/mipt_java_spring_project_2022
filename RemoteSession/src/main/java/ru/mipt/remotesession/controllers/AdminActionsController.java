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


/**
 * AdminActionsController controller class
 */
@Controller
@RequestMapping("admin/home")
public class AdminActionsController {

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
     * @return view of subject adding page
     */
    @GetMapping("/addSubject")
    public String addSubjectView(){
        return "new_subject";
    }

    /**
     * saves subject to database
     * @param subject Subject to save model
     * @return redirects to admon home page
     */
    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("subject") Subject subject){
        subjectService.save(new SubjectDTO(subject.getName()));
        return "redirect:/admin/home";
    }

    /**
     * @return view of the adding question page
     */
    @GetMapping("/subjects/subject{subjectId}/addQuestion")
    public String addQuestionView() {
        return "new_question";
    }

    /**
     * @param model Subject model
     * @return view of the page with all subjects
     */
    @GetMapping("/subjects")
    public String pickSubject(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "pick_subject";
    }

    /**
     * saves question to database
     * @param question Question model
     * @param subjectId Subject's id
     * @return redirects to admin home page
     */
    @PostMapping("/subjects/subject{subjectId}/addQuestion")
    public String addQuestion(@ModelAttribute("question") Question question, @PathVariable int subjectId){
        question.setSubject(subjectService.findSubjectById(subjectId));
        PossibleAnswers possibleAnswers = question.getPossibleAnswers();
        question.setPossibleAnswers(null);
        Question questionToSave =  questionService.save(new QuestionDTO(question.getQuestionToAnswer(), question.getRightAnswerIndex(), question.getSubject(), question.getPossibleAnswers()));
        possibleAnswersService.save(new PossibleAnswersDTO(possibleAnswers.getPossibleAnswer1(), possibleAnswers.getPossibleAnswer2(),
                possibleAnswers.getPossibleAnswer3(), possibleAnswers.getPossibleAnswer4(), questionToSave));

        return "redirect:/admin/home";
    }
}
