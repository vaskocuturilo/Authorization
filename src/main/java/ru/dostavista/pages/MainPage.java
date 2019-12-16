package ru.dostavista.pages;

import ru.dostavista.AbstractPages;

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
        navigateWebBrowser().to(url);
        return this;
    }


}
