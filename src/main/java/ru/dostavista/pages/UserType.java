package ru.dostavista.pages;


/**
 * The enum UserType.
 */
public enum UserType {

    /**
     * Natural person user type.
     */
    NATURAL_PERSON("span[class*='-label--active']"),
    /**
     * Legal entity user type.
     */
    LEGAL_ENTITY("span[class='dostavista-tabs__tab-label']");

    /**
     * The private value userType.
     */
    private String userType;


    /**
     * The constructor UserType.
     * @param typeOfUser this is value userType.
     */
    UserType(final String typeOfUser) {
        this.userType = typeOfUser;
    }

    /**
     * Getter.
     *
     * @return the user type
     */
    public String getUserType() {
        return userType;
    }
}
