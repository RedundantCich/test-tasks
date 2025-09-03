package com.gitlab.rmarzec.pages.youtube.components;


import com.gitlab.rmarzec.pages.interfaces.CookieHandler;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookieModal implements CookieHandler {
    private static final Logger logger = Logger.getLogger(CookieModal.class);
    private final WebDriverWait wait;
    @FindBy(xpath = "//button[contains(., 'Accept all')]")
    private WebElement acceptButton;
    @FindBy(xpath = "//tp-yt-paper-dialog[@id='dialog']")
    private WebElement cookieModalCustomTag;
    @FindBy(tagName = "tp-yt-iron-overlay-backdrop")
    private WebElement cookieOverlay;

    public CookieModal(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isCookieModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cookieModalCustomTag));
            return true;
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    private void waitForCookieModalToDisappear() {
        wait.until(ExpectedConditions.invisibilityOf(cookieOverlay));
    }

    @Override
    public void acceptCookies() {
        if (isCookieModalDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
            acceptButton.click();
            waitForCookieModalToDisappear();
        } else {
            logger.info("No cookies modal detected on page");
            System.out.println("No cookies modal detected on page");
        }
    }
}
