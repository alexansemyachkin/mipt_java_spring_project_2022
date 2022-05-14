package ru.mipt.remotesession.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Exam with fields givenAnswerCounter, rightAnswerCounter, subject,
 * questionList, currentAnswer, currentQuestion, currentPossibleAnswers
 */
public class Exam {

    /** Field givenAnswerCounter */
    private int givenAnswerCounter;

    /** Field rightAnswerCounter */
    private int rightAnswerCounter;

    /** Field subject */
    private Subject subject;

    /** Field questionList */
    private List<Question> questionList;

    /** Field currentAnswer */
    private int currentAnswer;

    /** Field currentQuestion */
    private Question currentQuestion;

    /** Field currentPossibleAnswers */
    private PossibleAnswers currentPossibleAnswers;

    /**
     * Exam default constructor
     */
    public Exam() {
        this.givenAnswerCounter = 0;
        this.rightAnswerCounter = 0;
        this.currentAnswer = 0;
        this.subject = new Subject();
        this.questionList = new ArrayList<>();
    }

    /**
     * Exam's currentQuestion getter method
     * @return Exams's currentQuestion
     */
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     * Exam's currentQuestion setter method
     * @param currentQuestion Exam's currentQuestion
     */
    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
    /**
     * Exam's currentPossibleanswers getter method
     * @return Exams's currentPossibleAnswers
     */
    public PossibleAnswers getCurrentPossibleAnswers() {
        return currentPossibleAnswers;
    }

    /**
     * Exam's currentPossibleAnswers setter method
     * @param currentPossibleAnswers Exam's currernPossibleAnswers
     */
    public void setCurrentPossibleAnswers(PossibleAnswers currentPossibleAnswers) {
        this.currentPossibleAnswers = currentPossibleAnswers;
    }

    /**
     * Exam's currentAnswer getter method
     * @return Exams's currentAnswer
     */
    public int getCurrentAnswer() {
        return currentAnswer;
    }

    /**
     * Exam's currentAnswer setter method
     * @param currentAnswer Exam's currentAnswer
     */
    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }


    /**
     * Exam's givenAnswerCounter getter method
     * @return Exams's givenAnswerCounter
     */
    public int getGivenAnswerCounter() {
        return givenAnswerCounter;
    }

    /**
     * Exam's givenAnswerCounter setter method
     * @param givenAnswerCounter Exam's givenAnswerCounter
     */
    public void setGivenAnswerCounter(int givenAnswerCounter) {
        this.givenAnswerCounter = givenAnswerCounter;
    }

    /**
     * Exam's rightAnswerCounter getter method
     * @return Exams's rightAnswerCounter
     */
    public int getRightAnswerCounter() {
        return rightAnswerCounter;
    }

    /**
     * Exam's righrAnswerCounter setter method
     * @param rightAnswerCounter Exam's rightAnswerCounter
     */
    public void setRightAnswerCounter(int rightAnswerCounter) {
        this.rightAnswerCounter = rightAnswerCounter;
    }

    /**
     * Exam's subject getter method
     * @return Exams's subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Exam's subject setter method
     * @param subject Exam;s subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * Exam's questionList getter method
     * @return Exams's questionList
     */
    public List<Question> getQuestionList() {
        return questionList;
    }

    /**
     * Exam's questionList setter method
     * @param questionList Exam's questionList
     */
    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    /**
     * Resets Exam's fields
     */
    public void clean() {
        this.givenAnswerCounter = 0;
        this.rightAnswerCounter = 0;
        this.currentAnswer = 0;
        this.subject = new Subject();
        this.questionList = new ArrayList<>();
    }

}
