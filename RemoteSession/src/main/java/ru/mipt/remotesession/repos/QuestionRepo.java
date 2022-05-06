package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;

import java.util.List;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Integer> {

    public List<Question> findQuestionsBySubjectId(int id);
    public Question findQuestionById(int id);
    public List<Question> findAll();
}
