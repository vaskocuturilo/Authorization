package ru.dostavista.pages;

import org.openqa.selenium.By;
import ru.dostavista.model.LegalAccount;
import ru.dostavista.waiters.WaitCondition;

import static org.testng.Assert.assertTrue;


/**
 * The class Legal page.
 */
public class LegalPage {

    /**
     * The constant EMAIL.
     */
    private static final By EMAIL = By.cssSelector("div[class='login-legal-form__row'] input[name='email']");

    /**
     * The constant PASSWORD.
     */
    private static final By PASSWORD = By.cssSelector("div[class='login-legal-form__row'] input[name='password']");

    /**
     * The constant SUBMIT.
     */
    private static final By SUBMIT = By.cssSelector("div[class='login-legal-form__row'] button[type='submit']");

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
        waitCondition.waitForVisibilityOfElementLocatedBy(EMAIL).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(EMAIL).sendKeys(legalAccount.getEmail());
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
}
