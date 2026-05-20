package TestCases;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BrowserImplementation.BrowserDetails;
import ObjectImplementation.ObjectReaders;
import Utils.ExtentManager;

public class TestLandingPage {
	WebDriver driver;
	BrowserDetails bd;
	ObjectReaders or;
	Scanner obj=new Scanner(System.in);
	

	protected static ExtentReports extent;
    protected ExtentTest test;

	//Start Extent Report
	@BeforeSuite
	public void startReport() {
        extent = ExtentManager.getInstance();
    }

	//Launch Browser and Navigate to EmiCalculator WebPage
	@BeforeTest
	public void Launch_Browser_Test() throws InterruptedException, IOException {
		System.out.println("Select the Broser: \n 1.Chrome \n 2.Edge \n 3.Firefox");
		int choice=obj.nextInt();
		bd= new BrowserDetails(driver);
		driver=bd.select_Browser(choice);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		or= new ObjectReaders();
		driver.get(or.getBaseUrl());
		Thread.sleep(3000);
	}

	@AfterMethod
    public void getResult(org.testng.ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }
    }

	//Quit Browser
	@AfterTest
	public void QuitBrowser() {
		driver.quit();
	}

	//End Extent Report
	@AfterSuite
    public void endReport() {
        extent.flush();
    }

}
