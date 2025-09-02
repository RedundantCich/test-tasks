package com.gitlab.rmarzec.pages.wikipedia;

import com.gitlab.rmarzec.pages.wikipedia.components.LanguageSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class MainPage {
    private WebDriver driver;
    @Getter
    public LanguageSelector languageSelector;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        languageSelector = new LanguageSelector(this.driver);
        PageFactory.initElements(driver, this);
    }
}
