package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_09_VerifyCartPage extends TestBase{

    private static final Logger logger = LogManager.getLogger(TC_09_VerifyCartPage.class);

    /**
     * As a User when I login to SauceDemo and I Click on Add to cart icon , I should be able to see two buttons
     * Continute Shopping and Checkount. I should be able to see QTY and Description Labels
     */
    @Test(groups = {"smoke"})
    public void verify_Elements_In_Cart_Page_Are_Displayed(){
        logger.info("Verify elements in cart page are displayed");
        extentTest = extentReports.createTest("Verify elements in cart page are displayed");
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();

        mainPage.clickOnShoppingCartLinkIcon();
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
        Assert.assertTrue(cartPage.isContinueButtonDisplayed());
        Assert.assertTrue(cartPage.isQtyLabelDisplayed());
        Assert.assertTrue(cartPage.isDescriptionLabelDisplayed());

    }
}
