package com.gitlab.rmarzec.pages.w3schools.components;

import com.gitlab.rmarzec.pages.commons.abstracts.AbstractCookieModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3CookieModal extends AbstractCookieModal {
    @FindBy(xpath = "//div[@id='accept-choices']")
    private WebElement acceptButton;
    @FindBy(xpath = "//div[@id='snigel-cmp-framework']")
    private WebElement cookieModalDiv;
    @FindBy(xpath = "//div[@class='sn-v-table']")
    private WebElement cookieOverlay;

    public W3CookieModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected WebElement getAcceptButton() {
        return acceptButton;
    }

    @Override
    protected WebElement getCookieModalElement() {
        return cookieModalDiv;
    }

    @Override
    protected WebElement getCookieOverlay() {
        return cookieOverlay;
    }
}
