package com.capstone.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.actiondriver.Action;
import com.capstone.base.BaseClass;

public class AddressPage  extends  BaseClass{
	
	
	
	public AddressPage() {
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "add-new-address-popover-link")
	WebElement newAddressBtn;
	
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
	WebElement fullName;
	
	@FindBy(xpath ="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement mobNumber;
	
	@FindBy(xpath= "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement pincode;
	
	@FindBy(xpath= "//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement flatName;
	
	@FindBy(xpath= "//input[@id='address-ui-widgets-enterAddressLine2']")
	WebElement area;
	

	@FindBy(xpath= "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
	WebElement useThisAddrBtn;
	
	public void clickOnNewAddrsBtn() {
	    if (newAddressBtn != null) {
	        Action.click(driver, newAddressBtn);
	    } else {
	        System.out.println("newAddressBtn is null");
	    }
	}
	
	public void addAddress() {
        try {
            Action.enterValuesInPopup(fullName, "Febin Thomas");
            Action.enterValuesInPopup(mobNumber, "9809402924");
            Action.enterValuesInPopup(pincode, "600042");
            Action.enterValuesInPopup(flatName, "Tidel park");
            Action.enterValuesInPopup(area, "Thiruvanmiyur");
        } catch (Exception e) {
            // Handle the exception, log it, or inform the user
            e.printStackTrace();
        }
    }
	
	public PaymentPage clickonUseAddrBtn() {
		Action.clickElementInPopup(useThisAddrBtn, driver);
		return new PaymentPage();
		
	}

}
