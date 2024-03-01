package com.rappidtech.utilities;

import com.rappidtech.pages.CartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class will have all the method that are reusable to implement inside out test
 * They are mostly selenium util method such as doubleclick, wait statements etc...
 */
public class SeleniumUtils {
    private static final Logger logger = LogManager.getLogger(SeleniumUtils.class);


    /**
     * This method will use explicit wait to wait for an element to be visible
     * @param driver instance of the browser
     * @param elementToWaitFor the element we want to wait for
     */
    public static void waitForVisibilityOfElement(WebDriver driver , WebElement elementToWaitFor){
        logger.info("Waiting for an element until its visible");
        Long secondToWaitFor = Long.parseLong(ConfigurationReader.getProperty("explicitWait"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondToWaitFor));
        wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }


    /**
     * This method will use explicit wait to wait for an element to be selected
     * @param driver instance of the browser
     * @param elementToWaitFor the element we want to wait for
     */
    public static void waitForElementToBeSelected(WebDriver driver , WebElement elementToWaitFor){
        logger.info("Waiting for an element until its visible");
        Long secondToWaitFor = Long.parseLong(ConfigurationReader.getProperty("explicitWait"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondToWaitFor));
        wait.until(ExpectedConditions.elementToBeSelected(elementToWaitFor));
    }

}
