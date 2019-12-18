package ru.dostavista.pages;

import org.openqa.selenium.By;
import ru.dostavista.model.UserData;
import ru.dostavista.waiters.WaitCondition;

import static org.testng.Assert.assertTrue;

/**
 * The type Register page.
 */
public class RegisterPage {

    /**
     * The constant FIRST_NAME.
     */
    private static final By FIRST_NAME = By.cssSelector("div[class='reg-person-form__row'] input[name='name']");

    /**
     * The constant PASSWORD.
     */
    private static final By PASSWORD = By.cssSelector("div[class='reg-person-form__row'] input[name='password']");

    /**
     * The constant PHONE.
     */
    private static final By PHONE = By.cssSelector("div[class='reg-person-form__row'] input[name='phone']");

    /**
     * The constant CODE.
     */
    private static final By CODE = By.cssSelector("div[class='reg-person-form__row'] input[name='code']");

    /**
     * The constant REGISTER.
     */
    private static final By REGISTER = By.cssSelector("div[class='reg-person-form__row'] button[type='submit'");

    /**
     * The constant ERROR_FIELD.
     */
    private static final By ERROR_FIELD = By.cssSelector("span[class='r-input__sub-field error-item']");

    /**
     * The constant TEXT.
     */
    private static final String TEXT = "Пожалуйста, подтвердите Ваш телефонный номер, прежде чем продолжить";

    /**
     * The method enterRegisterData.
     *
     * @param userData the user data.
     * @return the main page.
     */
    public RegisterPage enterRegisterData(final UserData userData) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(FIRST_NAME).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(FIRST_NAME).sendKeys(userData.getFirstName());
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).sendKeys(userData.getPassword());
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).sendKeys(userData.getPhoneNumber());
        waitCondition.waitForVisibilityOfElementLocatedBy(CODE).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(CODE).sendKeys(userData.getCode());
        waitCondition.waitForVisibilityOfElementLocatedBy(REGISTER).click();

        return this;
    }


    /**
     * The method checkErrorMessage.
     *
     * @return the register page
     */
    public RegisterPage checkErrorMessage() {
        final WaitCondition waitCondition = new WaitCondition();
        assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ERROR_FIELD).getText().contains(TEXT));

        return this;
    }


}
