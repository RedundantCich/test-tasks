package com.gitlab.rmarzec.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageVerifier {
    private final WebDriver driver;

    public PageVerifier(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    private boolean isPageUrlExpected(String expectedPageUrl) {
        String currentUrl = getCurrentUrl();
        return currentUrl.equals(expectedPageUrl);
    }

    public void fixPageUrl(String requiredPageUrl) {
        if (!isPageUrlExpected(requiredPageUrl)) {
            driver.get(requiredPageUrl);
        }
    }
}
