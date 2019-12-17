package ru.dostavista.pages;

/**
 * The enum UserType.
 */
public enum UserType {

    /**
     * Authorization user type.
     */
    AUTHORIZATION("div[class*='sign-tabs']"),

    /**
     * Registration user type.
     */
    REGISTRATION("button[class='form-toggler']");

    /**
     * The private value typeOfAction.
     */
    private String typeOfAction;

    /**
     * The constructor.
     *
     * @param userAction this is userAction.
     */
    UserType(final String userAction) {
        this.typeOfAction = userAction;
    }

    /**
     * Getter.
     *
     * @return the type of action
     */
    public String getTypeOfAction() {
        return typeOfAction;
    }
}
