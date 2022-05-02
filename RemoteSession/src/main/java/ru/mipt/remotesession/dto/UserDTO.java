package ru.mipt.remotesession.dto;

/**
 * UserDTO class transferring data to Data Base with fields
 */
public class UserDTO {

    private String name;
    private String email;
    private int groupNumber;
    private String password;
    private int passedExamsAmount;
    private int passedExamsMarksSum;

    /**
     * UserDTO default constructor
     */
    public UserDTO() {
        this.setPassedExamsAmount(0);
        this.setPassedExamsMarksSum(0);
    }

    /**
     * UserDTO object constructor
     * @param name User's name
     * @param email User's email
     * @param groupNumber User's group number
     * @param password User's password
     */
    public UserDTO(String name, String email, int groupNumber, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setGroupNumber(groupNumber);
        this.setPassword(password);
        this.setPassedExamsAmount(0);
        this.setPassedExamsMarksSum(0);
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
