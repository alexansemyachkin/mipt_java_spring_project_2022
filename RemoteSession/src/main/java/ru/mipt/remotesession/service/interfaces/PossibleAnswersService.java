package ru.mipt.remotesession.service.interfaces;

import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.service.classes.PossibleAnswersServiceImpl;

/**
 * PossibleAnswersService Interface
 * @see PossibleAnswersServiceImpl
 */
public interface PossibleAnswersService {
    /**
     * @param id Question's id
     * @return PossibleAnswer object with appropriate id
     */
    public PossibleAnswers findPossibleAnswersByQuestionId(int id);
}
