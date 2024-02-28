package com.rappidtech.pages;

import com.rappidtech.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    WebDriver driver ;

    /**
     * Constructor to initialize the webdriver and elements on the page
     * @param driver is the driver that need to be passed when we create object of the Login page
     */
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement submitButton;










    //+++++++++++++++++++++++++++++++++++++++++++++ Method / Functions +++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * This method will enter a username into the username field
     * @param userName the username we trying to enter
     */
    public void enterUserName(String userName){
        logger.info("Entering username {"+ userName +"} into the username field");
        userNameField.sendKeys(userName);
    }

    /**
     * This method will enter a password into the password field
     * @param password
     */
    public void enterPassword(String password){
        logger.info("Entering password {"+ password +"} into the password field");
        passwordField.sendKeys(password);
    }


    /**
     * This method will perform a click on the submit button
     */
    public void clickOnSubmitButton(){
        logger.info("Clicking on submit button");
        submitButton.click();
    }






}
