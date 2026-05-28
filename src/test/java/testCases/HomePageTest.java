package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.ReusableMethods;

public class HomePageTest extends TestLandingPage{
	HomePage home;
	
	@BeforeMethod
    public void setup() {
        home = new HomePage(ReusableMethods.getDriver());
        //Create Test in Report   
        ReusableMethods.getTest().assignAuthor("Sujitha");
        ReusableMethods.getTest().assignCategory("Homepage Tests");
        ReusableMethods.getTest().assignDevice("Chrome");
    }

	//To check PageTitle
	@Test(priority=0)
	public void verifyHomePageLoads() {
		ReusableMethods.getTest().info("Verifying Home Page Title");
		System.out.println("Verifying Home Page Title");
		Assert.assertTrue(home.getPageTitle().contains("EMI Calculator for Home Loan, Car Loan & Personal Loan in India"));
	}

	//To check if Home Loan tab and Loan Amount is Displayed
	@Test(priority=1)
	public void verifyUIElements() {
		ReusableMethods.getTest().info("Starting UI Elements Verification");
		ReusableMethods.getTest().info("Checking if Home Loan Tab is visible");
	    Assert.assertTrue(home.isHomeLoanTabVisible(), "Home Loan Tab not visible");
	    ReusableMethods.getTest().pass("Home Loan Tab is visible");
	    System.out.println("Checking if Home Loan Tab is clickable");
	    
	    ReusableMethods.getTest().info("Checking if Loan Amount field is displayed");
	    Assert.assertTrue(home.isLoanAmountDisplayed(), "Loan Amount field not displayed");
	    ReusableMethods.getTest().pass("Loan Amount field is displayed");
	    System.out.println("Loan Amount field is displayed");
	    ReusableMethods.getTest().info("UI Elements verification completed successfully");
	}

	//To check if Car Loan tab and Loan Amount is Displayed
	@Test(priority=2)
	public void verifyCarLoanTab() {

		ReusableMethods.getTest().info("Clicking on Car Loan tab");
	    home.clickCarLoan();
	    System.out.println("Checking if Car Loan Tab is clickable");
	    ReusableMethods.getTest().info("Verifying Loan Amount field is displayed");

	    boolean result = home.isLoanAmountDisplayed();

	    if (result) {
	    	ReusableMethods.getTest().pass("Loan Amount field is displayed for Car Loan");
	    } else {
	    	ReusableMethods.getTest().fail("Loan Amount field is NOT displayed for Car Loan");
	    }

	    Assert.assertTrue(result);
	}

	//To check if Personal Loan tab and Loan Amount is Displayed
	@Test(priority=3)
	public void verifyPersonalLoanTab() {

		ReusableMethods.getTest().info("Clicking on Personal Loan tab");
	    home.clickPersonalLoan();

	    ReusableMethods.getTest().info("Verifying Loan Amount field is displayed");
	    System.out.println("Checking if Personal Loan Tab is clickable");
	    boolean result = home.isLoanAmountDisplayed();

	    if (result) {
	    	ReusableMethods.getTest().pass("Loan Amount field is displayed for Personal Loan");
	    } else {
	    	ReusableMethods.getTest().fail("Loan Amount field is NOT displayed for Personal Loan");
	    }

	    Assert.assertTrue(result);
	}

	//To check if Pie Chart is Displayed
	@Test(priority=4)
	public void verifyPieChartVisible() {

		ReusableMethods.getTest().info("Checking if Pie Chart is displayed");
		System.out.println("Checking if Pie chart is displayed");
	    boolean result = home.isChartDisplayed();

	    if (result) {
	    	ReusableMethods.getTest().pass("Pie Chart is displayed");
	    } else {
	    	ReusableMethods.getTest().fail("Pie Chart is NOT displayed");
	    }

	    Assert.assertTrue(result);
	}
	
	//To check if Bar Chart is Displayed
	@Test(priority=5)
	public void verifyBarChartVisible() {

		ReusableMethods.getTest().info("Checking if Bar Chart is displayed");
		System.out.println("Checking if Bar Chart is displayed");
	    boolean result = home.isBarChartDisplayed();

	    if (result) {
	    	ReusableMethods.getTest().pass("Bar Chart is displayed");
	    } else {
	    	ReusableMethods.getTest().fail("Bar Chart is NOT displayed");
	    }
	    Assert.assertTrue(result);
	}
}