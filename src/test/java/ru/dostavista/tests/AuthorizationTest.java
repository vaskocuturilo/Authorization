package ru.dostavista.tests;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.dostavista.base.BaseWeb;
import ru.dostavista.model.LegalAccount;
import ru.dostavista.model.PersonAccount;
import ru.dostavista.pages.MainPage;
import ru.dostavista.pages.UserAction;
import ru.dostavista.pages.UserType;
import ru.dostavista.userdata.ProvideData;

public class AuthorizationTest extends BaseWeb {

    @Test(dataProvider = "validCredentialForPerson", dataProviderClass = ProvideData.class)
    @Story("This is automation script for check that user can authorization with valid credential.")
    public void testAuthorizationWithValidData(PersonAccount account) {
        new MainPage()
                .navigateToUrl("url")
                .checkTitlePage()
                .openLoginForm()
                .selectTypeAction(UserAction.AUTHORIZATION)
                .enterCredentialForNaturalPersonUser(account)
                .enterToPersonalAccount()
                .clickLogOut();
    }

    @Test(dataProvider = "invalidCredentialForPerson", dataProviderClass = ProvideData.class)
    @Story("This is automation script for check that user can't authorization with invalid credential.")
    public void testAuthorizationWithInvalidData(PersonAccount account) {
        new MainPage()
                .navigateToUrl("url")
                .checkTitlePage()
                .openLoginForm()
                .selectTypeAction(UserAction.AUTHORIZATION)
                .enterCredentialForNaturalPersonUser(account)
                .checkErrorMessageForPerson();
    }

    @Test
    @Story("This is automation script for check that user can register with valid data.")
    public void testRegistrationWithValidData() {
        new MainPage()
                .navigateToUrl("url")
                .checkTitlePage()
                .openLoginForm()
                .selectTypeAction(UserAction.REGISTRATION)
                .checkRegisterPage()
                .enterRegisterData("DataForRegistration");
    }

    @Test
    @Story("This is automation script for check that user can't register with invalid data.")
    public void testRegistrationWithInvalidData() {
        new MainPage()
                .navigateToUrl("url")
                .checkTitlePage()
                .openLoginForm()
                .selectTypeAction(UserAction.REGISTRATION)
                .checkRegisterPage()
                .enterRegisterData("DataForRegistration")
                .checkErrorMessage();
    }

    @Test(dataProvider = "invalidCredentialForLegal", dataProviderClass = ProvideData.class)
    @Story("This is automation script for check that user can't authorization with invalid credential.")
    public void testAuthorizationLegalEntityWithInvalidData(final LegalAccount legalAccount) {
        new MainPage()
                .navigateToUrl("url")
                .checkTitlePage()
                .openLoginForm()
                .selectTypeUser(UserType.LEGAL_ENTITY)
                .enterCredentialForLegalEntityUser(legalAccount)
                .checkErrorMessageForLegal();
    }
}

