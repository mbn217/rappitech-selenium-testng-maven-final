package com.rappidtech.listeners;

import com.rappidtech.utilities.Driver;
import com.rappidtech.utilities.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {
    WebDriver driver = Driver.getDriver("chrome");
    public void onTestFailure(ITestResult result) {
        SeleniumUtils.getScreenShotPath(driver , result.getName());
    }

}
