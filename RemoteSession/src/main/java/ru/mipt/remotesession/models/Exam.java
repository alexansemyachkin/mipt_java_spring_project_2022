package ru.mipt.remotesession.models;


import java.util.ArrayList;
import java.util.List;

public class Exam {


    private int givenAnswerCounter;
    private int rightAnswerCounter;
    private String subjectName;
    private List<Question> questionList;

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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
        this.subjectName = "";
        this.questionList = new ArrayList<>();
    }

}
