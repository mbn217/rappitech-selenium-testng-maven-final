package com.rappidtech.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rappidtech.pages.CartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * This class will have all the method that are reusable to implement inside out test
 * They are mostly selenium util method such as doubleclick, wait statements etc...
 */
public class SeleniumUtils {
    private static final Logger logger = LogManager.getLogger(SeleniumUtils.class);
    public static WebDriver driver;


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
     * This method will wait for an element until its visible using Fluent Wait
     * @param driver instance of the browser
     * @param elementToWaitFor element in the page to wait for its visibility
     */
    public static void fluentWaitForElementVisibility(WebDriver driver , WebElement elementToWaitFor){
        logger.info("Waiting using Fluent wait for an element until its visible");
        FluentWait<WebDriver> wait = new FluentWait<>(driver) ;
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))// checking every two seconds , first time checks at 0 if element is visible  then checks again at 2s then at 4s then at 6s etc... until 10 seconds max is reached
                .ignoring(ElementNotInteractableException.class);

        wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }

    /**
     * This method takes a screenshot and returns the filepath to the png file
     * @param driver THis is the driver that needs to pass to the method at runtime
     * @param screenShotName This is the scrennshot name
     * @return the path to the screenshot that was taken
     */
    public static String  getScreenShotPath(WebDriver driver, String screenShotName){
        logger.info("Taking Screen shot and returning path of the image");
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
        logger.info(result.getName()  + "-------> {" + result.getStatus() + "}  <---------");
        if(result.getStatus() == ITestResult.FAILURE){
            //if the test fail then log FAIL to extent report and get the error logs
            extentTest.log(Status.FAIL, "Test Case: " + result.getName() +" Failed\n" + result.getThrowable());
            //get the screenshot path by calling below method that returns the screenshot path
            String screenShotPath = getScreenShotPath(driver, result.getName());
            //attach screenshot to the failed test
            extentTest.addScreenCaptureFromPath(screenShotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Case: " + result.getName() +" Skipped");
        } else{
            extentTest.log(Status.PASS, "Test Case: " + result.getName() +" Passed");
        }
    }

    /**
     * Switch to new window/tab
     * @param driver instance of the browser
     */
    public static void switchToNewWindow(WebDriver driver) {
        logger.info("Switching to new tab/window");
        Set s = driver.getWindowHandles();
        Iterator itr = s.iterator();
        String w1 = (String) itr.next();
        String w2 = (String) itr.next();
        driver.switchTo().window(w2);
    }
    /**
     * Switch to old window/tab
     * @param driver instance of the browser
     */
    public static void switchToOldWindow(WebDriver driver) {
        logger.info("Switching to old tab/window");
        Set s = driver.getWindowHandles();
        Iterator itr = s.iterator();
        String w1 = (String) itr.next();
        String w2 = (String) itr.next();
        driver.switchTo().window(w1);
    }
    /**
     * Switch to default window/tab
     * @param driver instance of the browser
     */
    public static void switchToParentWindow(WebDriver driver) {
        logger.info("Switching to default tab/window");
        driver.switchTo().defaultContent();
    }

    /**
     * Click on element using javascriptExecutor
     * @param driver instance of the browser
     * @param element the element we want to click
     */
    public static void clickElementWithJavaScriptExecutor(WebDriver driver, WebElement element){
        logger.info("Clicking on element using JS");
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }
    /**
     * highlight on element using javascriptExecutor
     * @param driver instance of the browser
     * @param element the element we want to highlight
     */
    private static void highlightElement(WebDriver driver, WebElement element) {
        logger.info("highlight on element using JS");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Execute JavaScript code to apply a border and change background color
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; background-color: yellow;');", element);
        // Wait for a short duration to see the highlighted effect (optional)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Execute JavaScript code to remove the highlighting
        js.executeScript("arguments[0].setAttribute('style', 'border: none; background-color: none;');", element);
    }
    /**
     * scroll to an element using javascriptExecutor
     * @param driver instance of the browser
     * @param element the element we want to scroll to
     */
    public static void scrollToElementUsingJavaScriptExecutor(WebDriver driver, WebElement element){
        logger.info("scroll to an element using JS");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    /**
     * scroll to central view of the element using javascriptExecutor
     * @param driver instance of the browser
     * @param element the element we want to scroll to
     */
    public static void scrollElementToCenterView(WebDriver driver, WebElement element) {
        logger.info("scroll to center of an element using JS");
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }

    /**
     * This method will drag an element from location and drop it into another location
     * using basic drag and drop method
     * @param driver instance of the browser
     * @param fromWebElement from which element
     * @param toWebElement to which element
     */
    public static void dragAndDrop(WebDriver driver ,WebElement fromWebElement, WebElement toWebElement) {
        logger.info("Drag and drop element");
        Actions builder = new Actions(driver);
        builder.dragAndDrop(fromWebElement, toWebElement);
    }
    /**
     * This method will drag an element from location and drop it into another location
     * using action class and movetoelement
     * @param driver instance of the browser
     * @param fromWebElement from which element
     * @param toWebElement to which element
     */
    public static void dragAndDrop_Method2(WebDriver driver ,WebElement fromWebElement, WebElement toWebElement) {
        logger.info("Drag and drop element");
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(fromWebElement)
                .moveToElement(toWebElement).release(toWebElement).build();
        dragAndDrop.perform();
    }
    /**
     * This method will drag an element from location and drop it into another location
     * using clickAndHold method
     * @param driver instance of the browser
     * @param fromWebElement from which element
     * @param toWebElement to which element
     */
    public static void dragAndDrop_Method3(WebDriver driver ,WebElement fromWebElement, WebElement toWebElement) {
        logger.info("Drag and drop element");
        Actions builder = new Actions(driver);
        builder.clickAndHold(fromWebElement).moveToElement(toWebElement)
                .perform();
        builder.release(toWebElement).build().perform();
    }

    /**
     * THis method will hover to an element using action class
     * @param driver instance of the browser
     * @param HovertoWebElement element we want to hover to
     * @throws InterruptedException
     */
    public static void hoverWebelement(WebDriver driver ,WebElement HovertoWebElement) {
        logger.info("Hover to an element");
        Actions builder = new Actions(driver);
        builder.moveToElement(HovertoWebElement).perform();

    }

    /**
     * This method will double click an element using action class
     * @param driver instance of the browser
     * @param doubleclickonWebElement element we want to double click
     * @throws InterruptedException
     */
    public static void doubleClickWebelement(WebDriver driver ,WebElement doubleclickonWebElement) {
        logger.info("double click on an element");
        Actions builder = new Actions(driver);
        builder.doubleClick(doubleclickonWebElement).perform();
    }

    /**
     * This method will select a value from Selection Dropdown using Name
     * @param element the element that had the dropdown selection
     * @param Name the name of the selection we want to select
     */
    public static void selectElementByName(WebElement element, String Name) {
        logger.info("select a value from a dropdown selection");
        Select selectItem = new Select(element);
        selectItem.selectByVisibleText(Name);
    }

    /**
     * This method will select a value from Selection Dropdown using value
     * @param element the element that had the dropdown selection
     * @param value the value of the selection we want to select
     */
    public static void selectElementByValue(WebElement element, String value) {
        logger.info("select a value from a dropdown selection");
        Select selectItem = new Select(element);
        selectItem.selectByValue(value);
    }

    /**
     * This method will select a value from Selection Dropdown using index
     * @param element the element that had the dropdown selection
     * @param index the index of the selection we want to select
     */
    public static void selectElementByIndex(WebElement element, int index) {
        logger.info("select a value from a dropdown selection");
        Select selectItem = new Select(element);
        selectItem.selectByIndex(index);
    }

}
