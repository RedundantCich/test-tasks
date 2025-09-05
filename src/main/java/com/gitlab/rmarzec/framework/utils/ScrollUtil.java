package com.gitlab.rmarzec.framework.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtil {
    private final JavascriptExecutor js;

    public ScrollUtil(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    /**
     * Scrolls the given element into view.
     *
     * @param element    WebElement to scroll into view
     * @param alignToTop true = align to top, false = align to bottom
     */
    public void scrollIntoView(WebElement element, boolean alignToTop) {
        js.executeScript("arguments[0].scrollIntoView(arguments[1]);", element, alignToTop);
    }
}