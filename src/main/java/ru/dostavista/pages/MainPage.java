package ru.dostavista.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import ru.dostavista.AbstractPages;
import ru.dostavista.base.DriverHolder;
import ru.dostavista.model.LegalAccount;
import ru.dostavista.model.PersonAccount;
import ru.dostavista.waiters.WaitCondition;

import static org.testng.Assert.assertTrue;
import static ru.dostavista.utils.PropertiesReader.loadPropertyName;

/**
 * The class MainPage.
 */
public class MainPage extends AbstractPages {

    /**
     * The constant TITLE.
     */
    private static final String TITLE = "Курьерская служба доставки по Москве и Московской области";

    /**
     * The constant ENTER_REG.
     */
    private static final By ENTER_REG = By.id("react-login-btn--header-menu");

    /**
     * The constant PHONE.
     */
    private static final By PHONE = By.cssSelector("form[class='login-person-form'] input[name='phone']");

    /**
     * The constant PERSON_PASSWORD.
     */
    private static final By PERSON_PASSWORD = By.cssSelector("form[class='login-person-form'] input[name='password']");

    /**
     * The constant EMAIL.
     */
    private static final By EMAIL = By.cssSelector("div[class='login-legal-form__row'] input[name='email']");

    /**
     * The constant LEGAL_PASSWORD.
     */
    private static final By LEGAL_PASSWORD = By.cssSelector("div[class='login-legal-form__row'] input[name='password']");

    /**
     * The constant SUBMIT_PERSON.
     */
    private static final By SUBMIT_PERSON = By.cssSelector("div[class='login-person-form__row'] button[type='submit']");

    /**
     * The constant SUBMIT_LEGAL.
     */
    private static final By SUBMIT_LEGAL = By.cssSelector("div[class='login-legal-form__row'] button[type='submit']");

    /**
     * The constant PERSONAL_ACCOUNT.
     */
    private static final By PERSONAL_ACCOUNT = By.cssSelector("a[class='header-menu__item-btn']");

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
     * The constant ERROR_LEGAL_MESSAGE.
     */
    private static final By ERROR_LEGAL_MESSAGE = By.cssSelector("div[class='login-legal-form__form-error']");

    /**
     * The constant ERROR_LEGAL_TEXT.
     */
    private static final String ERROR_LEGAL_TEXT = "Пользователь с таким логином или паролем не найден";

    /**
     * The constant QUESTION.
     */
    private static final By QUESTION = By.cssSelector("form[class='reg-person-form'] p");

    /**
     * The constant FAST_QUESTION.
     */
    private static final String FAST_QUESTION = "Вопрос срочный?";

    /**
     * The constant ERROR_TEXT.
     */
    private static final String ERROR_TEXT = "Ошибка в номере телефона. Убедитесь, что указан мобильный номер телефона и его длина составляет 10 цифр.";

    /**
     * The default constructor.
     */
    public MainPage() {
        super();
        //empty
        return;
    }

    /**
     * Method navigateToUrl.
     *
     * @param url the url.
     * @return the main page.
     */
    public MainPage navigateToUrl(final String url) {
        navigateWebBrowser().to(loadPropertyName(url));
        return this;
    }

    /**
     * Method Check title page current convert page.
     *
     * @return the current convert page.
     */
    public MainPage checkTitlePage() {
        assertTrue(DriverHolder.getDriverThread().getTitle().contains(TITLE));

        return this;
    }

    /**
     * The method openLoginForm.
     *
     * @return the main page
     */
    public MainPage openLoginForm() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(ENTER_REG).click();

        return this;
    }

    /**
     * The method selectTypeAction.
     *
     * @param userAction the user type.
     * @return the main page.
     */
    public MainPage selectTypeAction(final UserAction userAction) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector(userAction.getTypeOfAction())).click();

        return this;
    }


    /**
     * The method selectTypeUser.
     *
     * @param userType the user type.
     * @return the main page.
     */
    public MainPage selectTypeUser(final UserType userType) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector(userType.getUserType())).click();
        return this;
    }

    /**
     * The method enterCredentialForNaturalPersonUser.
     *
     * @param personAccount the account.
     * @return the main page.
     */
    public MainPage enterCredentialForNaturalPersonUser(final PersonAccount personAccount) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).sendKeys(personAccount.getPhoneNumber());
        waitCondition.waitForVisibilityOfElementLocatedBy(PERSON_PASSWORD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PERSON_PASSWORD).sendKeys(personAccount.getPassword());
        waitCondition.waitForVisibilityOfElementLocatedBy(SUBMIT_PERSON).click();
        return this;
    }

    /**
     * The method enterCredentialForLegalEntityUser.
     *
     * @return the main page
     */
    public MainPage enterCredentialForLegalEntityUser(final LegalAccount legalAccount) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(EMAIL).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(EMAIL).sendKeys(legalAccount.getEmail());
        waitCondition.waitForVisibilityOfElementLocatedBy(LEGAL_PASSWORD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(LEGAL_PASSWORD).sendKeys(legalAccount.getPassword());
        waitCondition.waitForVisibilityOfElementLocatedBy(SUBMIT_LEGAL).click();
        return this;
    }

    /**
     * The method enterToPersonalAccount.
     *
     * @return the main page
     */
    public MainPage enterToPersonalAccount() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(PERSONAL_ACCOUNT).click();

        return this;
    }

    /**
     * The method clickLogOut.
     *
     * @return the main page.
     */
    public MainPage clickLogOut() {
        final WaitCondition waitCondition = new WaitCondition();
        final Actions builder = new Actions(DriverHolder.getDriverThread());
        builder.moveToElement(waitCondition.waitForVisibilityOfElementLocatedBy(USER_NAME)).build().perform();
        waitCondition.waitForVisibilityOfElementLocatedBy(LOG_OUT).click();

        return this;
    }

    /**
     * The method checkErrorMessageForPerson.
     *
     * @return the main page.
     */
    public MainPage checkErrorMessageForPerson() {
        final WaitCondition waitCondition = new WaitCondition();
        assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ERROR_MESSAGE).getText().contains(ERROR_TEXT));

        return this;
    }

    /**
     * The method checkErrorMessageForLegal.
     *
     * @return the main page.
     */
    public MainPage checkErrorMessageForLegal() {
        final WaitCondition waitCondition = new WaitCondition();
        assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ERROR_LEGAL_MESSAGE).getText().contains(ERROR_LEGAL_TEXT));

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
