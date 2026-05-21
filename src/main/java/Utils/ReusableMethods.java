package utils;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReusableMethods {

	// Thread-safe WebDriver
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }
 
    public static void setDriver(WebDriver wd) {
        driver.set(wd);
    }

    // Extent Report
    protected static ExtentReports extent;

    // Thread-safe ExtentTest
    protected static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return testThread.get();
    }
    
    public static void setTest(ExtentTest test) {
        testThread.set(test);
    }


    // Remove Driver
     public static void removeDriver() {
         driver.remove();
     }

}
