package com.rappidtech.tests;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_13_VerifyCheckoutOverview extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_13_VerifyCheckoutOverview.class);

    /**
     * As a user when I login to SauceDemo and I Click on Add to cart icon for
     * the Item {Sauce Labs Backpack }and {Sauce Labs Bike Light} and I click on Checkout button
     * and I enter the First Name , Last Name and Zip/Postal Code and Click on continue
     * I should be able to Verify that the :
     * Payment Infromation Label is Displayed
     * Shipping Information is Displayed
     * Price Total us Displayed with Item total: $39.98 and Tax: $3.20 and Total: $43.18
     */


    @Test
    public void verify_Checkout_Information_For_Selected_Items(){
        logger.info("Verifying checkout Information after selecting items from main page");
        String expectedTotalPrice = "$43.18";
        logger.info("Verifying checkout information for selected items in the main page ");
        loginPage.loginUsingValidCredentials();
        mainPage.clickOnAddToCartForBackPackButton();
        mainPage.clickOnAddToCartForBikeLightButton();
        mainPage.clickOnShoppingCartLinkIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.enterFirstName(faker.name().firstName());
        checkoutPage.enterLastName(faker.name().lastName());
        checkoutPage.enterZipCode(faker.address().zipCode());
        checkoutPage.clickOnContinueButton();

        Assert.assertTrue(checkoutOverViewPage.isPaymentInformationLabelDisplayed());
        Assert.assertTrue(checkoutOverViewPage.isShippingInformationLabelDisplayed());
        Assert.assertEquals(checkoutOverViewPage.getTotalPrice() , expectedTotalPrice);


    }




}
