package com.capstone.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.actiondriver.Action;
import com.capstone.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	
	@FindBy(xpath = "//select[@id='quantity']")
	WebElement quantity;
	
	
	@FindBy(css = "span.a-size-base.swatch-title-text-display.swatch-title-text")
	WebElement size;

	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement AddToCartBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/span[1]/span[1]/span[1]/input[1]")
	WebElement ProceedToBuyBtn;
	
	@FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	WebElement addToCartMsg;
	
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterQuantity(String quantity1) {
		Action.selectByVisibleText(quantity1, quantity);
	}
	
	public void selectSize() {
		Action.click(driver, size);
	}
	
	
	public void clickOnAddTocart() {
		Action.click(driver, AddToCartBtn);
		
	}
	
	public AddressPage proceedToBuy() {
		
		Action.click(driver, ProceedToBuyBtn);
		
		return new AddressPage();
		
	}
	
	public boolean validateAddToCart() {
		String actualText = addToCartMsg.getText();
		
		return actualText.contains("Added to Cart");
		
	}
	
	
	

}
