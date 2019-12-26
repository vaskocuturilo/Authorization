package ru.dostavista.userdata;

import org.testng.annotations.DataProvider;
import ru.dostavista.model.LegalAccount;
import ru.dostavista.model.PersonAccount;

/**
 * The class Provide data.
 */
public class ProvideData {

    /**
     * Method Invalid data object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "invalidCredentialForPerson")
    public Object[][] invalidCredentialForPerson() {
        return new Object[][]{
                new Object[]{new PersonAccount("999999999", "test1")},
                new Object[]{new PersonAccount("834986348", "toost2")},
                new Object[]{new PersonAccount("346346346", "taktak3")}};
    }

    /**
     * Method Valid credential object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "validCredentialForPerson")
    public Object[][] validCredentialForPerson() {
        return new Object[][]{
                new Object[]{new PersonAccount("9992343788", "qwerty123456")}};
    }

    /**
     * Method Valid credential object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "invalidCredentialForLegal")
    public Object[][] invalidCredentialForLegal() {
        return new Object[][]{
                new Object[]{new LegalAccount("testqatest@qa.team", "Qwerty123456")}};
    }

    /**
     * Method Valid credential object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "dataForApi")
    public Object[][] dataForApi() {
        return new Object[][]{
                new Object[]{new PersonAccount("TestUser", "Qwerty123456")}};
    }



}
