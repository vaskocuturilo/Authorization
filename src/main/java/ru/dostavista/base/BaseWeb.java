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
        Chrome chrome = new Chrome();
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        DriverHolder.setDriverThread(chrome.createDriver(desiredCapabilities));
    }

    /**
     * Method afterTest.
     */
    @AfterTest
    public void afterTest() {
        AbstractPages.closeWebBrowser();
    }
}
