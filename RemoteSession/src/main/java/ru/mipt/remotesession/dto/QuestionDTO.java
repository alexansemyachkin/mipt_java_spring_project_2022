package ru.mipt.remotesession.dto;

import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;

import java.util.List;

public class QuestionDTO {
    private int id;
    private String questionToAnswer;
    private int rightAnswerIndex;
    private Subject subject;
    private List<PossibleAnswers> possibleAnswersList;

    public QuestionDTO(){
    }

    public QuestionDTO(int id, String questionToAnswer, int rightAnswerIndex,
                       Subject subject, List<Question> questionList) {
        this.setId(id);
        this.setQuestionToAnswer(questionToAnswer);
        this.setRightAnswerIndex(rightAnswerIndex);
        this.setPossibleAnswersList(possibleAnswersList);
        this.setSubject(subject);
    }

    public QuestionDTO(String questionToAnswer, int rightAnswerIndex,
                       Subject subject, List<PossibleAnswers> possibleAnswersList) {
        this.setQuestionToAnswer(questionToAnswer);
        this.setRightAnswerIndex(rightAnswerIndex);
        this.setPossibleAnswersList(possibleAnswersList);
        this.setSubject(subject);
    }

    public int getId() {
        return id;
    }

    public String getQuestionToAnswer() {
        return questionToAnswer;
    }

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestionToAnswer(String questionToAnswer) {
        this.questionToAnswer = questionToAnswer;
    }

    public void setRightAnswerIndex(int rightAnswerIndex) {
        this.rightAnswerIndex = rightAnswerIndex;
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<PossibleAnswers> getPossibleAnswersList() {
        return possibleAnswersList;
    }

    public void setPossibleAnswersList(List<PossibleAnswers> possibleAnswersList) {
        this.possibleAnswersList = possibleAnswersList;
    }
}
