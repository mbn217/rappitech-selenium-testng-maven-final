package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04_VerifyLoginWithEmptyUserName extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_04_VerifyLoginWithEmptyUserName.class);
    /**
     * As a user when I enter a empty username {} and I enter a valid password {secret_sauce} and Error message
     * {Epic sadface: Username is required} should be displayed
     */



    @Test
    public void verify_Login_With_Empty_UserName(){
        String expectedUsernameRequiredErrorMessage = "Epic sadface: Username is required";
        loginPage.enterUserName("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();

        Assert.assertEquals(loginPage.getUserNameRequiredErrorMessage() , expectedUsernameRequiredErrorMessage);

    }
}
