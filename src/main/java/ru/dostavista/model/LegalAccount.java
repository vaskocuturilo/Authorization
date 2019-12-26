package ru.dostavista.model;

/**
 * The class LegalAccount.
 */
public class LegalAccount {

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
     * @param userEmail    the email
     * @param userPassword the password
     */
    public LegalAccount(final String userEmail, final String userPassword) {
        this.email = userEmail;
        this.password = userPassword;
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
