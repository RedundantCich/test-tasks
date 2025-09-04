package com.gitlab.rmarzec.pages.youtube.components;


import com.gitlab.rmarzec.pages.commons.abstracts.AbstractCookieModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubeCookieModal extends AbstractCookieModal {

    @FindBy(xpath = "//button[contains(., 'Accept all')]")
    private WebElement acceptButton;
    @FindBy(xpath = "//tp-yt-paper-dialog[@id='dialog']")
    private WebElement cookieModalCustomTag;
    @FindBy(tagName = "tp-yt-iron-overlay-backdrop")
    private WebElement cookieOverlay;

    public YoutubeCookieModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected WebElement getAcceptButton() {
        return acceptButton;
    }

    @Override
    protected WebElement getCookieModalElement() {
        return cookieModalCustomTag;
    }

    @Override
    protected WebElement getCookieOverlay() {
        return cookieOverlay;
    }

}
