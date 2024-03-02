package com.rappidtech.tests;

import com.rappidtech.utilities.ExcelUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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


    @Test(dataProvider = "data-login")
    public void verify_Login_With_Invalid_UserName_And_Password_List(String userName, String password){
        logger.info("Verify login with Invalid username and password test case");
        String expectedWrongMessage = "Epic sadface: Username and password do not match any user in this service";
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnSubmitButton();
        Assert.assertEquals(loginPage.getErrorMessageForWrongUserNamePassword().contains(expectedWrongMessage) , true);
    }

    @DataProvider(name = "data-login")
    public Object[][] loginDataSet(){
        ExcelUtils.generateFirstNameAndPasswordIntoExcelSheet("FN_PASS", "test_data_sauce_demo.xlsx", 3);
        return ExcelUtils.getDataSet("test_data_sauce_demo.xlsx", "FN_PASS");
    }

}
