package ru.dostavista.waiters;

import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

/**
 * The class Conditions.
 */
public final class Conditions {

    /**
     * The private constructor.
     */
    private Conditions() {
    }

    /**
     * Method shouldHave.
     *
     * @param element the element
     * @param text    the text
     */
    public static void shouldHave(final WebElement element, final String text) {
        assertEquals(element.getText(), text);
    }
}
