package com.gitlab.rmarzec.pages.youtube;

import com.gitlab.rmarzec.framework.utils.WaitUtil;
import com.gitlab.rmarzec.pages.youtube.components.SideBar;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShortsPage {
    private final WebDriverWait wait;
    @Getter
    public SideBar sidebar;
    @FindBy(xpath = "//yt-reel-channel-bar-view-model/span/a")
    WebElement currentShortYoutuberLink;

    public ShortsPage(WebDriver driver) {
        sidebar = new SideBar(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WaitUtil.waitForPageLoadAndElement(driver, 2, sidebar.getYtLogo());
    }

    private String getCurrentYoutuberName() {
        wait.until(ExpectedConditions.visibilityOf(currentShortYoutuberLink));
        return currentShortYoutuberLink.getText();
    }

    public void printCurrentYoutuberName() {
        System.out.printf("First Shorts' Youtuber Name:\n%s\n", getCurrentYoutuberName());
    }
}
