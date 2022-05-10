package ru.mipt.remotesession.dto;

/**
 * Class Subject with fields id, name
 */
public class SubjectDTO {

    /** Field id */
    private int id;

    /** Field name */
    private String name;

    /**
     * SubjectDTO's default constructor
     */
    public SubjectDTO(){
    }


    /**
     * Subject's  constructor
     * @param name SubjectDTO's name
     */
    public SubjectDTO(String name) {
        this.setName(name);
    }

    /**
     * SubjectDTO's id getter method
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * SubjectDTO's name getter method
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * SubjectDTO's id setter method
     * @param id - int Subject's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Subject'DTOs name setter method
     * @param name - String Subject's name
     */
    public void setName(String name) {
        this.name = name;
    }
}
