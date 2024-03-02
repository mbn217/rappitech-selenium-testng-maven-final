package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05_VerifyLoginWithEmptyPassword extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_05_VerifyLoginWithEmptyPassword.class);
    /**
     * As a user when I enter a username {standard_user} and I enter empty password {} and Error message
     * {Epic sadface: Password is required} should be displayed
     */

    @Test
    public void verify_Login_With_Empty_Password(){
        logger.info("Verify login with empty password");
        extentTest = extentReports.createTest("Verify login with empty password");
        String expectedPasswordRequiredErrorMessage = "Epic sadface: Password is required";
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("");
        loginPage.clickOnSubmitButton();

        Assert.assertEquals(loginPage.getPasswordRequiredErrorMessage() , expectedPasswordRequiredErrorMessage);
    }

}
