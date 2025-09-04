package com.gitlab.rmarzec.pages.wikipedia.components;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageSelector {
    private static final Logger logger = LoggerFactory.getLogger(LanguageSelector.class);
    private final WebDriverWait wait;
    private final Map<String, Object> languageMap = new HashMap<>();

    @FindBy(id = "p-lang-btn")
    private WebElement languageSelectorButton;

    @FindBy(xpath = "//div[contains(@class, 'uls-language-list')]")
    private WebElement fullLanguageSelectorMenu;

    public LanguageSelector(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public LanguageSelector clickLanguageSelectorButton() {
        wait.until(ExpectedConditions.visibilityOf(languageSelectorButton));
        languageSelectorButton.click();
        wait.until(ExpectedConditions.visibilityOf(fullLanguageSelectorMenu));
        return this;
    }

    public LanguageSelector fillLanguageMap() {
        List<WebElement> allLinks = fullLanguageSelectorMenu.findElements(By.tagName("a"));
        for (WebElement oneObject : allLinks) {
            languageMap.put(oneObject.getText(), oneObject.getAttribute("href"));
        }
        return this;
    }

    public void logLanguagesToConsole() {
        for (Map.Entry<String, Object> entry : languageMap.entrySet()) {
            logger.info("Language:\n{}", entry.getKey());
            // special rule for English - business requirement
            if (entry.getKey().equals("English")) {
                logger.info("URL:\n{}", entry.getValue());
            }
        }
    }
}
