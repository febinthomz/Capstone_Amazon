package com.capstone.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.base.BaseClass;
import com.capstone.pageobjects.AddToCartPage;
import com.capstone.pageobjects.HomePage;
import com.capstone.pageobjects.SearchResultsPage;

public class AddToCartPageTest  extends BaseClass{
	
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	AddToCartPage addToCartpage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp();
		homePage =new HomePage();
		}
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest() {
		searchResultsPage =homePage.searchProduct("mens shirts");
		addToCartpage =searchResultsPage.clickOnProduct();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addToCartpage.enterQuantity("1");
		//addToCartpage.selectSize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addToCartpage.clickOnAddTocart();
		boolean result =addToCartpage.validateAddToCart();
		Assert.assertTrue(result);
		
	}
	
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	

}
