package ru.dostavista.model;

/**
 * The class Account.
 */
public class Account {

    /**
     * The private value phoneNumber.
     */
    private String phoneNumber;

    /**
     * The private value password.
     */
    private String password;

    /**
     * Constructor Account.
     *
     * @param firstName this is user phoneNumber.
     * @param lastName  this is  user password.
     */
    public Account(final String firstName, final String lastName) {
        this.phoneNumber = firstName;
        this.password = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getPassword() {
        return password;
    }
}
