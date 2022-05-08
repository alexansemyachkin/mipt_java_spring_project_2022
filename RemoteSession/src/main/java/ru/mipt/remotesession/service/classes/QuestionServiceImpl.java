package ru.mipt.remotesession.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.remotesession.dto.QuestionDTO;
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

    public Question save(QuestionDTO questionDTO){
        Question question = new Question(questionDTO.getQuestionToAnswer(), questionDTO.getRightAnswerIndex(),
                questionDTO.getSubject(), questionDTO.getPossibleAnswers());
        return questionRepo.save(question);
    }


    @Override
    public Question findQuestionById(int id) {
        return questionRepo.findQuestionById(id);
    }

    @Override
    public List<Question> findQuestionBySubjectId(int id) {
        return questionRepo.findQuestionsBySubjectId(id);
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
