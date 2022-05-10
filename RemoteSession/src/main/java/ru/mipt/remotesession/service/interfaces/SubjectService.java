package ru.mipt.remotesession.service.interfaces;

import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;
import java.util.List;

/**
 * SubjectService interface
 * @see SubjectServiceImpl
 */
public interface SubjectService {

    /**
     * @return List of all Subjects from database
     * @see SubjectServiceImpl#findAll()
     */
    List<Subject> findAll();

    /**
     * @param id Subject's id
     * @return Subject object
     * @see SubjectServiceImpl#findSubjectById(int)
     */
    Subject findSubjectById(int id);
}
