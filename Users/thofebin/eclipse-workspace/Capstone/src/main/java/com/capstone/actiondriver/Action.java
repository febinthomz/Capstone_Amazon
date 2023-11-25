package com.capstone.actiondriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capstone.base.BaseClass;

public class Action extends BaseClass {
	
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	public static void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}
	
	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
	    boolean flag = findElement(driver, ele);

	    if (flag) {
	        if (ele.isDisplayed()) {
	            System.out.println("The element is Displayed");
	        } else {
	            System.out.println("The element is not Displayed");
	            flag = false;
	        }
	    } else {
	        System.out.println("Element not found");
	    }

	    return flag;
	}

	
	
	public static boolean findElement(WebDriver driver, WebElement ele) {
	    boolean flag = false;

	    try {
	        flag = ele.isDisplayed();
	        System.out.println("Successfully found element");
	    } catch (Exception e) {
	        System.out.println("Unable to locate element");
	    }

	    return flag;
	}
	
	
	public static void moveclick(WebDriver driver, WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.click(element).perform();
            System.out.println("Successfully clicked on the element");
        } catch (Exception e) {
            System.out.println("Unable to click on the element");
            e.printStackTrace();
        }
    }
	
	 public static void popupType(WebElement element, String value) {
	        try {
	            // Wait for the element to be clickable
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            wait.until(ExpectedConditions.elementToBeClickable(element));

	            // Clear existing text in the field (if any)
	            element.clear();

	            // Type the new value
	            element.sendKeys(value);

	            // Log the action
	            System.out.println("Entered value '" + value + "' in the pop-up field.");

	            // Optionally, wait for some time or perform other actions
	            // Thread.sleep(1000); // Example: Wait for 1 second

	        } catch (NoSuchElementException e) {
	            System.err.println("Element not found: " + e.getMessage());
	        } catch (TimeoutException e) {
	            System.err.println("Timed out waiting for element to be clickable: " + e.getMessage());
	        } catch (Exception e) {
	            // Handle the exception, log it, or inform the user
	            System.err.println("Error while typing value in the pop-up field: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }


	
	
	public static boolean type(WebElement ele, String text) {
	    boolean flag = false;
	    
	    try {
	        ele.clear();
	        ele.sendKeys(text);
	        flag = true;
	        System.out.println("Successfully entered value");
	    } catch (Exception e) {
	        System.out.println("Unable to enter value");
	    }

	    return flag;
	}
	
	public static void mouseOverElement(WebDriver driver, WebElement element) {
	    try {
	        new Actions(driver).moveToElement(element).build().perform();
	        System.out.println("MouseOver Action is performed on element");
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("MouseOver action is not performed on element");
	    }
	}
	
	public static boolean selectByVisibleText(String visibletext, WebElement ele) {
	    try {
	        Select s = new Select(ele);
	        s.selectByVisibleText(visibletext);
	        System.out.println("Option selected by VisibleText");
	        return true;
	    } catch (Exception e) {
	        System.out.println("Option not selected by VisibleText");
	        return false;
	    }
	}
	
	public static void fluentWait(WebElement element, int timeoutSeconds) {
	    Wait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(timeoutSeconds))
	            .pollingEvery(Duration.ofSeconds(2)) // Default polling interval
	            .ignoring(Exception.class);

	    wait.until(ExpectedConditions.visibilityOf(element));
	    element.click();
	}
	
	
	public static void enterValuesInPopup(WebElement element, String value) {
	    try {
	        // Implicit wait
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // Explicit wait
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.elementToBeClickable(element));

	        // Assuming 'element' is the field in the pop-up
	        element.sendKeys(value);

	        // You can add more actions as needed

	        System.out.println("Successfully entered values in the pop-up");
	    } catch (Exception e) {
	        System.out.println("Unable to enter values in the pop-up");
	        e.printStackTrace();
	    }
	}
	 
	 
    public static void clickElementInPopup(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

            // You can add more actions as needed

            System.out.println("Successfully clicked the element in the pop-up");
        } catch (Exception e) {
            System.out.println("Unable to click the element in the pop-up");
            e.printStackTrace();
        }
    }
    
    public static String screenShot(WebDriver driver, String filename) {
        String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }

    
    
   





	
	

	
}
