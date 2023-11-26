package com.capstone.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.base.BaseClass;
import com.capstone.pageobjects.AccountPage;
import com.capstone.pageobjects.AddToCartPage;
import com.capstone.pageobjects.AddressPage;
import com.capstone.pageobjects.HomePage;
import com.capstone.pageobjects.LoginPage;
import com.capstone.pageobjects.PaymentPage;
import com.capstone.pageobjects.SearchResultsPage;

public class EndToEndTest extends BaseClass {
	
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	SearchResultsPage searchResultsPage;
	AddToCartPage addToCartPage;
	AddressPage addressPage;
	PaymentPage paymentPage;


	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp();
		homePage =new HomePage();
		}
	
	@Test(groups = "Regression")
    public void endToEndTest() {
        // Navigate to Login Page from Home Page
        loginPage = homePage.clickOnLogin();
        
        // Perform login
        accountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        
        // Search for a product on the Search Results Page
        searchResultsPage = homePage.searchProduct("mens shirts");
        

        // Click on a product to view details and add to cart
        addToCartPage = searchResultsPage.clickOnProduct();
        //Assert.assertNotNull(addToCartPage, "Product details not displayed.");

        // Perform actions on the Add to Cart Page
        addToCartPage.enterQuantity("1");
       // addToCartPage.selectSize();
        addToCartPage.clickOnAddTocart();
        addressPage = addToCartPage.proceedToBuy();
        
        addressPage.clickOnNewAddrsBtn();
        addressPage.addAddress();
        
        paymentPage = addressPage.clickonUseAddrBtn();
        
        paymentPage.enterCvv("567");
        
        try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        paymentPage.useThisPayment();
        
        //paymentPage.billingAddress();
        
        try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        paymentPage.placeOrder();
        
        
        try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        boolean result = paymentPage.validateOtp();
        
        Assert.assertTrue(result);
        
        
	}
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
