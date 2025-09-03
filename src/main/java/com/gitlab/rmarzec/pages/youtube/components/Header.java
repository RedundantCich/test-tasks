package com.gitlab.rmarzec.pages.youtube.components;

import com.gitlab.rmarzec.framework.utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriverWait wait;
    @FindBy(name = "search_query")
    WebElement searchInput;
    @FindBy(xpath = "//button[@title='Search']")
    WebElement searchButton;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WaitUtil.waitForPageLoadAndElement(driver, 2, searchInput);
    }

    public Header enterSearchInput(String query) {
        searchInput.clear();
        searchInput.click();
        searchInput.sendKeys(query);
        return this;
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }
}
