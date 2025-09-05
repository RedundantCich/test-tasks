package com.gitlab.rmarzec.pages.youtube;

import com.gitlab.rmarzec.framework.utils.WaitUtil;
import com.gitlab.rmarzec.pages.youtube.components.Header;
import com.gitlab.rmarzec.pages.youtube.components.SideBar;
import com.gitlab.rmarzec.pages.youtube.components.YoutubeCookieModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;
    @Getter
    public YoutubeCookieModal cookieModal;
    @Getter
    public SideBar sidebar;
    @Getter
    public Header header;
    @FindBy(xpath = "//div[@id='content-wrapper']")
    WebElement contentCallToActionDiv;
    @FindBy(id = "chips")
    WebElement chipsDiv;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        cookieModal = new YoutubeCookieModal(driver);
        sidebar = new SideBar(driver);
        header = new Header(driver);
        PageFactory.initElements(driver, this);
        WaitUtil.waitForPageLoadAndElement(driver, 3, contentCallToActionDiv, chipsDiv);
    }
}
