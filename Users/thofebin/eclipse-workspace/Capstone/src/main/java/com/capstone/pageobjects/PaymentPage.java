package com.capstone.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capstone.actiondriver.Action;
import com.capstone.base.BaseClass;

public class PaymentPage  extends BaseClass{
	
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "addCreditCardVerificationNumber0")
	WebElement cvvNumber;
	
	
	@FindBy(xpath = "//input[@aria-labelledby='orderSummaryPrimaryActionBtn-announce']")
	WebElement usePaymentBtn;
	
	@FindBy(xpath = "//input[@aria-labelledby='orderSummaryPrimaryActionBtn-announce']")
	WebElement useAddrssBtn;
	
	
	
	@FindBy(xpath = "//input[@aria-labelledby='submitOrderButtonId-announce']")
	WebElement placOrderBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Enter One Time Password (OTP)']")
	WebElement otpMsg;
	
	/*
	 * @FindBy(xpath =
	 * "/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/label[1]/input[1]")
	 * WebElement cardSelector;
	 * 
	 * @FindBy(className ="a-link-emphasis pmts-add-cc-default-trigger-link")
	 * WebElement EnterCardBtn;
	 * 
	 * @FindBy(name = "addCreditCardNumber") WebElement cardNumber;
	 * 
	 * @FindBy(xpath =
	 * "//span[@class='a-button-inner']//span[@class='a-dropdown-prompt']")
	 * WebElement expiryYear;
	 * 
	 * 
	 * @FindBy(xpath =
	 * "//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-prompt']"
	 * ) WebElement expiryMonth;
	 * 
	 * @FindBy(
	 * xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent' and @class='a-button-input' and @type='submit' and @aria-labelledby='pp-qPOTPy-26-announce']"
	 * ) WebElement finalCardbtn;
	 */
	
	
	/*
	 * public void cardSelection() {
	 * 
	 * Action.click(driver, cardSelector);
	 * 
	 * }
	 * 
	 * public void addNewcard() {
	 * 
	 * Action.clickElementInPopup(EnterCardBtn, driver);
	 * 
	 * }
	 * 
	 * 
	 * public void addNewCardDetails() {
	 * 
	 * Action.enterValuesInPopup(cardNumber, "5129670910681688");
	 * Action.enterValuesInPopup(expiryMonth, "05");
	 * Action.enterValuesInPopup(expiryYear, "2028"); }
	 * 
	 * public void finalCardAdd() { Action.clickElementInPopup(finalCardbtn,
	 * driver); }
	 */
	
	public void enterCvv(String cvv) {
		Action.type(cvvNumber, cvv);
		
	}
	
	public void useThisPayment() {
		Action.click(driver, usePaymentBtn);
	}


	public void billingAddress() {
		Action.click(driver, useAddrssBtn);
		
	}
	
	public void placeOrder() {
		Action.click(driver, placOrderBtn);
		
	}
	
	public boolean validateOtp() {
		String actualText = otpMsg.getText();
		
		return actualText.contains("Enter One Time Password");
		
	}
	

}
