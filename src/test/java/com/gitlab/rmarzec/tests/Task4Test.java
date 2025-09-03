package com.gitlab.rmarzec.tests;

import com.gitlab.rmarzec.base.BaseTest;
import com.gitlab.rmarzec.model.YTTile;
import com.gitlab.rmarzec.pages.youtube.MainPage;
import com.gitlab.rmarzec.pages.youtube.ShortsPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Task4Test extends BaseTest {
    String ytUrl = "https://www.youtube.com/";
    String ytSearchQuery = "live";

    @Test
    public void youtubeVideoListingTest() {
        openTestPage(ytUrl);
        MainPage mainYtPage = new MainPage(driver);
        mainYtPage.getCookieModal()
                .acceptCookies();
        mainYtPage.getSidebar()
                .clickShortsLink();
        ShortsPage shortsYtPage = new ShortsPage(driver);
        shortsYtPage
                .printCurrentYoutuberName();
        shortsYtPage.getSidebar()
                .clickHomeLink();
        mainYtPage.waitForPageLoad().getHeader()
                .enterSearchInput(ytSearchQuery)
                .clickSearchButton();

        //Lista kafelkow
        List<YTTile> ytTileList = new ArrayList<YTTile>();

    }
}
