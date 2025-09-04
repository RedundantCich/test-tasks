package com.gitlab.rmarzec.pages.commons.abstracts;

import com.gitlab.rmarzec.pages.commons.interfaces.CookieHandler;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public abstract class AbstractCookieModal implements CookieHandler {
    protected static final Logger logger = Logger.getLogger(AbstractCookieModal.class.getName());
    protected final WebDriverWait wait;

    public AbstractCookieModal(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    protected abstract WebElement getAcceptButton();

    protected abstract WebElement getCookieModalElement();

    protected abstract WebElement getCookieOverlay();

    @Override
    public boolean isCookieModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(getCookieModalElement()));
            return true;
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    @Override
    public void acceptCookies() {
        if (isCookieModalDisplayed()) {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(getAcceptButton()));
            button.click();
            wait.until(ExpectedConditions.invisibilityOf(getCookieOverlay()));
        } else {
            logger.warning("No cookies modal detected");
        }
    }
}
