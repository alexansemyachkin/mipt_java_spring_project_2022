package ru.mipt.remotesession.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Class User with fields id, name, email, groupNumber,
 * password, passedExamsAmount, passedExamsSum, averageMark,
 * roles
 */
@Entity
public class User {

    /** Field id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    /** Field name */
    private String name;

    /** Field email */
    private String email;

    /** Field groupNumber */
    private int groupNumber;

    /** Field password */
    private String password;

    /** Field passedExamsAmount */
    private int passedExamsAmount;

    /** Field passedExamsMarksSum */
    private int passedExamsMarksSum;

    /** Field averageMark */
    private BigDecimal averageMark;

   /** Field roles with relation many-to-many */
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;


    /**
     * User object constructor
     * @param id User's id
     * @param name User's name
     * @param email User's email
     * @param groupNumber User's froupNumber
     * @param password User's password
     * @param passedExamsAmount User's passedExamsAmount
     * @param passedExamsMarksSum User's passedExamsMarksSum
     * @param averageMark User's averageMark
     */
    public User(int id, String name, String email, int groupNumber, String password, int passedExamsAmount, int passedExamsMarksSum, BigDecimal averageMark){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setGroupNumber(groupNumber);
        this.setPassword(password);
        this.setPassedExamsAmount(passedExamsAmount);
        this.setPassedExamsMarksSum(passedExamsMarksSum);
        this.setAverageMark(averageMark);
    }

    /**
     * User object constructor
     * @param name User's name
     * @param email User's email
     * @param groupNumber User's group number
     * @param password User's password
     */
    public User(String name, String email, int groupNumber, String password, Collection<Role> roles){
        this.setName(name);
        this.setEmail(email);
        this.setGroupNumber(groupNumber);
        this.setPassword(password);
        this.setPassedExamsAmount(0);
        this.setPassedExamsMarksSum(0);
        this.setRoles(roles);
    }


    /**
     * User default constructor
     */
    public User() {
        this.setPassedExamsAmount(0);
        this.setPassedExamsMarksSum(0);
    }


    /**
     * User's averageMark getter method
     * @return BigDecimal averageMark
     */
    public BigDecimal getAverageMark() {
        return averageMark;
    }

    /**
     * User's averageMark setter method
     * @param averageMark - BigDecimal User's averageMark
     */
    public void setAverageMark(BigDecimal averageMark) {
        this.averageMark = averageMark;
    }

    /**
     * User's roles getter method
     * @return Set<Roles> roles
     */
    public Collection<Role> getRoles() {
        return roles.stream().toList();
    }

    /**
     * User's roles setter method
     * @param roles - List<Roles> User's roles
     */
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    /**
     * User's id getter method
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * User's id setter method
     * @param id - int User's id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * User's name getter method
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * User's name setter method
     * @param name - String User's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * User's email getter method
     * @return String email
     */
    public String getEmail() {
        return email;
    }


    /**
     * User's email setter method
     * @param email - String User's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * User's password getter method
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * User's password setter method
     * @param password - String User's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * User's groupNumber getter method
     * @return int groupNumber
     */
    public int getGroupNumber() {
        return groupNumber;
    }


    /**
     * User's groupNumber setter method
     * @param groupNumber - int User's groupNumber
     */
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    /**
     * User's PassedExamsAccount getter method
     * @return int getPassedExamsAmount
     */
    public int getPassedExamsAmount() {
        return passedExamsAmount;
    }


    /**
     * User passedExamsAmount setter method
     * @param passedExamsAmount - int User's id
     */
    public void setPassedExamsAmount(int passedExamsAmount) {
        this.passedExamsAmount = passedExamsAmount;
    }

    /**
     * User's passedExamsMarksSum getter method
     * @return int PassedExamsMarksSum
     */
    public int getPassedExamsMarksSum() {
        return passedExamsMarksSum;
    }

    /**
     * User's passedExamsMarksSum setter method
     * @param passedExamsMarksSum - int User's passedExamsMarksSum
     */
    public void setPassedExamsMarksSum(int passedExamsMarksSum) {
        this.passedExamsMarksSum = passedExamsMarksSum;
    }
}
