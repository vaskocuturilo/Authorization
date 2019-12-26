package ru.dostavista.model;

/**
 * The class LegalRegisterData.
 */
public class LegalRegisterData {

    /**
     * The private value firstName.
     */
    private String firstName;

    /**
     * The private value email.
     */
    private String email;

    /**
     * The private value phoneNumber.
     */
    private String phoneNumber;

    /**
     * The constructor.
     *
     * @param userFirstName   this is firstName value.
     * @param userEmail       this is email value.
     * @param userPhoneNumber this is  phoneNumber value.
     */
    public LegalRegisterData(final String userFirstName, final String userEmail, final String userPhoneNumber) {
        this.firstName = userFirstName;
        this.email = userEmail;
        this.phoneNumber = userPhoneNumber;
    }

    /**
     * Getter.
     *
     * @return firstName field.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter.
     *
     * @return email field.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter.
     *
     * @return phoneNumber field.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
