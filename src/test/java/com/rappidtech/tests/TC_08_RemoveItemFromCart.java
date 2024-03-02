package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_08_RemoveItemFromCart extends TestBase{

    private static final Logger logger = LogManager.getLogger(TC_08_RemoveItemFromCart.class);

    /**
     * As a User when I login to SauceDemo and I Click on Add to cart for the Item {Sauce Labs Backpack}
     * And Click on Remove Button I should be able to remove the Item that was added to cart , and the cart icon should
     * show the change
     */

    @Test
    public void verify_Item_Is_Removed_From_Cart_Badge(){
        logger.info("Verify item is removed from the Cart Badge");
        extentTest = extentReports.createTest("Verify item is removed from the Cart Badge");
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();

        mainPage.clickOnAddToCartForBackPackButton(); // badge will change to one
        mainPage.clickOnRemoveFromCartForBackPackButton();
        Assert.assertTrue(mainPage.checkShoppingCartBadgeIsEmpty()); // if true then it means its empty




    }
}
