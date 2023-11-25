package com.capstone.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter; // Change the import

public class ExtentManager {
    	
    public static ExtentSparkReporter sparkReporter; // Change the variable type
    public static ExtentReports extent;
    public static ExtentTest test;
    
    public static void setExtent() throws Throwable {
        // Use ExtentSparkReporter instead of ExtentHtmlReporter
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/" + "MyReport.html");
        sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter); // Attach ExtentSparkReporter
        
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "CapstoneProject");
        extent.setSystemInfo("Tester", "Febin");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }
    
    public static void endReport() {
        extent.flush();
    }
}
