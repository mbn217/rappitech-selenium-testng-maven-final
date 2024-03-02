package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_11_VerifyItemInCart extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_11_VerifyItemInCart.class);
    /**
     * As a User when I login to SauceDemo and I Click on Add to cart for the Item {Sauce Labs Backpack}
     * And I click on CART icon , I should be able to verify the item is added and matching the item added from Product page
     * ,the price and the description  is matching too
     */


    @Test
    public void Verify_Item_Is_Added_To_Cart(){
        logger.info("Verifying that adding Sauce Labs Backpack is available in the Cart Page ");
        String expectedItemLabel = "Sauce Labs Backpack";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String expectedItemPrice = "$29.99";

        loginPage.loginUsingValidCredentials();


        mainPage.clickOnAddToCartForBackPackButton();
        mainPage.clickOnShoppingCartLinkIcon();

        Assert.assertEquals(cartPage.getBackPackItemLabel() , expectedItemLabel); // verifying the item label are matching
        Assert.assertEquals(cartPage.getBackPackDescriptionLabel() , expectedItemDescription);
        Assert.assertEquals(cartPage.getBackPackPriceLabel(), expectedItemPrice);

        //Verify against what you added from the main page
        Assert.assertEquals(cartPage.getBackPackItemLabel()  , mainPage.getBackPackItemLabel());
        Assert.assertEquals(cartPage.getBackPackDescriptionLabel()  , mainPage.getBackPackDescriptionLabel());
        Assert.assertEquals(cartPage.getBackPackPriceLabel()  , mainPage.getBackPackPriceLabel());


    }


}
