package ru.mipt.remotesession.service.interfaces;

import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.repos.SubjectRepo;

import java.util.List;

public interface SubjectService {

    public List<Subject> findAll();
    public Subject findSubjectById(int id);
}
