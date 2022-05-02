package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mipt.remotesession.models.Subject;

import java.util.List;


@Repository
public interface SubjectRepo extends CrudRepository<Subject, Integer> {
    /**
     * Provides Iterable of all Subject elements from Data Base
     * @return Iterable of Subject elements
     */
    Iterable<Subject> findAll();
}
