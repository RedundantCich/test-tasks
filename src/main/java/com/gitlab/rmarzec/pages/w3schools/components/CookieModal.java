package com.gitlab.rmarzec.pages.w3schools.components;

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

    @FindBy(xpath = "//div[@id='accept-choices']")
    private WebElement acceptButton;
    @FindBy(xpath = "//div[@id='snigel-cmp-framework']")
    private WebElement cookieModalDiv;

    public CookieModal(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isCookieModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cookieModalDiv));
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
            logger.info("No cookies modal detected in w3School");
            System.out.println("No cookies modal detected in w3School");
        }
    }
}
