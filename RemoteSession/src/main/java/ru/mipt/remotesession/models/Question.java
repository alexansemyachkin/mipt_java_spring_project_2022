package ru.mipt.remotesession.models;


import javax.persistence.*;
import java.util.List;

/**
 * Class Question with fields id, questionToAnswer, rightAnswerIndex
 */
@Entity
public class Question {
    /** Field id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Field  questionToAnswer */
    private String questionToAnswer;

    /** Field rightAnswerIndex */
    private int rightAnswerIndex;

    /** Field subject with relation many-to-one */
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    /** Field possibleAnswers with relation one-to-many */
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PossibleAnswers> possibleAnswers;


    /**
     * Question Object constructor
     * @param questionToAnswer Question's question to be answered
     * @param rightAnswerIndex Question's right answer index
     */
    public Question(String questionToAnswer, int rightAnswerIndex){
        this.setQuestionToAnswer(questionToAnswer);
        this.setRightAnswerIndex(rightAnswerIndex);
    }

    /**
     * Question default constructor
     */
    public Question() {
    }

    /**
     * Question's id getter method
     * @return int Question's id
     */
    public int getId() {
        return id;
    }

    /**
     * Question's questionToAnswer getter method
     * @return String questionToAnswer
     */
    public String getQuestionToAnswer() {
        return questionToAnswer;
    }

    /**
     * Question's questionToAnswer setter method
     * @param questionToAnswer - String Question's questionToAnswer
     */
    public void setQuestionToAnswer(String questionToAnswer) {
        this.questionToAnswer = questionToAnswer;
    }

    /**
     * Question's rightAnswerIndex getter method
     * @return int Question's rightAnswerIndex
     */
    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    /**
     * Question's questionToAnswer setter method
     * @param rightAnswerIndex - int Question's rightAnswerIndex
     */
    public void setRightAnswerIndex(int rightAnswerIndex) {
        this.rightAnswerIndex = rightAnswerIndex;
    }

}

