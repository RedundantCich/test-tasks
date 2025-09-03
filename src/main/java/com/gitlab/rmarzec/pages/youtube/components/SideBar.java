package com.gitlab.rmarzec.pages.youtube.components;

import com.gitlab.rmarzec.framework.utils.WaitUtil;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SideBar {
    private final WebDriverWait wait;
    @FindBy(xpath = "//a[@title='Shorts']")
    WebElement shortsLink;
    @Getter
    @FindBy(tagName = "ytd-logo")
    WebElement ytLogo;
    @FindBy(xpath = "//a[@title='Home']")
    WebElement homeLink;

    public SideBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WaitUtil.waitForPageLoadAndElement(driver, 2, ytLogo);
    }

    public void clickShortsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(shortsLink));
        shortsLink.click();
    }

    public void clickHomeLink() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink));
        homeLink.click();
    }
}
