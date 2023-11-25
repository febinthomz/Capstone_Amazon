package com.capstone.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.actiondriver.Action;
import com.capstone.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(xpath ="//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	
	@FindBy(xpath ="//input[@id='signInSubmit']")
	WebElement SignInBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AccountPage login(String uname, String paswd) {
		Action.type(username, uname);
		Action.click(driver, continueBtn);
		
		Action.type(password,paswd);
		Action.click(driver, SignInBtn);
		
		return new AccountPage();
	}

}
