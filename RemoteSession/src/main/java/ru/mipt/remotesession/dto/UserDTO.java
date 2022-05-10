package ru.mipt.remotesession.dto;

import ru.mipt.remotesession.models.Role;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

/**
 * UserDTO class transferring data to Data Base with fields id, name, email, groupNumber,
 *  * password, passedExamsAmount, passedExamsSum, averageMark,
 *  * roles
 */
public class UserDTO {

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
    private Set<Role> roles;

    /**
     * UserDTO object constructor
     * @param name User's name
     * @param email User's email
     * @param groupNumber User's group number
     * @param password User's password
     * @param roles User's roles
     * @param averageMark User's averageMark
     */
    public UserDTO(int id, String name, String email, int groupNumber, String password, int passedExamsAmount, int passedExamsMarksSum, Set<Role> roles, BigDecimal averageMark) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setGroupNumber(groupNumber);
        this.setPassword(password);
        this.setPassedExamsAmount(passedExamsAmount);
        this.setPassedExamsMarksSum(passedExamsMarksSum);
        this.setRoles(roles);
        this.setAverageMark(averageMark);
    }

    /**
     * UserDTO default constructor
     */
    public UserDTO() {
        this.setPassedExamsAmount(0);
        this.setPassedExamsMarksSum(0);
    }

    /**
     * UserDTO's roles getter method
     * @return Set<Roles> roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * UserDTO's roles setter method
     * @param roles - Set<Roles> User's roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * User'DTOs averageMark getter method
     * @return BigDecimal averageMark
     */
    public BigDecimal getAverageMark() {
        return averageMark;
    }

    /**
     * UserDTO's averageMark setter method
     * @param averageMark - BigDecimal User's averageMark
     */
    public void setAverageMark(BigDecimal averageMark) {
        this.averageMark = averageMark;
    }

    /**
     * UserDTO's id getter method
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * UserDTO's id setter method
     * @param id - int User's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * UserDTO's name getter method
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * UseDTOr's name setter method
     * @param name - String UserDTO's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * UserDTO's email getter method
     * @return String email
     */
    public String getEmail() {
        return email;
    }


    /**
     * UserDTO's email setter method
     * @param email - String User's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * UserDTO's password getter method
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * UserDTO's password setter method
     * @param password - String UserDTO's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * UserDTO's groupNumber getter method
     * @return int groupNumber
     */
    public int getGroupNumber() {
        return groupNumber;
    }


    /**
     * UserDTO's groupNumber setter method
     * @param groupNumber - int UserDTO's groupNumber
     */
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    /**
     * UserDTO's PassedExamsAccount getter method
     * @return int getPassedExamsAmount
     */
    public int getPassedExamsAmount() {
        return passedExamsAmount;
    }


    /**
     * UserDTO's passedExamsAmount setter method
     * @param passedExamsAmount - int UserDTO's passedExamsAmount
     */
    public void setPassedExamsAmount(int passedExamsAmount) {
        this.passedExamsAmount = passedExamsAmount;
    }

    /**
     * UserDTO's passedExamsMarksSum getter method
     * @return int PassedExamsMarksSum
     */
    public int getPassedExamsMarksSum() {
        return passedExamsMarksSum;
    }

    /**
     * UserDTO's passedExamsMarksSum setter method
     * @param passedExamsMarksSum - int UserDTO's passedExamsMarksSum
     */
    public void setPassedExamsMarksSum(int passedExamsMarksSum) {
        this.passedExamsMarksSum = passedExamsMarksSum;
    }
}
