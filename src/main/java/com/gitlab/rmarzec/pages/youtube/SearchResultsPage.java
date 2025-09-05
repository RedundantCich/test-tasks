package com.gitlab.rmarzec.pages.youtube;

import com.gitlab.rmarzec.framework.utils.ScrollUtil;
import com.gitlab.rmarzec.framework.utils.WaitUtil;
import com.gitlab.rmarzec.model.YTTile;
import com.gitlab.rmarzec.pages.youtube.components.Header;
import com.gitlab.rmarzec.pages.youtube.components.SideBar;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {
    private static final Logger logger = LoggerFactory.getLogger(SearchResultsPage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;
    @Getter
    public SideBar sidebar;
    @Getter
    public Header header;
    ScrollUtil scrollUtil;
    List<WebElement> videoObjects;
    @FindBy(id = "chips")
    WebElement chipsDiv;
    List<YTTile> videoList = new ArrayList<>();

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        sidebar = new SideBar(driver);
        header = new Header(driver);
        scrollUtil = new ScrollUtil(driver);
        PageFactory.initElements(driver, this);
        WaitUtil.waitForPageLoadAndElement(driver, 3, chipsDiv);
    }

    List<WebElement> getTop12VideoObjects() {
        return wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.tagName("ytd-video-renderer"), 12)).subList(0, 12);
    }

    public List<YTTile> listTop12FullVideos() {
        videoObjects = getTop12VideoObjects();
        for (WebElement video : videoObjects) {
            scrollUtil.scrollIntoView(video, false);
            YTTile element = new YTTile();
            element.setTitle(getVideoTitle(video));
            element.setChannel(getChannel(video));
            element.setLength(getVideoLength(video));
            videoList.add(element);
        }
        return videoList;
    }

    public void logFullVideos(List<YTTile> videoList) {
        long loggedCount = videoList.stream()
                .filter(v -> !"Live".equals(v.getLength()))
                .peek(v -> logger.info("\nTitle: {}\nChannel: {}\nLength: {}\n",
                        v.getTitle(), v.getChannel(), v.getLength()))
                .count();

        if (loggedCount == 0) {
            logger.info("No non-live videos found in the list.");
        }
    }


    private String getVideoLength(WebElement videoMetadata) {
        if (isVideoLive(videoMetadata)) {
            return "Live";
        } else {
            WebElement timeCapsule = wait.until(ExpectedConditions.visibilityOf(videoMetadata.findElement(By.xpath(".//ytd-thumbnail-overlay-time-status-renderer"))));
            return timeCapsule.getText();
        }
    }

    private String getChannel(WebElement videoMetadata) {
        return videoMetadata.findElements(By.xpath(".//ytd-channel-name//a")).get(1).getText();
    }

    private String getVideoTitle(WebElement videoMetadata) {
        return videoMetadata.findElement(By.xpath(".//h3/a")).getText();
    }

    private boolean isVideoLive(WebElement videoMetadata) {
        List<WebElement> badgeElements;
        badgeElements = videoMetadata.findElements(By.xpath(".//ytd-badge-supported-renderer//p"));
        if (badgeElements.isEmpty()) {
            return false;
        }
        for (WebElement element : badgeElements) {
            if (element.getText().contains("LIVE")) {
                return true;
            }
        }
        return false;
    }
}
