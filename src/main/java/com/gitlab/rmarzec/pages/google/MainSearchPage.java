package com.gitlab.rmarzec.pages.google;

import com.gitlab.rmarzec.pages.google.components.CookieModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainSearchPage {
    private final WebDriverWait wait;
    @Getter
    public CookieModal cookieModal;

    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(name = "btnI")
    WebElement iFeelLuckyButton;


    public MainSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        cookieModal = new CookieModal(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public MainSearchPage inputSearchQuery(String query) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
        searchBox.sendKeys(query);
        return this;
    }

    public void clickIFeelLuckyButton() {
        wait.until(ExpectedConditions.visibilityOf(iFeelLuckyButton));
        iFeelLuckyButton.click();
    }
}
