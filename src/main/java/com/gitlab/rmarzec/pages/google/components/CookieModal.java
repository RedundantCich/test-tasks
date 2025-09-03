package com.gitlab.rmarzec.pages.google.components;

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
    private final WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(CookieModal.class);

    // This xpath will work only on Polish IP as Google bases the search language
    // on IP. If the tests are to be run on a remote then improvements will be necessary
    @FindBy(xpath = "//button[contains(., 'Zaakceptuj wszystko')]")
    private WebElement acceptButton;
    @FindBy(xpath = "//h1[contains(., 'Zanim przejdziesz do Google')]")
    private WebElement cookieModalH1;

    public CookieModal(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isCookieModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cookieModalH1));
            return true;
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    @Override
    public void acceptCookies() {
        if (isCookieModalDisplayed()) {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
            button.click();
        } else {
            logger.info("No cookies modal detected on Google page");
            System.out.println("No cookies modal detected on Google page");
        }
    }
}
