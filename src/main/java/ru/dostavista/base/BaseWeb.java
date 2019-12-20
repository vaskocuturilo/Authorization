package ru.dostavista.base;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.dostavista.AbstractPages;
import ru.dostavista.browsers.Chrome;

/**
 * The class Base web.
 */
public class BaseWeb {

    /**
     * Method beforeTest.
     */
    @BeforeClass(alwaysRun = true)
    public void beforeTest() {
        final Chrome chrome = new Chrome();
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        DriverHolder.setDriverThread(chrome.createDriver(capabilities));
    }

    /**
     * Method afterTest.
     */
    @AfterClass(alwaysRun = true)
    public void afterTest() {
        AbstractPages.closeWebBrowser();
    }
}
