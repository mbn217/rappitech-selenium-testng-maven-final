package com.rappidtech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Driver class that will take care of the logic for the WebDriver and getting instances of the driver back
 */
public class Driver {

    public static WebDriver driver;

    /**
     * This will return an instance of the driver , it will check if the driver is null , if not then it will return same instance
     * if its null then it will fo inside the condition and create a new instance of the webdriver for you
     * @param browser the type of the browser we want to use exmple: edge, chrome, opera, firefox etc...
     * @return it return an instance of the webdriver
     */
    public static WebDriver getDriver(String browser) {
        if(driver == null){
            //Create webdriver based on the value of the browser
            switch (browser.toLowerCase()){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
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
        if(driver !=null){
            driver.quit();
            driver = null; // make the driver equal to null
        }

    }




}
