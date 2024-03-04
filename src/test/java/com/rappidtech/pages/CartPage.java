package com.rappidtech.pages;

import com.rappidtech.utilities.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private static final Logger logger = LogManager.getLogger(CartPage.class);
    WebDriver driver ;

    /**
     * Constructor to initialize the webdriver and elements on the page
     * @param driver is the driver that need to be passed when we create object of the Login page
     */
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@id='continue-shopping']")
    WebElement continueButton;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='cart_quantity_label']")
    WebElement qtyLabel;

    @FindBy(xpath = "//div[@class='cart_desc_label']")
    WebElement descriptionLabel;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement backPackItemLabel;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    WebElement backPackDescriptionLabel;

    @FindBy(xpath = "//div[@class='inventory_item_price'][.='$29.99']")
    WebElement backPackPriceLabel;










    //+++++++++++++++++++++++++++++++++++++++++++++ Method / Functions +++++++++++++++++++++++++++++++++++++++++++++++


    /**
     * Will check if the continue button in the Cart page is displayed or not
     * @return
     */
    public boolean isContinueButtonDisplayed(){
        logger.info("Check is the continue button is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver , continueButton);
        return continueButton.isDisplayed();
    }

    /**
     * Will check if the checkout button in the Cart page is displayed or not
     * @return
     */
    public boolean isCheckoutButtonDisplayed(){
        logger.info("Check is the checkout button is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver , checkoutButton);
        return checkoutButton.isDisplayed();
    }

    /**
     * Will check if the qty label in the Cart page is displayed or not
     * @return
     */
    public boolean isQtyLabelDisplayed(){
        logger.info("Check is the qty label is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver , qtyLabel);
        return qtyLabel.isDisplayed();
    }

    /**
     * Will check if the Description label in the Cart page is displayed or not
     * @return true/false if value displayed or not
     */
    public boolean isDescriptionLabelDisplayed(){
        logger.info("Check is the Description label is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver , descriptionLabel);
        return descriptionLabel.isDisplayed();
    }

    /**
     * This methogd will return the label text
     * @return text
     */
    public String getBackPackItemLabel(){
        logger.info("Getting the label of the BackPack item from Cart page");
        return backPackItemLabel.getText();
    }
    /**
     * This methogd will return the label text
     * @return text
     */
    public String getBackPackDescriptionLabel(){
        logger.info("Getting the Description of the BackPack item from Cart page");
        return backPackDescriptionLabel.getText();
    }
    /**
     * This methogd will return the label text
     * @return text
     */
    public String getBackPackPriceLabel(){
        logger.info("Getting the Price of the BackPack item from Cart page");
        return backPackPriceLabel.getText();
    }

    /**
     * This method will click on a checkout button
     */
    public void clickOnCheckoutButton(){
        logger.info("Clicking on Checkout Button");
        checkoutButton.click();
    }


}
