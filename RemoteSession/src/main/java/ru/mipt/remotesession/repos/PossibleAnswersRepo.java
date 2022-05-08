package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.remotesession.models.PossibleAnswers;

@Repository
public interface PossibleAnswersRepo extends CrudRepository<PossibleAnswers, Integer> {

    public PossibleAnswers findPossibleAnswersByQuestionId(int id);
}
