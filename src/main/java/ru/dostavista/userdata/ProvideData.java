package ru.dostavista.userdata;

import org.testng.annotations.DataProvider;
import ru.dostavista.model.Account;
import ru.dostavista.model.UserData;

/**
 * The class Provide data.
 */
public class ProvideData {

    /**
     * Method Invalid data object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "invalidCredential")
    public Object[][] invalidCredential() {
        return new Object[][]{
                new Object[]{new Account("test1", "test1")},
                new Object[]{new Account("test2", "test2")},
                new Object[]{new Account("test2", "test2")}};
    }

    /**
     * Method Valid credential object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "validCredential")
    public Object[][] validCredential() {
        return new Object[][]{
                new Object[]{new Account("99999999", "admin")}};
    }

    /**
     * Method Valid credential object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "validDataForRegister")
    public Object[][] validDataForRegister() {
        return new Object[][]{
                new Object[]{new UserData("TestUser", "Qwerty123456", "9999999999", "7890")}};
    }


}
