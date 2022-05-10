package ru.mipt.remotesession.dto;

import ru.mipt.remotesession.models.Question;

import javax.persistence.*;

public class PossibleAnswersDTO {
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
    private Question question;


    /**
     * PossibleAnswersDTO object constructor
     * @param possibleAnswer1 PossibleAnswersDTO's first possible answer
     * @param possibleAnswer2 PossibleAnswersDTO's second possible answer
     * @param possibleAnswer3 PossibleAnswersDTO's third possible answer
     * @param possibleAnswer4 PossibleAnswersDTO's fourth possible answer
     * @param question PossibleAnswersDTO's question
     */
    public PossibleAnswersDTO(String possibleAnswer1, String possibleAnswer2, String possibleAnswer3, String possibleAnswer4, Question question){
        this.setPossibleAnswer1(possibleAnswer1);
        this.setPossibleAnswer2(possibleAnswer2);
        this.setPossibleAnswer3(possibleAnswer3);
        this.setPossibleAnswer4(possibleAnswer4);
        this.setQuestion(question);
    }

    /**
     * PossibleAnswers question getter method
     * @return Question relates to PossibleAnswers
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * PossibleAnswers question setter method
     * @param question - Question relates to PossibleAnswers
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * PossibleAnswersDTO's possibleAnswer1 getter method
     * @return String PossibleAnswersDTO's possibleAnswer1
     */
    public String getPossibleAnswer1() {
        return possibleAnswer1;
    }

    /**
     * PossibleAnswerDTO's possibleAnswer1 setter method
     * @param possibleAnswer1 - String PossibleAnswersDTO's possibleAnswer1
     */
    public void setPossibleAnswer1(String possibleAnswer1) {
        this.possibleAnswer1 = possibleAnswer1;
    }

    /**
     * PossibleAnswersDTO's possibleAnswer2 getter method
     * @return String PossibleAnswersDTO's possibleAnswer2
     */
    public String getPossibleAnswer2() {
        return possibleAnswer2;
    }

    /**
     * PossibleAnswerDTO's possibleAnswer2 setter method
     * @param possibleAnswer2 - String PossibleAnswersDTO's possibleAnswer2
     */
    public void setPossibleAnswer2(String possibleAnswer2) {
        this.possibleAnswer2 = possibleAnswer2;
    }

    /**
     * PossibleAnswersDTO's possibleAnswer3 getter method
     * @return String PossibleAnswersDTO's possibleAnswer3
     */
    public String getPossibleAnswer3() {
        return possibleAnswer3;
    }

    /**
     * PossibleAnswerDTO's possibleAnswer3 setter method
     * @param possibleAnswer3 - String PossibleAnswersDTO's possibleAnswer3
     */
    public void setPossibleAnswer3(String possibleAnswer3) {
        this.possibleAnswer3 = possibleAnswer3;
    }

    /**
     * PossibleAnswersDTO's possibleAnswer4 getter method
     * @return String PossibleAnswersDTO's possibleAnswer4
     */
    public String getPossibleAnswer4() {
        return possibleAnswer4;
    }

    /**
     * PossibleAnswerDTO's possibleAnswer4 setter method
     * @param possibleAnswer4 - String PossibleAnswersDTO's possibleAnswer4
     */
    public void setPossibleAnswer4(String possibleAnswer4) {
        this.possibleAnswer4 = possibleAnswer4;
    }
}
