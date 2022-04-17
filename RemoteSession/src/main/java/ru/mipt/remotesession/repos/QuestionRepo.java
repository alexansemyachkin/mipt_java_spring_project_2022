package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;

public interface QuestionRepo extends CrudRepository<Question, Integer> {
}
