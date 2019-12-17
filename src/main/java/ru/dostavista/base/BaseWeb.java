package ru.dostavista.base;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ru.dostavista.AbstractPages;
import ru.dostavista.browsers.Chrome;


/**
 * The class Base web.
 */
public class BaseWeb {

    /**
     * Method beforeTest.
     */
    @BeforeTest
    public void beforeTest() {
        final Chrome chrome = new Chrome();
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        DriverHolder.setDriverThread(chrome.createDriver(capabilities));
    }

    /**
     * Method afterTest.
     */
    @AfterTest
    public void afterTest() {
        AbstractPages.closeWebBrowser();
    }
}
