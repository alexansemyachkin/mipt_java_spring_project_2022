package ru.mipt.remotesession.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.repos.PossibleAnswersRepo;
import ru.mipt.remotesession.repos.QuestionRepo;
import ru.mipt.remotesession.service.interfaces.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private PossibleAnswersRepo possibleAnswersRepo;


    @Override
    public Question findQuestionById(int id) {
        return questionRepo.findQuestionById(id);
    }

    @Override
    public List<Question> findQuestionBySubjectId(int id) {
        return questionRepo.findQuestionsBySubjectId(id);
    }

    @Override
    public PossibleAnswers findPossibleAnswersByQuestionId(int id) {
        return possibleAnswersRepo.findPossibleAnswersByQuestionId(id);
    }

    @Override
    public List<Question> findAll() {
        return questionRepo.findAll();
    }

    @Override
    public boolean compareAnswers(int questionId, int answer) {
        return questionRepo.findQuestionById(questionId).getRightAnswerIndex() == answer;
    }


}
