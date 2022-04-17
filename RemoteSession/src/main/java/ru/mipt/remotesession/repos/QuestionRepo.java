package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import ru.mipt.remotesession.models.Question;

public interface QuestionRepo extends CrudRepository<Question, Integer> {
}
