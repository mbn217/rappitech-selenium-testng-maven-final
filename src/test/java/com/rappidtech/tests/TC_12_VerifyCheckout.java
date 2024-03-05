package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_12_VerifyCheckout extends TestBase{

    private static final Logger logger = LogManager.getLogger(TC_12_VerifyCheckout.class);
    /**
     * As a user when I login to SauceDemo and I Click on Add to cart icon and I click on Checkout button
     * I should be able to see the checkout page label {Checkout: Your Information}
     * I should be able to see the for for {First Name}{Last Name}{Zip/Postal Code}
     * I should be able to see the two buttons {Cancel} and {Continue}
     */

    @Test(groups = {"regression"})
    public void verify_CheckoutPage_Labels(){
        logger.info("Verifying checkout page labels");
        extentTest = extentReports.createTest("Verifying checkout page labels ");
        loginPage.loginUsingValidCredentials();
        mainPage.clickOnShoppingCartLinkIcon();
        cartPage.clickOnCheckoutButton();

        Assert.assertTrue(checkoutPage.isCheckoutMainLabelDisplayed());
        Assert.assertTrue(checkoutPage.isFirstNameInputBoxDisplayed());
        Assert.assertTrue(checkoutPage.isLastNameInputBoxDisplayed());
        Assert.assertTrue(checkoutPage.isContinueButtonDisplayed());
        Assert.assertTrue(checkoutPage.isCancelButtonDisplayed());


    }



}
