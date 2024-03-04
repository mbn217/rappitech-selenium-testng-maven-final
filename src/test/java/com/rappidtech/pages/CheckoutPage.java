package com.rappidtech.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private static final Logger logger = LogManager.getLogger(CheckoutPage.class);
    WebDriver driver ;

    /**
     * Constructor to initialize the webdriver and elements on the page
     * @param driver is the driver that need to be passed when we create object of the Login page
     */
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Checkout: Your Information']")
    WebElement checkoutLabel;
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameInputBox;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameInputBox;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipCodeInputBox;

    @FindBy(xpath = "//button[@id='cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    /**
     * This method will return true/false if field is displayed or not
     * @return true/false
     */
    public boolean isCheckoutMainLabelDisplayed(){
        logger.info("Checking if element is displayed");
        return checkoutLabel.isDisplayed();
    }
    /**
     * This method will return true/false if field is displayed or not
     * @return true/false
     */
    public boolean isFirstNameInputBoxDisplayed(){
        logger.info("Checking if element is displayed");
        return  firstNameInputBox.isDisplayed();
    }
    /**
     * This method will return true/false if field is displayed or not
     * @return true/false
     */
    public boolean isLastNameInputBoxDisplayed(){
        logger.info("Checking if element is displayed");
        return  lastNameInputBox.isDisplayed();
    }
    /**
     * This method will return true/false if field is displayed or not
     * @return true/false
     */
    public boolean isContinueButtonDisplayed(){
        logger.info("Checking if element is displayed");
        return continueButton.isDisplayed();
    }
    /**
     * This method will return true/false if field is displayed or not
     * @return true/false
     */
    public boolean isCancelButtonDisplayed(){
        logger.info("Checking if element is displayed");
        return cancelButton.isDisplayed();
    }

    /**
     * This method will enter a Firstname
     * @param firstName we want to enter
     */
    public void enterFirstName(String firstName){
        logger.info("Entering "+ firstName + " into the First Name input box");
        firstNameInputBox.sendKeys(firstName);
    }
    /**
     * This method will enter a lastName
     * @param lastName we want to enter
     */
    public void enterLastName(String lastName){
        logger.info("Entering "+ lastName + " into the Last Name input box");
        lastNameInputBox.sendKeys(lastName);
    }
    /**
     * This method will enter a zipCode
     * @param zipCode we want to enter
     */
    public void enterZipCode(String zipCode){
        logger.info("Entering "+ zipCode + " into Zip Code input box");
        zipCodeInputBox.sendKeys(zipCode);
    }

    /**
     * This method will click on continue button
     */
    public void clickOnContinueButton(){
        logger.info("Clicking on Continue button");
        continueButton.click();
    }




}
