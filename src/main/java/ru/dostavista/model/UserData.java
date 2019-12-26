package ru.dostavista.model;

/**
 * The class Userdata.
 */
public class UserData {

    /**
     * The class firstName.
     */
    private String firstName;

    /**
     * The class password.
     */
    private String password;

    /**
     * The class phoneNumber.
     */
    private String phoneNumber;

    /**
     * The class checkCode.
     */
    private String checkCode;

    /**
     * The constructor.
     *
     * @param userFirstName   the first name.
     * @param userPassword    the password.
     * @param userPhoneNumber the phone number.
     * @param privateCode         the checkCode.
     */
    public UserData(final String userFirstName, final String userPassword, final String userPhoneNumber, final String privateCode) {
        this.firstName = userFirstName;
        this.password = userPassword;
        this.phoneNumber = userPhoneNumber;
        this.checkCode = privateCode;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets checkCode.
     *
     * @return the checkCode
     */
    public String getCheckCode() {
        return checkCode;
    }
}
