package testCases;

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

import browserImplementation.BrowserDetails;
import objectImplementation.ObjectReaders;
import utils.ExcelUtility;
import utils.ExtentManager;
import utils.ReusableMethods;

public class TestLandingPage {

    protected static ExtentReports extent;

    // Start report
    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getInstance();
    }

    // Launch browser (ONE PER CLASS)
    @BeforeClass
    public void launchBrowser() throws IOException, InterruptedException {

        int choice = 1;

        BrowserDetails bd = new BrowserDetails(null);
        WebDriver wd = bd.select_Browser(choice);

        ReusableMethods.setDriver(wd);

        ReusableMethods.getDriver().manage().window().maximize();

        ObjectReaders or = new ObjectReaders();
        ReusableMethods.getDriver().get(or.getBaseUrl());

        Thread.sleep(2000);

        // Create Extent test
        ExtentTest test = extent.createTest(getClass().getSimpleName());
        ReusableMethods.setTest(test);

        System.out.println("Browser started for: " + getClass().getSimpleName());
    }

    // Capture result
    @AfterMethod
    public void getResult(ITestResult result) {

        ExtentTest test = ReusableMethods.getTest();
        String methodName = result.getMethod().getMethodName();
        if (test != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail(result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass(methodName+" - Test Passed");
            } else {
                test.skip(methodName+" - Test Skipped");
            }
        }
    }

    // Quit browser
    @AfterClass
    public void quitBrowser() {

        if (ReusableMethods.getDriver() != null) {
            ReusableMethods.getDriver().quit();
            ReusableMethods.removeDriver();
            System.out.println("Browser closed for: " + getClass().getSimpleName());
        }
    }

    // Flush report
    @AfterSuite
    public void endReport() {
        extent.flush();
        ExcelUtility.saveExcel();
    }
}