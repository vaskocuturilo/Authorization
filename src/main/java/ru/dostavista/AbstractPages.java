package ru.dostavista;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.dostavista.base.DriverHolder;

/**
 * The class Abstract AbstractPages.
 */
public abstract class AbstractPages {

    /**
     * Method navigateWebBrowser.
     *
     * @return the web driver . navigation
     */
    public WebDriver.Navigation navigateWebBrowser() {
        return DriverHolder.getDriverThread().navigate();
    }

    /**
     * Method getWindowTitle.
     *
     * @return the window title
     */
    public String getWindowTitle() {

        return DriverHolder.getDriverThread().getTitle();
    }


    /**
     * Method closeWebBrowser.
     */
    public static void closeWebBrowser() {
        DriverHolder.getDriverThread().manage().deleteAllCookies();
        DriverHolder.getDriverThread().close();
    }

    /**
     * Find element web element.
     *
     * @param locator this is locator of element.
     * @return the web element.
     */
    public WebElement findElement(final By locator) {
        return DriverHolder.getDriverThread().findElement(locator);
    }
}
