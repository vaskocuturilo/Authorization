package ru.dostavista.userdata;

import org.testng.annotations.DataProvider;
import ru.dostavista.model.User;

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
                new Object[]{new User("test1", "test1")},
                new Object[]{new User("test2", "test2")},
                new Object[]{new User("test2", "test2")}};
    }

    /**
     * Method Valid credential object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "validCredential")
    public Object[][] validCredential() {
        return new Object[][]{
                new Object[]{new User("admin", "admin")}};
    }

}
