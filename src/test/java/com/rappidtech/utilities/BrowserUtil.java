package com.rappidtech.utilities;

import com.rappidtech.tests.TC_12_VerifyCheckout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class BrowserUtil {
    private static final Logger logger = LogManager.getLogger(BrowserUtil.class);
    /**
     * This method can set the size of the browser screen to specific pixel dimensions
     * @param driver instance of the browser
     * @param dimension1 width in pixels exp: 200
     * @param dimension2 length in pixels exp: 300
     */
    public static void setWindowSize(WebDriver driver, int dimension1, int dimension2) {
        logger.info("Settting browser window size to {"+ dimension1 + "}px and {"+ dimension2 +"}px");
        driver.manage().window().setSize(new Dimension(dimension1, dimension2));
    }

    /**
     * Navigate forward in the browser
     * @param driver instance of the browser
     */
    public static void navigate_forward(WebDriver driver) {
        logger.info("navigate forward in the browser");
        driver.navigate().forward();
    }
    /**
     * Navigate backwards in the browser
     * @param driver instance of the browser
     */
    public static void navigate_back(WebDriver driver) {
        logger.info("navigate backwards in the browser");
        driver.navigate().back();
    }
    /**
     * refresh the browser
     * @param driver instance of the browser
     */
    public static void refresh(WebDriver driver) {
        logger.info("refresh the browser");
        driver.navigate().refresh();
    }

}
