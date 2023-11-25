package com.capstone.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.actiondriver.Action;
import com.capstone.base.BaseClass;

public class AccountPage extends BaseClass{
	
	@FindBy(xpath = "//span[normalize-space()='Account & Lists']")
	WebElement accountBtn;
	
	@FindBy(css = "div[id='nav-flyout-wl-items'] span:nth-child(1)")
	WebElement MyWishList;
	
	@FindBy(xpath = "//span[normalize-space()='Your Orders']")
	WebElement Myorders;
	

	@FindBy(xpath = "//a[contains(text(),'Xon Silicone Case Cover Skin for Sonyy WF-1000XM4 ')]")
	WebElement OrderId;
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean vaildateMyWishList() {
		Action.mouseOverElement(driver, accountBtn);
		String actualText = MyWishList.getText();
		return actualText.contains("febin");
	}
	
	public String getCurrentUrl() {
		String accountUrl = driver.getCurrentUrl();
		return accountUrl;
	}
	
	public boolean validateMyOrders() {
		Action.mouseOverElement(driver, accountBtn);
		Action.click(driver, Myorders);
		return Action.isDisplayed(driver, OrderId);
		
	}
	

}
