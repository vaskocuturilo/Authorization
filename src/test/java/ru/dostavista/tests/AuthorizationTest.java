package ru.dostavista.tests;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.dostavista.base.BaseWeb;
import ru.dostavista.pages.MainPage;

public class AuthorizationTest extends BaseWeb {

    @Test
    @Story("This is automation script for check that user can authorization with valid credential.")
    public void testAuthorizationOnMainPage(){
        new MainPage()
                .navigateToUrl("https://test.dostavista.ru/");
    }
}
