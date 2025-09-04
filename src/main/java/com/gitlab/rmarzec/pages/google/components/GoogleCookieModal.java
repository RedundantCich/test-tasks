package com.gitlab.rmarzec.pages.google.components;

import com.gitlab.rmarzec.pages.commons.abstracts.AbstractCookieModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCookieModal extends AbstractCookieModal {
    // The two locators below will work on Polish IP,
    // for remote execution, worth rewriting the locators.
    @FindBy(xpath = "//button[contains(., 'Zaakceptuj wszystko')]")
    private WebElement acceptButton;

    @FindBy(xpath = "//h1[contains(., 'Zanim przejdziesz do Google')]")
    private WebElement cookieModalH1;

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElement cookieOverlay;

    public GoogleCookieModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected WebElement getAcceptButton() {
        return acceptButton;
    }

    @Override
    protected WebElement getCookieModalElement() {
        return cookieModalH1;
    }

    @Override
    protected WebElement getCookieOverlay() {
        return cookieOverlay;
    }
}
