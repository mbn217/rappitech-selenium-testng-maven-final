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


    public boolean isCheckoutMainLabelDisplayed(){
        return checkoutLabel.isDisplayed();
    }

    public boolean isFirstNameInputBoxDisplayed(){
        return  firstNameInputBox.isDisplayed();
    }

    public boolean isLastNameInputBoxDisplayed(){
        return  lastNameInputBox.isDisplayed();
    }

    public boolean isContinueButtonDisplayed(){
        return continueButton.isDisplayed();
    }

    public boolean isCancelButtonDisplayed(){
        return cancelButton.isDisplayed();
    }


    public void enterFirstName(String firstName){
        logger.info("Entering "+ firstName + " into the First Name input box");
        firstNameInputBox.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        logger.info("Entering "+ lastName + " into the Last Name input box");
        lastNameInputBox.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode){
        logger.info("Entering "+ zipCode + " into Zip Code input box");
        zipCodeInputBox.sendKeys(zipCode);
    }

    public void clickOnContinueButton(){
        logger.info("Clicking on Continue button");
        continueButton.click();
    }




}
