package com.capstone.pageobjects;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.actiondriver.Action;
import com.capstone.base.BaseClass;

public class SearchResultsPage extends BaseClass {
	
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchBox;

    @FindBy(xpath = "//img[@alt=\"Dennis Lingo Men's Solid Slim Fit Cotton Casual Shirt with Spread Collar & Full Sleeves (Also Available in Plus Size)\"]")
    WebElement Product;

    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterSearchTerm(String searchTerm) {
        Action.type(searchBox, searchTerm);
        Action.click(driver, searchBox); // You might need to click the search button after typing
    }

    public AddToCartPage clickOnProduct() {
    	
        String mainWindowHandle = driver.getWindowHandle();
        Action.click(driver, Product);

        // Switch to the new window
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Return an instance of AddToCartPage
        return new AddToCartPage();
    }

    public boolean isProductDisplayed() {
        return Action.isDisplayed(driver, Product);
    }


}
