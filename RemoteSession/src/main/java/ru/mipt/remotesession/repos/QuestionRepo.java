package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Integer> {
}
