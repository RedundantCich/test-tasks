package com.gitlab.rmarzec.pages.w3schools;

import com.gitlab.rmarzec.framework.utils.WaitUtil;
import com.gitlab.rmarzec.pages.w3schools.components.W3CookieModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class TagSelectPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "//a[contains(@href, 'tryit.asp')][1]")
    WebElement tryItYourselfButton;
    @Getter
    private W3CookieModal cookieModal;

    public TagSelectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        cookieModal = new W3CookieModal(driver);
        WaitUtil.waitForPageLoadAndElement(driver, 3, tryItYourselfButton);
    }

    public void clickTryItYourselfButton() {
        wait.until(ExpectedConditions.visibilityOf(tryItYourselfButton));
        tryItYourselfButton.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
