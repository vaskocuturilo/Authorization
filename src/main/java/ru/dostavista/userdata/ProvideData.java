package ru.dostavista.userdata;

import org.testng.annotations.DataProvider;
import ru.dostavista.model.Account;

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
                new Object[]{new Account("999999999", "test1")},
                new Object[]{new Account("834986348", "toost2")},
                new Object[]{new Account("346346346", "taktak3")}};
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
    @DataProvider(name = "dataForApi")
    public Object[][] dataForApi() {
        return new Object[][]{
                new Object[]{new Account("TestUser", "Qwerty123456")}};
    }


}
