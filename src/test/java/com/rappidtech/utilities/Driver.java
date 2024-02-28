package com.rappidtech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Driver class that will take care of the logic for the WebDriver and getting instances of the driver back
 */
public class Driver {
    private static final Logger logger = LogManager.getLogger(Driver.class);

    public static WebDriver driver;

    /**
     * This will return an instance of the driver , it will check if the driver is null , if not then it will return same instance
     * if its null then it will fo inside the condition and create a new instance of the webdriver for you
     * @param browser the type of the browser we want to use exmple: edge, chrome, opera, firefox etc...
     * @return it return an instance of the webdriver
     */
    public static WebDriver getDriver(String browser) {
        logger.info("Getting a driver instance");
        if(driver == null){
            //Create webdriver based on the value of the browser
            switch (browser.toLowerCase()){
                case "firefox":
                    logger.info("Starting a firefox browser");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    logger.info("Starting a Edge browser");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    logger.info("Starting a Chrome browser");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * This method will close the driver and nullify it by setting it to null
     */
    public static void closeWebdriver(){
        logger.info("Closing the browser");
        if(driver !=null){
            driver.quit();
            driver = null; // make the driver equal to null
        }

    }




}
