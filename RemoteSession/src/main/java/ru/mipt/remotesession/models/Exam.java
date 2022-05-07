package ru.mipt.remotesession.models;


import java.util.ArrayList;
import java.util.List;

public class Exam {


    private int givenAnswerCounter;
    private int rightAnswerCounter;
    private Subject subject;
    private List<Question> questionList;
    private int currentAnswer;
    private Question currentQuestion;
    private PossibleAnswers currentPossibleAnswers;

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public PossibleAnswers getCurrentPossibleAnswers() {
        return currentPossibleAnswers;
    }

    public void setCurrentPossibleAnswers(PossibleAnswers currentPossibleAnswers) {
        this.currentPossibleAnswers = currentPossibleAnswers;
    }

    public int getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }


    public int getGivenAnswerCounter() {
        return givenAnswerCounter;
    }

    public void setGivenAnswerCounter(int givenAnswerCounter) {
        this.givenAnswerCounter = givenAnswerCounter;
    }

    public int getRightAnswerCounter() {
        return rightAnswerCounter;
    }

    public void setRightAnswerCounter(int rightAnswerCounter) {
        this.rightAnswerCounter = rightAnswerCounter;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Exam() {
        this.givenAnswerCounter = 0;
        this.rightAnswerCounter = 0;
        this.currentAnswer = 0;
        this.subject = new Subject();
        this.questionList = new ArrayList<>();
    }

}
