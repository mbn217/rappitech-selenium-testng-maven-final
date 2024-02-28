package com.rappidtech.tests;

import com.rappidtech.pages.LoginPage;
import com.rappidtech.pages.MainPage;
import com.rappidtech.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    private static final Logger logger = LogManager.getLogger(TestBase.class);
    public WebDriver driver ;
    public LoginPage loginPage;
    public MainPage mainPage;

    @BeforeMethod
    public void setup(){
        logger.info("Setting up the driver...");
        driver = Driver.getDriver("chrome");// Initializing the driver
        loginPage = new LoginPage(driver);// Initializing login page
        mainPage = new MainPage(driver);// Initializing main page
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown(){
        logger.info("Closing the driver...");
        Driver.closeWebdriver();
    }


}