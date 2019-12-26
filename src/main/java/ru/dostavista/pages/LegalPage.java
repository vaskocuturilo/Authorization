package ru.dostavista.pages;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import ru.dostavista.model.LegalAccount;
import ru.dostavista.model.LegalRegisterData;
import ru.dostavista.utils.PropertiesReader;
import ru.dostavista.waiters.WaitCondition;

import static java.lang.String.format;
import static org.testng.Assert.assertTrue;


/**
 * The class Legal page.
 */
public class LegalPage {

    /**
     * The constant NAME.
     */
    private static final By NAME = By.cssSelector("div[class='reg-legal-form__row'] input[name='name']");

    /**
     * The constant LOGIN_EMAIL.
     */
    private static final By LOGIN_EMAIL = By.cssSelector("div[class='login-legal-form__row'] input[name='email']");

    /**
     * The constant REG_EMAIL.
     */
    private static final By REG_EMAIL = By.cssSelector("div[class='reg-legal-form__row'] input[name='email']");


    /**
     * The constant PASSWORD.
     */
    private static final By PASSWORD = By.cssSelector("div[class='login-legal-form__row'] input[name='password']");

    /**
     * The constant PHONE.
     */
    private static final By PHONE = By.cssSelector("div[class='reg-legal-form__row'] input[name='phone']");

    /**
     * The constant PHONE.
     */
    private static final By PHONE_ALT = By.cssSelector("div[class='reg-legal-form__row'] input[name='phone_alt']");

    /**
     * The constant SUBMIT.
     */
    private static final By SUBMIT = By.cssSelector("div[class='login-legal-form__row'] button[type='submit']");

    /**
     * The constant REGISTER.
     */
    private static final By REGISTER = By.cssSelector("div[class='reg-legal-form__row'] button[type='submit']");

    /**
     * The constant ERROR_MESSAGE.
     */
    private static final By ERROR_MESSAGE = By.cssSelector("div[class='login-legal-form__form-error']");

    /**
     * The constant ERROR_TEXT.
     */
    private static final String ERROR_TEXT = "Пользователь с таким логином или паролем не найден";

    /**
     * The method enterCredential.
     *
     * @param legalAccount the legal account
     * @return the main page
     */
    public LegalPage enterCredential(final LegalAccount legalAccount) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(LOGIN_EMAIL).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(LOGIN_EMAIL).sendKeys(legalAccount.getEmail());
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).sendKeys(legalAccount.getPassword());
        waitCondition.waitForVisibilityOfElementLocatedBy(SUBMIT).click();
        return this;
    }

    /**
     * The method checkErrorMessage.
     *
     * @return the main page.
     */
    public LegalPage checkErrorMessage() {
        final WaitCondition waitCondition = new WaitCondition();
        assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ERROR_MESSAGE).getText().contains(ERROR_TEXT));

        return this;
    }

    /**
     * The method selectTypeAction.
     *
     * @param userAction the user type.
     * @return the main page.
     */
    public LegalPage selectTypeAction(final UserAction userAction) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector(userAction.getTypeOfAction())).click();

        return this;
    }

    /**
     * The method enterRegisterData.
     *
     * @param jsonFile this is String data. Need for getJsonData method.
     * @return the main page.
     */
    public LegalPage enterRegisterData(final String jsonFile) {
        final LegalRegisterData registerData = getJsonData(jsonFile);
        final WaitCondition waitCondition = new WaitCondition();

        waitCondition.waitForVisibilityOfElementLocatedBy(NAME).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(NAME).sendKeys(registerData.getFirstName());

        waitCondition.waitForVisibilityOfElementLocatedBy(REG_EMAIL).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(REG_EMAIL).sendKeys(registerData.getEmail());

        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).sendKeys(registerData.getPhoneNumber());

        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE_ALT).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE_ALT).sendKeys(registerData.getPhoneNumber());

        waitCondition.waitForVisibilityOfElementLocatedBy(REGISTER).click();

        return this;
    }

    /**
     * The method getJsonData.
     *
     * @param jsonFileName this json file.
     * @return json data.
     */
    private static LegalRegisterData getJsonData(final String jsonFileName) {
        final String pathToFolder = PropertiesReader.getResourceAsString(format("user/%s.json", jsonFileName));
        return new Gson().fromJson(pathToFolder, LegalRegisterData.class);
    }
}
