package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03_VerifyTheListOfAcceptedUserName extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_03_VerifyTheListOfAcceptedUserName.class);
    /**
     * As a user I want to verify that the list of Accepted usernames are :
     * standard_user
     * locked_out_user
     * problem_user
     * performance_glitch_user
     * error_user
     * visual_user
     */

    @Test(groups = {"regression"})
    public void verify_The_List_Of_Accepted_UserName(){
        logger.info("Verify The list of the accepted usernames");
        extentTest = extentReports.createTest("Verify The list of the accepted usernames");
        String[] expectedValidUsers = {"standard_user","locked_out_user","problem_user","performance_glitch_user","error_user","visual_user"};
        Assert.assertEquals(loginPage.getListOfAcceptedUserNames() , expectedValidUsers);
    }

}
