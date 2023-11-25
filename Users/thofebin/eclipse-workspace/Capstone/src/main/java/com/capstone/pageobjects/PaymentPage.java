package com.capstone.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.actiondriver.Action;
import com.capstone.base.BaseClass;

public class PaymentPage  extends BaseClass{
	
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "pp-SAdJ6F-120")
	WebElement cardSelector;
	
	@FindBy(id = "pp-SAdJ6F-123")
	WebElement EnterCardBtn;
	
	@FindBy(name = "addCreditCardNumber")
	WebElement cardNumber;
	
	@FindBy(xpath = "//span[@class='a-button-inner']//span[@class='a-dropdown-prompt']")
	WebElement expiryYear;
	
	
	@FindBy(xpath = "//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-prompt']")
	WebElement expiryMonth;
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent' and @class='a-button-input' and @type='submit' and @aria-labelledby='pp-qPOTPy-26-announce']")
	WebElement finalCardbtn;
	
	
	public void cardSelection() {
		
		Action.click(driver, cardSelector);
		
	}
	
	public void addNewcard() {
		
		Action.click(driver, EnterCardBtn);
	}
	
	public void addNewCardDetails() {
		Action.enterValuesInPopup(cardNumber, "5129670910681688");
		Action.enterValuesInPopup(expiryMonth, "05");
		Action.enterValuesInPopup(expiryYear, "2028");
	}
	
	public void finalCardAdd() {
		Action.clickElementInPopup(finalCardbtn, driver);
	}
	
	

	
	

}
