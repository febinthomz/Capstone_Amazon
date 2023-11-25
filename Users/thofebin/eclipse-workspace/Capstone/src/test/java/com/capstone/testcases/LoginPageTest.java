package com.capstone.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capstone.base.BaseClass;
import com.capstone.pageobjects.AccountPage;
import com.capstone.pageobjects.HomePage;
import com.capstone.pageobjects.LoginPage;
import com.capstone.utility.Log;
import com.capstone.dataprovider.DataProviders;

public class LoginPageTest extends BaseClass {
	
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp();
		homePage = new HomePage();
		Log.startTestCase("LoginPageTest");
		Log.info("Setup - Launched the application");
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) {
		Log.info("Starting loginTest");
		loginPage = homePage.clickOnLogin();
		Log.info("Clicked on Login link");
		//accountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		accountPage = loginPage.login(uname,pswd);
		Log.info("Logged in with username and password");
		
		String actualURL = accountPage.getCurrentUrl();
		String expectedURL = "https://www.amazon.in/?ref_=nav_ya_signin";
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Verified URL after login");
		
		Log.info("LoginTest completed successfully");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		Log.info("Tearing down the test");
		driver.quit();
		Log.endTestCase("LoginPageTest");
	}

}
