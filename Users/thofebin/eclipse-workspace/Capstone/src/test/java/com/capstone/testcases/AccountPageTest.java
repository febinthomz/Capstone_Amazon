package com.capstone.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.base.BaseClass;
import com.capstone.pageobjects.AccountPage;
import com.capstone.pageobjects.HomePage;
import com.capstone.pageobjects.LoginPage;
import com.capstone.utility.Log;

public class AccountPageTest extends BaseClass {
    
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup() {
        launchApp();
        homePage = new HomePage();
    }
    
    @Test(groups = "Smoke")
    public void wishListTest() {
        Log.startTestCase("wishListTest");
        
        Log.info("Clicking on Login to access the wish list");
        loginPage = homePage.clickOnLogin();
        
        Log.info("Logging in to the account");
        accountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        
        Log.info("Validating the wish list");
        boolean result = accountPage.vaildateMyWishList();
        Assert.assertTrue(result, "Wish List validation failed");
        
        Log.info("Wish List validation successful");
        Log.endTestCase("wishListTest");
    }
    
    @Test(groups = "Smoke")
    public void orderHistoryTest() {
        Log.startTestCase("orderHistoryTest");
        
        Log.info("Clicking on Login to access order history");
        loginPage = homePage.clickOnLogin();
        
        Log.info("Logging in to the account");
        accountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        
        Log.info("Validating order history");
        boolean result = accountPage.validateMyOrders();
        Assert.assertTrue(result, "Order History validation failed");
        
        Log.info("Order History validation successful");
        Log.endTestCase("orderHistoryTest");
    }
    
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        driver.quit();
    }
}
