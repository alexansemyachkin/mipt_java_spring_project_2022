package ru.mipt.remotesession.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Class Role with fields id, users, name
 */
@Entity
public class Role implements GrantedAuthority {

    /** Field id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Field users with relation many-to-many */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    /** Field name */
    private String name;

    /**
     * Role's default constructor
     */
    public Role(){

    }

    /**
     * @param id - int Role's id
     * @param name - String Role's name
     */
    public Role(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    /**
     * Role's id getter method
     * @return int Role's id
     */
    public int getId() {
        return id;
    }

    /**
     * Role's id setter method
     * @param id - int Role's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Role's name getter method
     * @return String Role's name
     */
    public String getName() {
        return name;
    }

    /**
     * Role's name setter method
     * @param name - String Role's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Role's authority getter method
     * @return Role's name
     */
    @Override
    public String getAuthority() {
        return getName();
    }
}
