package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_10_VerifyDefaultFilteringOption extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_10_VerifyDefaultFilteringOption.class);

    /**
     * As a User when I login to SauceDemo I want to
     * verify that the Default filtering option is set to {Name(A to Z)}
     */

    @Test
    public void verify_Default_Filtering_Option(){
        logger.info("Verify default filtering options");
        extentTest = extentReports.createTest("Verify default filtering options");
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();
        String defaultFilteringSelection = "Name (A to Z)";
        Assert.assertTrue(mainPage.checkDefaultFilterSelection(defaultFilteringSelection));
    }
}
