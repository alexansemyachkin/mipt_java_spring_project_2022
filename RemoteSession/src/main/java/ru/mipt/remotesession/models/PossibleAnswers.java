package ru.mipt.remotesession.models;


import javax.persistence.*;

@Entity
public class PossibleAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String possibleAnswer1;

    private String possibleAnswer2;

    private String possibleAnswer3;

    private String possibleAnswer4;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "possibleAnswers", nullable = false)
    private Question question;

    public PossibleAnswers() {}

    public PossibleAnswers(String possibleAnswer1, String possibleAnswer2,
                           String possibleAnswer3, String possibleAnswer4, Question question){
        this.setPossibleAnswer1(possibleAnswer1);
        this.setPossibleAnswer2(possibleAnswer2);
        this.setPossibleAnswer3(possibleAnswer3);
        this.setPossibleAnswer4(possibleAnswer4);
        this.setQuestion(question);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPossibleAnswer1() {
        return possibleAnswer1;
    }

    public void setPossibleAnswer1(String possibleAnswer1) {
        this.possibleAnswer1 = possibleAnswer1;
    }

    public String getPossibleAnswer2() {
        return possibleAnswer2;
    }

    public void setPossibleAnswer2(String possibleAnswer2) {
        this.possibleAnswer2 = possibleAnswer2;
    }

    public String getPossibleAnswer3() {
        return possibleAnswer3;
    }

    public void setPossibleAnswer3(String possibleAnswer3) {
        this.possibleAnswer3 = possibleAnswer3;
    }

    public String getPossibleAnswer4() {
        return possibleAnswer4;
    }

    public void setPossibleAnswer4(String possibleAnswer4) {
        this.possibleAnswer4 = possibleAnswer4;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
