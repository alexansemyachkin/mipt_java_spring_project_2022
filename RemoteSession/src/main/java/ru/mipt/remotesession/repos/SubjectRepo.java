package ru.mipt.remotesession.repos;

import org.bouncycastle.util.Iterable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;

import java.util.List;


/**
 * Public interface SubjectRepo extending CrudRepository
 */
@Repository
public interface SubjectRepo extends CrudRepository<Subject, Integer> {
    /**
     * Provides Iterable of all Subject elements from Data Base
     * @return Iterable of Subject elements
     */
    public List<Subject> findAll();

    /**
     * @param id int Subject's id
     * @return Subject with necessary id
     */
    public Subject findSubjectById(int id);
}
