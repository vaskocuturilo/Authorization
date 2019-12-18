package ru.dostavista.tests;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.dostavista.base.BaseWeb;
import ru.dostavista.model.Account;
import ru.dostavista.pages.MainPage;
import ru.dostavista.pages.UserType;
import ru.dostavista.userdata.ProvideData;

public class AuthorizationTest extends BaseWeb {

    @Test(dataProvider = "validCredential", dataProviderClass = ProvideData.class)
    @Story("This is automation script for check that user can authorization with valid credential.")
    public void testAuthorizationWithValidData(Account account) {
        new MainPage()
                .navigateToUrl("url")
                .checkTitlePage()
                .openLoginForm()
                .selectTypeAction(UserType.AUTHORIZATION)
                .enterCredential(account);
    }

    @Test(dataProvider = "invalidCredential", dataProviderClass = ProvideData.class)
    @Story("This is automation script for check that user can authorization with invalid credential.")
    public void testAuthorizationWithInvalidData(Account account){
        new MainPage()
                .navigateToUrl("url")
                .checkTitlePage()
                .openLoginForm()
                .selectTypeAction(UserType.AUTHORIZATION)
                .enterCredential(account)
                .checkErrorMessage();
    }
}
