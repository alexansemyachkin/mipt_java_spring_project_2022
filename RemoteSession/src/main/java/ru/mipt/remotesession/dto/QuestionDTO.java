package ru.mipt.remotesession.dto;

import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;

import java.util.List;
/**
 * Class Question with fields id, questionToAnswer, rightAnswerIndex, subject, possibleAnswer
 */
public class QuestionDTO {
    private int id;
    private String questionToAnswer;
    private int rightAnswerIndex;
    private Subject subject;
    private PossibleAnswers possibleAnswers;


    /**
     * QuestionDTO Object constructor
     * @param questionToAnswer Question's question to be answered
     * @param rightAnswerIndex Question's right answer index
     * @param subject Question's subject
     * @param possibleAnswers Question's possibleAnswers
     */
    public QuestionDTO(String questionToAnswer, int rightAnswerIndex,
                       Subject subject, PossibleAnswers possibleAnswers) {
        this.setQuestionToAnswer(questionToAnswer);
        this.setRightAnswerIndex(rightAnswerIndex);
        this.setPossibleAnswers(possibleAnswers);
        this.setSubject(subject);
    }

    /** Field id */ /**
     * QuestionDTO's id getter method
     * @return int Question's id
     */
    public int getId() {
        return id;
    }

    /** Field  questionToAnswer */ /**
     * QuestionDTO's questionToAnswer getter method
     * @return String questionToAnswer
     */
    public String getQuestionToAnswer() {
        return questionToAnswer;
    }

    /**
     * QuestionDTO's questionToAnswer setter method
     * @param questionToAnswer - String Question's questionToAnswer
     */
    public void setQuestionToAnswer(String questionToAnswer) {
        this.questionToAnswer = questionToAnswer;
    }

    /** Field rightAnswerIndex */ /**
     * Question'DTOs rightAnswerIndex getter method
     * @return int Question's rightAnswerIndex
     */
    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    /**
     * QuestionDTO's questionToAnswer setter method
     * @param rightAnswerIndex - int Question's rightAnswerIndex
     */
    public void setRightAnswerIndex(int rightAnswerIndex) {
        this.rightAnswerIndex = rightAnswerIndex;
    }

    /**
     * QuestionDTO's id setter method
     * @param id - int Question's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * QuestionDTO's subject getter method
     * @return Question's subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * QuestionDTO's subject setter method
     * @param subject - Subject Question's subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * QuestionDTO's possibleAnswers getter method
     * @return Question's PossibleAnswers
     */
    public PossibleAnswers getPossibleAnswers() {
        return possibleAnswers;
    }

    /**
     * QuestionDTO's possibleAnswers setter method
     * @param possibleAnswer - PossibleAnswers Question possibleAnswers
     */
    public void setPossibleAnswers(PossibleAnswers possibleAnswer) {
        this.possibleAnswers = possibleAnswer;
    }
}


