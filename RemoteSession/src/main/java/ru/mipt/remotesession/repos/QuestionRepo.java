package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;

import java.util.List;

/**
 * Public interface QuestionRepo extending CrudRepository
 */
@Repository
public interface QuestionRepo extends CrudRepository<Question, Integer> {

    /**
     * @param id int Subject's id
     * @return Question with necessary id
     */
    public List<Question> findQuestionsBySubjectId(int id);

    /**
     * @param id int Question's id
     * @return Question with necessary id
     */
    public Question findQuestionById(int id);

    /**
     * @return all Question objects from Database
     */
    public List<Question> findAll();
}
