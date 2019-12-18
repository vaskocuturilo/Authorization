package ru.dostavista.pages;

import org.openqa.selenium.By;
import ru.dostavista.AbstractPages;
import ru.dostavista.base.DriverHolder;
import ru.dostavista.model.Account;
import ru.dostavista.model.UserData;
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
     * The constant PASSWORD.
     */
    private static final By PASSWORD = By.cssSelector("form[class='login-person-form'] input[name='password']");

    /**
     * The constant SUBMIT.
     */
    private static final By SUBMIT = By.cssSelector("div[class='login-person-form__row'] button[type='submit']");

    /**
     * The constant ERROR_MESSAGE.
     */
    private static final By ERROR_MESSAGE = By.cssSelector("span[class*='error-item']");

    /**
     * The constant FIRST_NAME.
     */
    private static final By FIRST_NAME = By.cssSelector("div[class='reg-person-form__row'] input[name='name']");

    /**
     * The constant REGISTER.
     */
    private static final By REGISTER = By.cssSelector("div[class='reg-person-form__row'] button[type='submit'");

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
     * @param userType the user type.
     * @return the main page.
     */
    public MainPage selectTypeAction(final UserType userType) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector(userType.getTypeOfAction())).click();

        return this;
    }


    /**
     * The method enterCredential.
     *
     * @param account the account.
     * @return the main page.
     */
    public MainPage enterCredential(final Account account) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).sendKeys(account.getPhoneNumber());
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).sendKeys(account.getPassword());
        waitCondition.waitForVisibilityOfElementLocatedBy(SUBMIT).click();

        return this;
    }


    /**
     * The method checkErrorMessage.
     *
     * @return the main page.
     */
    public MainPage checkErrorMessage() {
        final WaitCondition waitCondition = new WaitCondition();
        assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ERROR_MESSAGE).getText().contains(ERROR_TEXT));

        return this;
    }


    /**
     * The method enterRegisterData.
     *
     * @param userData the user data.
     * @return the main page.
     */
    public MainPage enterRegisterData(final UserData userData) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(FIRST_NAME).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(FIRST_NAME).sendKeys(userData.getFirstName());
        waitCondition.waitForVisibilityOfElementLocatedBy(REGISTER).click();

        return this;
    }
}
