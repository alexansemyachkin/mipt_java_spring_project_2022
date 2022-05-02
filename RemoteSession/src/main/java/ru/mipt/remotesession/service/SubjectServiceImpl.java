package ru.mipt.remotesession.service;

import org.springframework.data.util.Streamable;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.repos.SubjectRepo;

import java.util.List;

public class SubjectServiceImpl {
    private SubjectRepo subjectRepo;

    /**
     * Provides List of all subjects for further work with it.
     * @param subjectRepo SubjectRepo class storing data related to Subject from Data Base
     * @return List of Subject with all elements
     */
    public List<Subject> findAll(SubjectRepo subjectRepo){
        List<Subject> subjectList = Streamable.of(subjectRepo.findAll()).toList();
        return subjectList;
    }
}
