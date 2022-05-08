package ru.mipt.remotesession.service.interfaces;

import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.repos.QuestionRepo;

import java.util.List;

public interface QuestionService {
    public Question findQuestionById(int id);
    public List<Question> findQuestionBySubjectId(int id);
    public List<Question> findAll();
    public boolean compareAnswers(int questionId, int answer);
}
