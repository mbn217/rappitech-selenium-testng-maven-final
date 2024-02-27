package com.rappidtech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

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





}
