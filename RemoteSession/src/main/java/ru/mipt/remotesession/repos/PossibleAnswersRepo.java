package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.remotesession.models.PossibleAnswers;

/**
 * Public interface QuestionRepo extending CrudRepository
 */
@Repository
public interface PossibleAnswersRepo extends CrudRepository<PossibleAnswers, Integer> {

    /**
     * @param id int Question's id
     * @return PossibleAnswer object with necessary id
     */
    public PossibleAnswers findPossibleAnswersByQuestionId(int id);
}
