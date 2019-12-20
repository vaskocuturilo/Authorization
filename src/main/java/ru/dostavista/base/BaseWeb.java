package ru.dostavista.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.dostavista.AbstractPages;
import ru.dostavista.environment.Environment;

import static ru.dostavista.browsers.Browser.selectBrowser;

/**
 * The class Base web.
 */
public class BaseWeb {

    /**
     * Method beforeTest.
     */
    @BeforeClass(alwaysRun = true)
    public void beforeTest() {
        if (Environment.isCheckOperationSystem()) {
            selectBrowser("remote");
        } else {
            selectBrowser("Chrome");
        }
    }

    /**
     * Method afterTest.
     */
    @AfterClass(alwaysRun = true)
    public void afterTest() {
        AbstractPages.closeWebBrowser();
    }
}
