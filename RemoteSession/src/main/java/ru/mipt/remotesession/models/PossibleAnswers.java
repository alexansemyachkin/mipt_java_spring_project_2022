package ru.mipt.remotesession.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.util.Lazy;

import javax.persistence.*;

/**
 * Class PossibleAnswers with fields id, possibleAnswer1, possibleAnswer2,
 * possibleAnswer3, possibleAnswer4, question
 */
@Entity
public class PossibleAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** Field id */
    private int id;

    /** Field first possible answer */
    private String possibleAnswer1;

    /** Field second possible answer */
    private String possibleAnswer2;

    /** Field third possible answer */
    private String possibleAnswer3;

    /** Field fourth possible answer */
    private String possibleAnswer4;


    /** Field question with relation one-to-one */
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JsonIgnore
    private Question question;


    /**
     * PossibleAnswersDTO object constructor
     * @param possibleAnswer1 PossibleAnswers's first possible answer
     * @param possibleAnswer2 PossibleAnswers's second possible answer
     * @param possibleAnswer3 PossibleAnswers's third possible answer
     * @param possibleAnswer4 PossibleAnswers's fourth possible answer
     * @param question PossibleAnswers's question
     */
    public PossibleAnswers(String possibleAnswer1, String possibleAnswer2, String possibleAnswer3, String possibleAnswer4, Question question){
        this.setPossibleAnswer1(possibleAnswer1);
        this.setPossibleAnswer2(possibleAnswer2);
        this.setPossibleAnswer3(possibleAnswer3);
        this.setPossibleAnswer4(possibleAnswer4);
        this.setQuestion(question);
    }

    /**
     * PossibleAnswers default constructor
     */
    public PossibleAnswers() {
        this.setPossibleAnswer1("");
        this.setPossibleAnswer2("");
        this.setPossibleAnswer3("");
        this.setPossibleAnswer4("");
    }


    /**
     * Question's getter method
     * @return Question relates to PossibleAnswers
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @param question - Question relates to PossibleAnswers
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * PossibleAnswers's possibleAnswer1 getter method
     * @return String PossibleAnswers's possibleAnswer1
     */
    public String getPossibleAnswer1() {
        return possibleAnswer1;
    }

    /**
     * PossibleAnswer's possibleAnswer1 setter method
     * @param possibleAnswer1 - String PossibleAnswers's possibleAnswer1
     */
    public void setPossibleAnswer1(String possibleAnswer1) {
        this.possibleAnswer1 = possibleAnswer1;
    }

    /**
     * PossibleAnswers's possibleAnswer2 getter method
     * @return String PossibleAnswers's possibleAnswer2
     */
    public String getPossibleAnswer2() {
        return possibleAnswer2;
    }

    /**
     * PossibleAnswer's possibleAnswer2 setter method
     * @param possibleAnswer2 - String PossibleAnswers's possibleAnswer2
     */
    public void setPossibleAnswer2(String possibleAnswer2) {
        this.possibleAnswer2 = possibleAnswer2;
    }

    /**
     * PossibleAnswers's possibleAnswer3 getter method
     * @return String PossibleAnswers's possibleAnswer3
     */
    public String getPossibleAnswer3() {
        return possibleAnswer3;
    }

    /**
     * PossibleAnswer's possibleAnswer3 setter method
     * @param possibleAnswer3 - String PossibleAnswers's possibleAnswer3
     */
    public void setPossibleAnswer3(String possibleAnswer3) {
        this.possibleAnswer3 = possibleAnswer3;
    }

    /**
     * PossibleAnswers's possibleAnswer4 getter method
     * @return String PossibleAnswers's possibleAnswer4
     */
    public String getPossibleAnswer4() {
        return possibleAnswer4;
    }

    /**
     * PossibleAnswer's possibleAnswer4 setter method
     * @param possibleAnswer4 - String PossibleAnswers's possibleAnswer4
     */
    public void setPossibleAnswer4(String possibleAnswer4) {
        this.possibleAnswer4 = possibleAnswer4;
    }
}
