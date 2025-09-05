package com.gitlab.rmarzec.tests;

import com.gitlab.rmarzec.base.BaseTest;
import com.gitlab.rmarzec.model.YTTile;
import com.gitlab.rmarzec.pages.youtube.MainPage;
import com.gitlab.rmarzec.pages.youtube.SearchResultsPage;
import com.gitlab.rmarzec.pages.youtube.ShortsPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Task4Test extends BaseTest {
    String ytUrl = "https://www.youtube.com/";
    String ytSearchQuery = "Live";
    List<YTTile> ytTileList = new ArrayList<>();

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
                .logCurrentYoutuberName();
        shortsYtPage.getSidebar()
                .clickHomeLink();
        MainPage returnedMainYtPage = new MainPage(driver);
        returnedMainYtPage.getHeader()
                .enterSearchInput(ytSearchQuery)
                .clickSearchButton();
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        ytTileList = searchResults.listTop12FullVideos();
        searchResults.logFullVideos(ytTileList);
    }
}
