package com.capstone.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.log4j.xml.DOMConfigurator;
import com.beust.jcommander.Parameter;
import com.capstone.actiondriver.Action;
//import com.capstone.utility.ExtentManager;
import com.capstone.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static  WebDriver driver;
	
	

	
	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		try {
			prop = new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip = new FileInputStream("C:\\Users\\thofebin\\eclipse-workspace\\Capstone\\Configuration\\Config.properties");
					prop.load(ip);
			        System.out.println("driver" + driver);
			        
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public static  WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
    public void beforeSuite() {
		try {
			ExtentManager.setExtent();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DOMConfigurator.configure("log4j.xml");
    }


	


	public void launchApp() {
		
		String browserName = prop.getProperty("browser").toLowerCase();
		
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().browserVersion("119.0.6045.160").setup();
			driver = new ChromeDriver();
		} else if (browserName.contains("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 40);
		driver.get(prop.getProperty("url"));
		
		
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}



	
}