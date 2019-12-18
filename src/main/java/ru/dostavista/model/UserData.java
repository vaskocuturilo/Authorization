package ru.dostavista.model;


/**
 * The class Userdata.
 */
public class UserData {

    private String firstName;
    private String password;
    private String phoneNumber;
    private String sms;

    /**
     * The constructor.
     *
     * @param firstName   the first name.
     * @param password    the password.
     * @param phoneNumber the phone number.
     * @param sms         the sms.
     */
    public UserData(String firstName, String password, String phoneNumber, String sms) {
        this.firstName = firstName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sms = sms;
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
     * Gets sms.
     *
     * @return the sms
     */
    public String getSms() {
        return sms;
    }
}
