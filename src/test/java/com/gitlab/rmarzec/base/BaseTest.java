package com.gitlab.rmarzec.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.gitlab.rmarzec.framework.utils.DriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;
    protected DriverFactory driverFactory;

    @BeforeSuite
    protected void setupDriverFactory() {
        driverFactory = new DriverFactory();
    }

    @BeforeMethod(alwaysRun = true)
    protected void setupDriver() {
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
