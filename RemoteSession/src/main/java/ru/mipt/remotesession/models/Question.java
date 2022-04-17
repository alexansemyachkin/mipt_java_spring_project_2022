package ru.mipt.remotesession.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String questionToAnswer;

    private String possibleAnswer1;

    private String possibleAnswer2;

    private String possibleAnswer3;

    private String possibleAnswer4;

    private int rightAnswerIndex;


    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;


    public Question(String questionToAnswer, String possibleAnswer1, String possibleAnswer2, String possibleAnswer3, String possibleAnswer4, int rightAnswerIndex, Subject subject){
        this.questionToAnswer = questionToAnswer;
        this.possibleAnswer1 = possibleAnswer1;
        this.possibleAnswer2 = possibleAnswer2;
        this.possibleAnswer3 = possibleAnswer3;
        this.possibleAnswer4 = possibleAnswer4;
        this.rightAnswerIndex = rightAnswerIndex;
        this.subject = subject;
    }

    public Question() {

    }

    public List<String> getPossibleAnswers() {
        List possibleAnswers = new ArrayList();
        possibleAnswers.add(possibleAnswer1);
        possibleAnswers.add(possibleAnswer2);
        possibleAnswers.add(possibleAnswer3);
        possibleAnswers.add(possibleAnswer4);
        return possibleAnswers;
    }

    public String getQuestionToAnswer() {
        return questionToAnswer;
    }

    public void setQuestionToAnswer(String questionToAnswer) {
        this.questionToAnswer = questionToAnswer;
    }


}
