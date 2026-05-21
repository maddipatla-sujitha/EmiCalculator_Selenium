package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTest extends TestLandingPage{
	HomePage home;
	
	@Test(priority=-1)
    public void init() {
        home = new HomePage(getDriver());
        //Create Test in Report
        
        getTest().assignAuthor("Sujitha");
        getTest().assignCategory("Homepage Tests");
        getTest().assignDevice("Chrome");

    }

	//To check PageTitle
	@Test(priority=0)
	public void verifyHomePageLoads() {
		getTest().info("Verifying Home Page Title");
		Assert.assertTrue(home.getPageTitle().contains("EMI Calculator for Home Loan, Car Loan & Personal Loan in India"));
	}

	//To check if Home Loan tab and Loan Amount is Displayed
	@Test(priority=1)
	public void verifyUIElements() {
		getTest().info("Starting UI Elements Verification");
		getTest().info("Checking if Home Loan Tab is visible");
	    Assert.assertTrue(home.isHomeLoanTabVisible(), "Home Loan Tab not visible");
	    getTest().pass("Home Loan Tab is visible");

	    getTest().info("Checking if Loan Amount field is displayed");
	    Assert.assertTrue(home.isLoanAmountDisplayed(), "Loan Amount field not displayed");

	    getTest().pass("Loan Amount field is displayed");

	    getTest().info("UI Elements verification completed successfully");
	}

	//To check if Car Loan tab and Loan Amount is Displayed
	@Test(priority=2)
	public void verifyCarLoanTab() {

		getTest().info("Clicking on Car Loan tab");
	    home.clickCarLoan();

	    getTest().info("Verifying Loan Amount field is displayed");

	    boolean result = home.isLoanAmountDisplayed();

	    if (result) {
	    	getTest().pass("Loan Amount field is displayed for Car Loan");
	    } else {
	    	getTest().fail("Loan Amount field is NOT displayed for Car Loan");
	    }

	    Assert.assertTrue(result);
	}

	//To check if Personal Loan tab and Loan Amount is Displayed
	@Test(priority=3)
	public void verifyPersonalLoanTab() {

		getTest().info("Clicking on Personal Loan tab");
	    home.clickPersonalLoan();

	    getTest().info("Verifying Loan Amount field is displayed");

	    boolean result = home.isLoanAmountDisplayed();

	    if (result) {
	    	getTest().pass("Loan Amount field is displayed for Personal Loan");
	    } else {
	    	getTest().fail("Loan Amount field is NOT displayed for Personal Loan");
	    }

	    Assert.assertTrue(result);
	}

	//To check if Pie Chart is Displayed
	@Test(priority=4)
	public void verifyChartVisible() {

		getTest().info("Checking if Pie Chart is displayed");

	    boolean result = home.isChartDisplayed();

	    if (result) {
	    	getTest().pass("Pie Chart is displayed");
	    } else {
	    	getTest().fail("Pie Chart is NOT displayed");
	    }

	    Assert.assertTrue(result);
	}
	
	//To check if Bar Chart is Displayed
	@Test(priority=5)
	public void verifyBarChartVisible() {

		getTest().info("Checking if Bar Chart is displayed");

	    boolean result = home.isBarChartDisplayed();

	    if (result) {
	    	getTest().pass("Bar Chart is displayed");
	    } else {
	    	getTest().fail("Bar Chart is NOT displayed");
	    }

	    Assert.assertTrue(result);
	}
}


