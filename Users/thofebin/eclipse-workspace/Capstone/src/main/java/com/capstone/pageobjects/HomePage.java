package com.capstone.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.actiondriver.Action;
import com.capstone.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement logInBtn;
	
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement AmazonLogo;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchProductBox;
	
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchButton;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage clickOnLogin() {
		
		Action.click(driver,logInBtn);
		return new LoginPage();
			
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(driver, AmazonLogo);
	}
	
	public String getAmazonTitle() {
		String amazonTitle = driver.getTitle();
		return amazonTitle;
	}
	
	public SearchResultsPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultsPage();
	}
	
	
}
	
	
	
