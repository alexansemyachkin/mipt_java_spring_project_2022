package ru.mipt.remotesession.service.interfaces;

import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.repos.QuestionRepo;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;

import java.util.List;

/**
 * QuestionService interface
 * @see QuestionServiceImpl
 */
public interface QuestionService {
    /**
     * @param id Question's id
     * @return Question object
     * @see QuestionServiceImpl#findQuestionById(int)
     */
    Question findQuestionById(int id);

    /**
     * @param id Subject's id
     * @return Question wth appropriate subjectId
     * @see QuestionServiceImpl#findQuestionBySubjectId(int)
     */
    List<Question> findQuestionBySubjectId(int id);

    /**
     * @return List of all Questions from database
     * @see QuestionServiceImpl#findAll()
     */
    List<Question> findAll();

    /**
     * @param questionId Question's id
     * @param answer int input answer
     * @return true if answer is correct, false either
     */
    boolean compareAnswers(int questionId, int answer);
}
