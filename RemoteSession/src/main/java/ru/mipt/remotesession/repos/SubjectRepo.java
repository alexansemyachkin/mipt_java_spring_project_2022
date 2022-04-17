package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import ru.mipt.remotesession.models.Subject;

public interface SubjectRepo extends CrudRepository<Subject, Integer> {
}
