package ru.dostavista.browsers;

import org.openqa.selenium.remote.DesiredCapabilities;
import ru.dostavista.base.DriverHolder;

/**
 * The class Browser.
 */
public final class Browser {

    /**
     * The private constructor.
     */
    private Browser() {
    }

    /**
     * The method selectBrowser.
     *
     * @param nameBrowser this is value is browser name.
     */
    public static void selectBrowser(final String nameBrowser) {
        if ("Chrome".equalsIgnoreCase(nameBrowser)) {
            final Chrome chrome = new Chrome();
            final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            DriverHolder.setDriverThread(chrome.createDriver(capabilities));
        } else if ("Remote".equalsIgnoreCase(nameBrowser)) {
            final Remote remote = new Remote();
            final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            DriverHolder.setDriverThread(remote.createDriver(capabilities));
        } else {
            throw new IllegalStateException(" Browser " + nameBrowser + " not supported in this tests. ");
        }

    }
}
