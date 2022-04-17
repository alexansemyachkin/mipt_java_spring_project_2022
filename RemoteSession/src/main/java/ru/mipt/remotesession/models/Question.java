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

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PossibleAnswers> possibleAnswers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question", nullable = false)
    private Subject subject;

    public Question(){
        this.setPossibleAnswers(new ArrayList<>());
    }

    public Question(String questionToAnswer, Subject subject){
        this.questionToAnswer = questionToAnswer;
        this.subject = subject;
    }


    public String getQuestionToAnswer() {
        return questionToAnswer;
    }

    public void setQuestionToAnswer(String questionToAnswer) {
        this.questionToAnswer = questionToAnswer;
    }

    public List<PossibleAnswers> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<PossibleAnswers> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
}
