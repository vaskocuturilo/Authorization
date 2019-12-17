package ru.dostavista.pages;

import ru.dostavista.AbstractPages;
import ru.dostavista.base.DriverHolder;

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
     * @return the current convert page.
     */
    public MainPage checkTitlePage() {
        assertTrue(DriverHolder.getDriverThread().getTitle().contains(TITLE));

        return this;
    }
}
