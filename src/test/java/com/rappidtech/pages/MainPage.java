package com.rappidtech.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    List<WebElement> listOfInventoryItems;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addToCartForBackPack;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement shoppingCartBadge;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    WebElement removeFromCartForBackPack;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLinkIcon;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement filteringSelection;







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
    /**
     * This method will get the list of the inventory items from the main page
     * @return list of inventory items
     */
    public ArrayList<String> getListOfInventoryItems(){
        logger.info("Getting the inventory items from main page");
        ArrayList<String> inventory = new ArrayList<>();
        for(WebElement item : listOfInventoryItems){
            logger.info("Items are: {" + item.getText() +"} ");
            inventory.add(item.getText());
        }
        return inventory;
    }

    /**
     * This methiod will click on the Add to Cart button for the back pack item
     */
    public void clickOnAddToCartForBackPackButton(){
        logger.info("Clicking on the Add to Cart for Back Pack");
        addToCartForBackPack.click();
    }

    /**
     * This Method will check if the shopping cart badge is empty or not
     * If its empty then the element doesnt exist on the page , if it has a value the it will be displayed
     * @return true if the badge is not displayed in the UI(meaning empty , no items) , false if the badge has items added to cart
     */
    public boolean checkShoppingCartBadgeIsEmpty(){
        logger.info("Checking if the shopping cart is empty or not");
        boolean flag = true;
        try {
            shoppingCartBadge.getText(); //1 2
            flag =false;
        }catch(NoSuchElementException e){
            logger.error("The element was not found");
        }
        return flag;
    }

    /**
     * This method will get the count of the items that were added into the badge
     * @return the item count
     */
    public String getCartBadgeCount(){
        logger.info("Getting the Item count from the cart");
        if(checkShoppingCartBadgeIsEmpty() == false){
            return shoppingCartBadge.getText();
        }
        return "0";
    }


    /**
     * This method will click on the remove button for the back pack item
     */
    public void clickOnRemoveFromCartForBackPackButton(){
        logger.info("Clicking on the Remove from Cart for Back Pack");
        removeFromCartForBackPack.click();
    }

    /**
     * This method will click on the shopping cart icon
     */
    public void clickOnShoppingCartLinkIcon(){
        logger.info("Clicking on the shopping cart icon");
        shoppingCartLinkIcon.click();
    }


    /**
     * This method will check the default filter option in the main page
     * @param defaultFilterSelection  the default selection that we need to check/verify
     * @return true if the defaultFilterSelection is visible and part of the list of options
     */
    public boolean  checkDefaultFilterSelection(String defaultFilterSelection){
        logger.info("Checking the default filter selection in the main page");
        Select select = new Select(filteringSelection);
        List<WebElement> filterSelectionList =  select.getOptions();
        for(WebElement option : filterSelectionList){
            if(option.getText().equals(defaultFilterSelection) && option.isDisplayed()){
                return true;
            }
        }
        return false;
    }

}
