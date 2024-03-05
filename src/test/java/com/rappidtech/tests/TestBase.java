package com.rappidtech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.rappidtech.pages.*;
import com.rappidtech.reports.ExtentFactory;
import com.rappidtech.utilities.ConfigurationReader;
import com.rappidtech.utilities.Driver;
import com.rappidtech.utilities.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {
    private static final Logger logger = LogManager.getLogger(TestBase.class);
    public WebDriver driver ;
    public LoginPage loginPage;
    public MainPage mainPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckoutOverViewPage checkoutOverViewPage;
    public Faker faker = new Faker();

    public static ExtentReports extentReports;
    public static ExtentTest extentTest;


    @BeforeTest(groups = {"smoke","regression"})
    public void startReport() {
        //Initialize the Extent Reporter
        extentReports = ExtentFactory.getInstance();
    }

    @AfterTest(groups = {"smoke","regression"})
    public void endReport() {
        extentReports.flush();
    }



    @BeforeMethod(groups = {"smoke","regression"})
    @Parameters(value = "browserType")
    public void setup(@Optional("chrome")  String browserType){
        logger.info("Setting up the driver...");
        extentReports = ExtentFactory.getInstance();
        driver = Driver.getDriver(browserType);// Initializing the driver
        loginPage = new LoginPage(driver);// Initializing login page
        mainPage = new MainPage(driver);// Initializing main page
        cartPage = new CartPage(driver);// Initializing cart page
        checkoutPage = new CheckoutPage(driver); // Initializing checkout page
        checkoutOverViewPage = new CheckoutOverViewPage(driver);// Initializing checkoutOverView page
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod(groups = {"smoke","regression"})
    public void tearDown(ITestResult result){
        logger.info("Closing the driver...");
        SeleniumUtils.getResults(result , driver , extentTest);
        Driver.closeWebdriver();
    }


}
