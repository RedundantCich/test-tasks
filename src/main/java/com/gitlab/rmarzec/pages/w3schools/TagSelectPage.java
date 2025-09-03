package com.gitlab.rmarzec.pages.w3schools;

import com.gitlab.rmarzec.framework.utils.WaitUtil;
import com.gitlab.rmarzec.pages.w3schools.components.CookieModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TagSelectPage {
    private final WebDriverWait wait;
    @Getter
    private CookieModal cookieModal;

    @FindBy(xpath = "//a[contains(@href, 'tryit.asp')][1]")
    WebElement tryItYourselfButton;

    public TagSelectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        cookieModal = new CookieModal(driver);
        WaitUtil.waitForPageLoadAndElement(driver, 3, tryItYourselfButton);
    }

    public void clickTryItYourselfButton(){
        wait.until(ExpectedConditions.visibilityOf(tryItYourselfButton));
        tryItYourselfButton.click();
    }
}
