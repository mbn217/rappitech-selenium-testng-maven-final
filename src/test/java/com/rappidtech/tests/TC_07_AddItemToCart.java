package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TC_07_AddItemToCart extends TestBase{
    private static final Logger logger = LogManager.getLogger(TC_07_AddItemToCart.class);


    @Test
    public void add_Item_To_Cart_For_Back_Pack(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnSubmitButton();

        mainPage.clickOnAddToCartForBackPackButton();
    }

}
