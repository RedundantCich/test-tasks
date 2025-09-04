package com.gitlab.rmarzec.base;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;
    protected DriverFactory driverFactory;

    @BeforeMethod(alwaysRun = true)
    protected void setupDriver() {
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();
        driver.manage().window().maximize();
    }

    protected void openTestPage(String webAddress) {
        driver.get(webAddress);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
