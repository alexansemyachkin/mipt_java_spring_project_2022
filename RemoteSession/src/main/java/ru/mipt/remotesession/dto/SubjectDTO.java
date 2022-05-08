package ru.mipt.remotesession.dto;

public class SubjectDTO {
    private int id;
    private String name;

    public SubjectDTO(){
    }

    public SubjectDTO(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
