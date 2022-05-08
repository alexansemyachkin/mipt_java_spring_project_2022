package ru.mipt.remotesession.models;


        import org.springframework.stereotype.Controller;

        import javax.persistence.*;
        import java.util.List;

/**
 * Class Question with fields id, questionToAnswer, rightAnswerIndex
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String questionToAnswer;

    private int rightAnswerIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @OneToOne(mappedBy = "question", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private PossibleAnswers possibleAnswer;


    /**
     * Question Object constructor
     * @param questionToAnswer Question's question to be answered
     * @param rightAnswerIndex Question's right answer index
     */
    public Question(String questionToAnswer, int rightAnswerIndex, Subject subject,
                    PossibleAnswers possibleAnswers) {
        this.setQuestionToAnswer(questionToAnswer);
        this.setRightAnswerIndex(rightAnswerIndex);
        this.setPossibleAnswers(possibleAnswers);
        this.setSubject(subject);
    }
    /**
     * Question default constructor
     */
    public Question() {
    }

    /** Field id */ /**
     * Question's id getter method
     * @return int Question's id
     */
    public int getId() {
        return id;
    }

    /** Field  questionToAnswer */ /**
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

    /** Field rightAnswerIndex */ /**
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

    public void setId(int id) {
        this.id = id;
    }

    /** Field subject with relation many-to-one */
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /** Field possibleAnswers with relation one-to-many */
    public PossibleAnswers getPossibleAnswers() {
        return possibleAnswer;
    }

    public void setPossibleAnswers(PossibleAnswers possibleAnswer) {
        this.possibleAnswer = possibleAnswer;
    }
}


