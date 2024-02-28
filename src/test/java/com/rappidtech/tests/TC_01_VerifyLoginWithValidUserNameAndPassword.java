package com.rappidtech.tests;

import com.rappidtech.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_01_VerifyLoginWithValidUserNameAndPassword extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_01_VerifyLoginWithValidUserNameAndPassword.class);
    /**
     * As a user when I enter a valid username {standard_user} and
     * password {secret_sauce} the main page label {Swag Labs} should be displayed
     * And Linkedin / Facebook and Twitter Logo should be displayed
     * And the corresponding link for them are :
     * https://twitter.com/saucelabs
     * https://www.facebook.com/saucelabs
     * https://www.linkedin.com/company/sauce-labs/
     */
    @Test
    public void verify_Login_With_Valid_User_Name_And_Password(){
        String expectedTwitterLink = "https://twitter.com/saucelabs"; // From the requirement document
        String expectedFacebookLink = "https://www.facebook.com/saucelabs";// From the requirement document
        String expectedLinkedInLink = "https://www.linkedin.com/company/sauce-labs/";// From the requirement document

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();

        Assert.assertEquals(mainPage.isMainLogoLabelDisplayed() , true );
        Assert.assertEquals(mainPage.getTwitterLink() , expectedTwitterLink);
        Assert.assertEquals(mainPage.getFacebookLink() , expectedFacebookLink);
        Assert.assertEquals(mainPage.getLinkedInLink() , expectedLinkedInLink);


    }






}
