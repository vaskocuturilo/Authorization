package ru.dostavista.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import ru.dostavista.base.DriverHolder;
import ru.dostavista.model.PersonAccount;
import ru.dostavista.waiters.WaitCondition;

import static org.testng.Assert.assertTrue;

/**
 * The class Person page.
 */
public class PersonPage {

    /**
     * The constant PHONE.
     */
    private static final By PHONE = By.cssSelector("form[class='login-person-form'] input[name='phone']");

    /**
     * The constant PASSWORD.
     */
    private static final By PASSWORD = By.cssSelector("form[class='login-person-form'] input[name='password']");

    /**
     * The constant PERSON.
     */
    private static final By PERSON = By.cssSelector("div[class='login-person-form__row'] button[type='submit']");

    /**
     * The constant ACCOUNT.
     */
    private static final By ACCOUNT = By.cssSelector("a[class='header-menu__item-btn']");

    /**
     * The constant USER_NAME.
     */
    private static final By USER_NAME = By.cssSelector("i[class*='dv-cabinet-icon--small'");

    /**
     * The constant LOG_OUT.
     */
    private static final By LOG_OUT = By.cssSelector("a[href*='logout']");

    /**
     * The constant ERROR_MESSAGE.
     */
    private static final By ERROR_MESSAGE = By.cssSelector("span[class*='error-item']");

    /**
     * The constant ERROR_TEXT.
     */
    private static final String ERROR_TEXT = "Ошибка в номере телефона. Убедитесь, что указан мобильный номер телефона и его длина составляет 10 цифр.";

    /**
     * The constant QUESTION.
     */
    private static final By QUESTION = By.cssSelector("form[class='reg-person-form'] p");

    /**
     * The constant FAST_QUESTION.
     */
    private static final String FAST_QUESTION = "Вопрос срочный?";


    /**
     * The method enterCredential.
     *
     * @param personAccount the account.
     * @return the main page.
     */
    public PersonPage enterCredential(final PersonAccount personAccount) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).sendKeys(personAccount.getPhoneNumber());
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).sendKeys(personAccount.getPassword());
        waitCondition.waitForVisibilityOfElementLocatedBy(PERSON).click();
        return this;
    }

    /**
     * The method enterAccount.
     *
     * @return the main page
     */
    public PersonPage enterAccount() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(ACCOUNT).click();

        return this;
    }

    /**
     * The method clickLogOut.
     *
     * @return the main page.
     */
    public PersonPage clickLogOut() {
        final WaitCondition waitCondition = new WaitCondition();
        final Actions builder = new Actions(DriverHolder.getDriverThread());
        builder.moveToElement(waitCondition.waitForVisibilityOfElementLocatedBy(USER_NAME)).build().perform();
        waitCondition.waitForVisibilityOfElementLocatedBy(LOG_OUT).click();

        return this;
    }

    /**
     * The method checkErrorMessage.
     *
     * @return the main page.
     */
    public PersonPage checkErrorMessage() {
        final WaitCondition waitCondition = new WaitCondition();
        assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ERROR_MESSAGE).getText().contains(ERROR_TEXT));

        return this;
    }

    /**
     * The method checkRegisterPage.
     *
     * @return the register page.
     */
    public RegisterPage checkRegisterPage() {
        final WaitCondition waitCondition = new WaitCondition();
        assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(QUESTION).getText().contains(FAST_QUESTION));

        return new RegisterPage();
    }


}
