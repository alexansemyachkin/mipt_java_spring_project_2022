package ru.mipt.remotesession.models;


        import org.springframework.stereotype.Controller;

        import javax.persistence.*;
        import java.util.List;

/**
 * Class Question with fields id, questionToAnswer, rightAnswerIndex, subject, possibleAnswer
 */
@Entity
public class Question {
    /** Field id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Field questionToAnswer */
    private String questionToAnswer;

    /** Fiels rightAnswerIndex */
    private int rightAnswerIndex;

    /** Field subject with relation many-to-one */
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    /** Field possibleAnswer with relation one-to-one */
    @OneToOne(mappedBy = "question", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private PossibleAnswers possibleAnswer;


    /**
     * Question Object constructor
     * @param questionToAnswer Question's question to be answered
     * @param rightAnswerIndex Question's right answer index
     * @param subject Question's subject
     * @param possibleAnswers Question's possibleAnswers
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

    /**
     * Question's id setter method
     * @param id - int Question's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Question's subject getter method
     * @return Question's subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Question's subject setter method
     * @param subject - Subject Question's subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * Question's possibleAnswers getter method
     * @return Question's PossibleAnswers
     */
    public PossibleAnswers getPossibleAnswers() {
        return possibleAnswer;
    }

    /**
     * Question's possibleAnswers setter method
     * @param possibleAnswer - PossibleAnswers Question possibleAnswers
     */
    public void setPossibleAnswers(PossibleAnswers possibleAnswer) {
        this.possibleAnswer = possibleAnswer;
    }
}


