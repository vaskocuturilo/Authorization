package ru.dostavista.model;

/**
 * The class User.
 */
public class User {

    /**
     * The private value firstName.
     */
    private String firstName;

    /**
     * The private value lastName.
     */
    private String lastName;

    /**
     * Constructor User.
     *
     * @param firstName this is user firstName.
     * @param lastName  this is  user lastName.
     */
    public User(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }
}
