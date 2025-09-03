package com.gitlab.rmarzec.tests;

import com.gitlab.rmarzec.base.BaseTest;
import com.gitlab.rmarzec.framework.utils.PageVerifier;
import com.gitlab.rmarzec.pages.google.MainSearchPage;
import com.gitlab.rmarzec.pages.w3schools.TagSelectPage;
import com.gitlab.rmarzec.pages.w3schools.TryItEditorPage;
import org.testng.annotations.Test;

public class Task3Test extends BaseTest {
    String googleTestQuery = "HTML select tag - W3Schools";
    String googleUrl = "https://www.google.com/";
    String w3TagPage = "https://www.w3schools.com/tags/tag_select.asp";
    String carToSelect = "Opel";

    @Test
    public void w3SchoolTagTest() {
        openTestPage(googleUrl);
        MainSearchPage googleMainSearchPage = new MainSearchPage(driver);
        googleMainSearchPage.getCookieModal()
                .acceptCookies();
        googleMainSearchPage
                .inputSearchQuery(googleTestQuery)
                .clickIFeelLuckyButton();

        TagSelectPage tagSelectPage = new TagSelectPage(driver);
        PageVerifier pageVerifier = new PageVerifier(driver);
        pageVerifier.fixPageUrl(w3TagPage);

        tagSelectPage.getCookieModal()
                .acceptCookies();
        tagSelectPage.clickTryItYourselfButton();
        TryItEditorPage tryItEditorPage = new TryItEditorPage(driver);
        tryItEditorPage
                .printPreviewPaneH1()
                .selectCarFromSelectionInPreviewPane(carToSelect)
                .printPreviewPaneSelectedOptionFromDropdown();
    }
}
