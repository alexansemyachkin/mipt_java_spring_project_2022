package ru.mipt.remotesession.service.interfaces;

import ru.mipt.remotesession.models.PossibleAnswers;

public interface PossibleAnswersService {
    public PossibleAnswers findPossibleAnswersByQuestionId(int id);
}
