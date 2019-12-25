package ru.dostavista.model;

/**
 * The class UserLTD.
 */
public class UserLTD {

    /**
     * The private value email.
     */
    private String email;

    /**
     * The private value password.
     */
    private String password;

    /**
     * The constructor.
     *
     * @param email    the email
     * @param password the password
     */
    public UserLTD(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * The getter.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * The getter.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
