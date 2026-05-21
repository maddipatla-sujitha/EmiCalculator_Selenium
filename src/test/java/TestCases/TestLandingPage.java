package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BrowserImplementation.BrowserDetails;
import ObjectImplementation.ObjectReaders;
import Utils.ExtentManager;

public class TestLandingPage {

    // Thread-safe WebDriver
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    // Extent Report
    protected static ExtentReports extent;

    // Thread-safe ExtentTest
    protected static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return testThread.get();
    }

    // Start Report
    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getInstance();
    }

    // Launch ONLY ONE browser per class (parallel safe)
    @BeforeClass
    public void launchBrowser() throws IOException, InterruptedException {

        int choice = 1; // Chrome

        BrowserDetails bd = new BrowserDetails(null);
        WebDriver wd = bd.select_Browser(choice);

        driver.set(wd);

        getDriver().manage().window().maximize();

        ObjectReaders or = new ObjectReaders();
        getDriver().get(or.getBaseUrl());

        Thread.sleep(2000);

        // ✅ Create Extent Test PER CLASS
        ExtentTest test = extent.createTest(getClass().getSimpleName());
        testThread.set(test);

        System.out.println("Browser started for: " + getClass().getSimpleName());
    }

    //Capture result after EACH test method
    @AfterMethod
    public void getResult(ITestResult result) {

        ExtentTest test = getTest();

        if (test != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail(result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Passed");
            } else {
                test.skip("Test Skipped");
            }
        }
    }

    // Close browser after class
    @AfterClass
    public void quitBrowser() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            System.out.println("Browser closed for: " + getClass().getSimpleName());
        }
    }
    
    // Flush report
    @AfterSuite
    public void endReport() {
        extent.flush();
    }
}