package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TC_06_VerifyListOfItemsInTheSauceDemoStore extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_06_VerifyListOfItemsInTheSauceDemoStore.class);

    /**
     * As a user I want to verify that the list of all the item in the main page are :
     * Sauce Labs Backpack
     * Sauce Labs Bike Light
     * Sauce Labs Bolt T-Shirt
     * Sauce Labs Fleece Jacket
     * Sauce Labs Onesie
     * Test.allTheThings() T-Shirt (Red)
     */

    @Test(groups = {"regression"})
    public void verify_List_Of_Items_In_The_SauceDemo_Store(){
        logger.info("Verify list of items in the sauce demo store");
        extentTest = extentReports.createTest("Verify list of items in the sauce demo store");
        ArrayList<String> expectedInventoryItems = new ArrayList<>(List.of("Sauce Labs Backpack",
                "Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket"
                , "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)" ));
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();

        Assert.assertEquals(mainPage.getListOfInventoryItems() , expectedInventoryItems);
    }

}
