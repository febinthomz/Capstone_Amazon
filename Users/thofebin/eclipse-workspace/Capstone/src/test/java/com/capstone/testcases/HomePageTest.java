package com.capstone.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.base.BaseClass;
import com.capstone.pageobjects.HomePage;
import com.capstone.utility.Log;

public class HomePageTest extends BaseClass {
    
    HomePage homePage;
    
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup() {
        launchApp();
        homePage = new HomePage();
    }
    
    @Test(groups = "Smoke")
    public void verifyLogo() {
        Log.startTestCase("verifyLogo");
        
        Log.info("Verifying the presence of the Amazon logo");
        boolean result = homePage.validateLogo();
        Assert.assertTrue(result, "Amazon logo is not displayed");
        
        Log.info("Logo verification successful");
        Log.endTestCase("verifyLogo");
    }
    
    @Test(groups = "Smoke")
    public void verifyTitle() {
        Log.startTestCase("verifyTitle");
        
        Log.info("Getting the title of the Amazon page");
        String actTitle = homePage.getAmazonTitle();
        
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(actTitle, expectedTitle, "Title mismatch");
        
        Log.info("Title verification successful");
        Log.endTestCase("verifyTitle");
    }
    
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        driver.quit();
    }
}
