package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_VerifyLoginWithInValidUserNameAndPassword extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_02_VerifyLoginWithInValidUserNameAndPassword.class);

    /**
     * As a user when I enter an Invalid username {locked_out_user}
     * and password {secret_sauce} I should
     * get a message {Sorry, this user has been locked out.}
     */

    @Test
    public void verify_Login_With_InValid_UserName_And_Password(){
        logger.info("Verify login with Invalid username and password test case");
        String expectedLockedOutUserMessage = "Sorry, this user has been locked out.";
        loginPage.enterUserName("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();
        Assert.assertEquals(loginPage.getLockedOutErrorMessage().contains(expectedLockedOutUserMessage) , true);
    }

}
