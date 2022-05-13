package ru.mipt.remotesession.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Subject with fields id, name, questionList
 */
@Entity
public class Subject {
    /** Field id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Field name */
    private String name;


    /** Field questionList with relation one-to-many */
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questionList;


    /**
     * Subject's default constructor
     */
    public Subject(){
        this.setName("");
        this.setQuestionList(new ArrayList<>());
    }

    /**
     * Subject's constructor for adding to Database
     * @param name - String Subject's name
     */
    public Subject(String name){
        this.setName(name);
    }

    /**
     * Subject's id getter method
     * @return int id
     */
    public int getId() {
        return id;
    }


    /**
     * Subject's name getter method
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Subject's name setter method
     * @param name - String Subject's name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Subject questionList getter method
     * @return List of Question objects related to Subject
     */
    public List<Question> getQuestionList() {
        return questionList;
    }


    /**
     * Subject questionList setter method
     * @param questionList - List of Question objects
     */
    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
