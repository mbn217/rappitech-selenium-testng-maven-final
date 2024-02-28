package com.rappidtech.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private static final Logger logger = LogManager.getLogger(MainPage.class);
    WebDriver driver ;

    /**
     * Constructor to initialize the webdriver and elements on the page
     * @param driver is the driver that need to be passed when we create object of the Login page
     */
    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement appLogoMainLabel;

    @FindBy(xpath = "//a[.='Twitter']")
    WebElement twitterLink;

    @FindBy(xpath = "//a[.='Facebook']")
    WebElement faceBookLink;

    @FindBy(xpath = "//a[.='LinkedIn']")
    WebElement linkedinLink;








    //+++++++++++++++++++++++++++++++++++++++++++++ Method / Functions +++++++++++++++++++++++++++++++++++++++++++++++


    /**
     * This method will return the label of the main logo in the UI
     * @return strings of the main label
     */
    public String getMainLogoLabel(){
        logger.info("Getting the Main Logo Label");
       return appLogoMainLabel.getText();
    }

    /**
     * This method will return true or false if the Main logo label is displayed or not
     * @return true/false
     */
    public boolean isMainLogoLabelDisplayed(){
        logger.info("Checking if the Main Logo Label is displayed or not");
        return appLogoMainLabel.isDisplayed();
    }


    /**
     * This method will return the twitter href link
     * @return string for the href
     */
    public String getTwitterLink(){
        logger.info("Getting the href from the Twitter Logo");
        return twitterLink.getAttribute("href");
    }
    /**
     * This method will return the Facebook href link
     * @return string for the href
     */
    public String getFacebookLink(){
        logger.info("Getting the href from the Facebook Logo");
        return faceBookLink.getAttribute("href");
    }
    /**
     * This method will return the LinkedIn href link
     * @return string for the href
     */
    public String getLinkedInLink(){
        logger.info("Getting the href from the LinkedIn Logo");
        return linkedinLink.getAttribute("href");
    }






}
