package ru.mipt.remotesession.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.remotesession.dto.QuestionDTO;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.repos.PossibleAnswersRepo;
import ru.mipt.remotesession.repos.QuestionRepo;
import ru.mipt.remotesession.service.interfaces.QuestionService;

import java.util.List;

/**
 * QuestionServiceImpl implementing QuestionService
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    /** Field questionRepo */
    @Autowired
    private QuestionRepo questionRepo;

    /** Field possibleAnswersRepo */
    @Autowired
    private PossibleAnswersRepo possibleAnswersRepo;

    /**
     * Saves new Question object to database
     * @param questionDTO class transferring data to database
     * @return Question object
     */
    public Question save(QuestionDTO questionDTO){
        Question question = new Question(questionDTO.getQuestionToAnswer(), questionDTO.getRightAnswerIndex(),
                questionDTO.getSubject(), questionDTO.getPossibleAnswers());
        return questionRepo.save(question);
    }


    /**
     * @param id Question's id
     * @return Question object
     */
    @Override
    public Question findQuestionById(int id) {
        return questionRepo.findQuestionById(id);
    }

    /**
     * @param id Subject's id
     * @return List of Question objects
     */
    @Override
    public List<Question> findQuestionBySubjectId(int id) {
        return questionRepo.findQuestionsBySubjectId(id);
    }


    /**
     * @return List of Question objects
     */
    @Override
    public List<Question> findAll() {
        return questionRepo.findAll();
    }

    /**
     * @param questionId Question's id
     * @param answer     int input answer
     * @return true or false
     */
    @Override
    public boolean compareAnswers(int questionId, int answer) {
        return questionRepo.findQuestionById(questionId).getRightAnswerIndex() == answer;
    }


}
