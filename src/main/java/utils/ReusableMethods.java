package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
     
     //Screenshot
     public static String captureScreenshot(String testName) {

         String filePath = "Screenshots/" + testName  + ".png";

         try {
             File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

             File dest = new File(filePath);
             dest.getParentFile().mkdirs();

             FileUtils.copyFile(src, dest);

         } catch (Exception e) {
             e.printStackTrace();
         }
         return filePath;
     }
     
     //Wait for the page to load
     public static void waitForPageToLoad() throws InterruptedException {
    	 Thread.sleep(2000);
     }

}
