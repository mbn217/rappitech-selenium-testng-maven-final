package com.rappidtech.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rappidtech.pages.CartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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



    /**
     * This method takes a screenshot and returns the filepath to the png file
     * @param driver THis is the driver that needs to pass to the method at runtime
     * @param screenShotName This is the scrennshot name
     * @return the path to the screenshot that was taken
     */
    public static String  getScreenShotPath(WebDriver driver, String screenShotName){
        String path;
        String finalPath;
        // below code will get the current date in below format and return a string representation and assign it to date variable
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //This below code will take a screenshot with the help of TakesScreenshot interface
        TakesScreenshot ts = (TakesScreenshot) driver;
        //This below code will output the screenshot as a file type
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        //Specify the path were we want to paste our screenshot
        path = System.getProperty("user.dir")+"/ScreenShots/" + screenShotName + date + ".png";
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            path = System.getProperty("user.dir")+ "\\" + "ScreenShots" + "\\" + screenShotName + date + ".png";
        }
        //We will get the file from the source and put it into the destination path
        File destination = new File(path);
        try {
            FileHandler.copy(sourceFile , destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }


    /**
     * This will get the results of the test cases and output the status to the extent report
     * We have PASS/FAIL/SKIPPED , in case of Failure a screen shot method will be called
     * @Author Mo
     * @param result This is the result reference object that needs to be passed when method is called
     *               Its it more useful if its used in the @After method so we can capture the results of the
     *               Test case and log the pass/fail/skipped statuses
     * @param driver this is the driver object that needs to pass at  runtime ( at the calling of the method)
     * @param extentTest this is the extenttest object that needs to be passed when this method is called
     *                   most likely in the BaseClass
     */
    public static void getResults(ITestResult result , WebDriver driver, ExtentTest extentTest){
        System.out.println(result.getName()  + "-------> {" + result.getStatus() + "}  <---------");

        if(result.getStatus() == ITestResult.FAILURE){
            //if the test fail then log FAIL to extent report and get the error logs
            extentTest.log(Status.FAIL, "Test Case: " + result.getName() +" Failed\n" + result.getThrowable());
            //get the screenshot path by calling below method that returns the screenshot path
            String screenShotPath = getScreenShotPath(driver, result.getName());
            //attach screenshot to the failed test
            extentTest.addScreenCaptureFromPath(screenShotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Case: " + result.getName() +" Passed");
        } else{
            extentTest.log(Status.PASS, "Test Case: " + result.getName() +" Passed");
        }
    }

}
