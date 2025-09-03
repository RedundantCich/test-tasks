package com.gitlab.rmarzec.framework.utils;

import org.openqa.selenium.WebDriver;

public class FrameUtil {
    private final WebDriver driver;

    public FrameUtil(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    private void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public void executeInFrame(String frameNameOrId, Runnable action) {
        switchToFrame(frameNameOrId);
        try {
            action.run();
        } finally {
            switchToDefaultFrame();
        }
    }
}
