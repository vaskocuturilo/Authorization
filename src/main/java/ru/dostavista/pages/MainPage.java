package ru.dostavista.pages;

import org.testng.Assert;
import ru.dostavista.AbstractPages;

import static ru.dostavista.utils.PropertiesReader.loadPropertyName;

/**
 * The class MainPage.
 */
public class MainPage extends AbstractPages {

    /**
     * Method navigateToUrl.
     *
     * @param url the url
     * @return the main page
     */
    public MainPage navigateToUrl(final String url) {
        navigateWebBrowser().to(loadPropertyName(url));
        return this;
    }

    /**
     * Method Check title page current convert page.
     *
     * @param titleName the title name.
     * @return the current convert page.
     */
    public MainPage checkTitlePage(final String titleName) {
        Assert.assertEquals(getWindowTitle(), loadPropertyName(titleName));

        return this;
    }


}
