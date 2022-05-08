package ru.mipt.remotesession.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.remotesession.dto.SubjectDTO;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.Role;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.repos.SubjectRepo;
import ru.mipt.remotesession.service.interfaces.SubjectService;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    /**
     * Provides List of all subjects for further work with it.
     * @return List of Subject with all elements
     */
    public List<Subject> findAll(){
        return subjectRepo.findAll();
    }

    public Subject save(SubjectDTO subjectDTO) {
        Subject subject = new Subject(subjectDTO.getName());
        return subjectRepo.save(subject);
    }

    @Override
    public Subject findSubjectById(int id) {
        return subjectRepo.findSubjectById(id);
    }
}
