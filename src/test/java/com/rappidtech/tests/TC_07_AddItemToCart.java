package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_07_AddItemToCart extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_07_AddItemToCart.class);

    /**
     * As a User when I login to SauceDemo and I Click on Add to cart for the Item {Sauce Labs Backpack}
     * I should be able to se the Cart icon updated with One Item
     */

    @Test(groups = {"smoke"})
    public void add_Item_To_Cart_For_Back_Pack(){
        logger.info("Add item to cart for the back pack");
        extentTest = extentReports.createTest("Add item to cart for the back pack");
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();

        mainPage.clickOnAddToCartForBackPackButton();
        Assert.assertTrue(mainPage.getCartBadgeCount().equals("1"));
    }

}
