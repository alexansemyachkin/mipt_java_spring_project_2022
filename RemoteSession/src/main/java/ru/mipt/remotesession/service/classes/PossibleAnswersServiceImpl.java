package ru.mipt.remotesession.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.remotesession.dto.PossibleAnswersDTO;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.repos.PossibleAnswersRepo;
import ru.mipt.remotesession.service.interfaces.PossibleAnswersService;

/**
 * PossibleAnswersServiceImpl implementing PossibleAnswersService
 */
@Service
public class PossibleAnswersServiceImpl implements PossibleAnswersService {

    /** Field possibleAnswersRepo */
    @Autowired
    public PossibleAnswersRepo possibleAnswersRepo;

    /**
     * @param id Question's id
     * @return PossibleAnswers object
     */
    @Override
    public PossibleAnswers findPossibleAnswersByQuestionId(int id) {
        return possibleAnswersRepo.findPossibleAnswersByQuestionId(id);
    }

    /**
     * Saves new PossibleAnswers object to database
     * @param possibleAnswersDTO
     * @return PossibleAnswers object
     */
    public PossibleAnswers save(PossibleAnswersDTO possibleAnswersDTO) {
        PossibleAnswers possibleAnswers = new PossibleAnswers(possibleAnswersDTO.getPossibleAnswer1(), possibleAnswersDTO.getPossibleAnswer2(),
                possibleAnswersDTO.getPossibleAnswer3(), possibleAnswersDTO.getPossibleAnswer4(), possibleAnswersDTO.getQuestion());
        return possibleAnswersRepo.save(possibleAnswers);
    }
}
