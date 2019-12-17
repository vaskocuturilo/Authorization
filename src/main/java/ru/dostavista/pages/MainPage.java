package ru.dostavista.pages;

import org.openqa.selenium.By;
import ru.dostavista.AbstractPages;
import ru.dostavista.base.DriverHolder;
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
}
