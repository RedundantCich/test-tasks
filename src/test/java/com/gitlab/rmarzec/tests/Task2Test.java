package com.gitlab.rmarzec.tests;

import com.gitlab.rmarzec.base.BaseTest;
import com.gitlab.rmarzec.pages.wikipedia.MainPage;
import org.testng.annotations.Test;



public class Task2Test extends BaseTest {

    @Test
    public void openAndListWikipediaLanguagesTest(){
        MainPage wikiMainPage = new MainPage(driver);
        openTestPage("https://pl.wikipedia.org/wiki/Wiki");
        wikiMainPage.getLanguageSelector()
                .clickLanguageSelectorButton()
                .fillLanguageMap()
                .printLanguagesToConsole();
    }
}
