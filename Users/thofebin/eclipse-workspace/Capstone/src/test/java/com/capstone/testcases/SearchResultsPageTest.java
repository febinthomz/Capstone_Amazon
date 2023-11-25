package com.capstone.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.base.BaseClass;
import com.capstone.dataprovider.DataProviders;
import com.capstone.pageobjects.HomePage;
import com.capstone.pageobjects.SearchResultsPage;

public class SearchResultsPageTest extends BaseClass {
	
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	
	

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp();
		homePage =new HomePage();
		}
	
	@Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void productAvailibilityTest(String productName) {
		
		//searchResultsPage =homePage.searchProduct("mens shirts");
		
		searchResultsPage =homePage.searchProduct(productName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean result = searchResultsPage.isProductDisplayed();
		Assert.assertTrue(result);
		
	}
	
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
