package TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTest extends TestLandingPage{
	HomePage home;
	
	@BeforeMethod
    public void init(Method method) {
        home = new HomePage(driver);
        //Create Test in Report
        test = extent.createTest(method.getName());
        test.assignAuthor("Sujitha");
        test.assignCategory("Homepage Tests");
        test.assignDevice("Chrome");

    }

	//To check PageTitle
	@Test(priority=0)
	public void verifyHomePageLoads() {
		test.info("Verifying Home Page Title");
		Assert.assertTrue(home.getPageTitle().contains("EMI Calculator for Home Loan, Car Loan & Personal Loan in India"));
	}

	//To check if Home Loan tab and Loan Amount is Displayed
	@Test(priority=1)
	public void verifyUIElements() {
	    test.info("Starting UI Elements Verification");
	    test.info("Checking if Home Loan Tab is visible");
	    Assert.assertTrue(home.isHomeLoanTabVisible(), "Home Loan Tab not visible");
	    test.pass("Home Loan Tab is visible");

	    test.info("Checking if Loan Amount field is displayed");
	    Assert.assertTrue(home.isLoanAmountDisplayed(), "Loan Amount field not displayed");

	    test.pass("Loan Amount field is displayed");

	    test.info("UI Elements verification completed successfully");
	}

	//To check if Car Loan tab and Loan Amount is Displayed
	@Test(priority=2)
	public void verifyCarLoanTab() {

	    test.info("Clicking on Car Loan tab");
	    home.clickCarLoan();

	    test.info("Verifying Loan Amount field is displayed");

	    boolean result = home.isLoanAmountDisplayed();

	    if (result) {
	        test.pass("Loan Amount field is displayed for Car Loan");
	    } else {
	        test.fail("Loan Amount field is NOT displayed for Car Loan");
	    }

	    Assert.assertTrue(result);
	}

	//To check if Personal Loan tab and Loan Amount is Displayed
	@Test(priority=3)
	public void verifyPersonalLoanTab() {

	    test.info("Clicking on Personal Loan tab");
	    home.clickPersonalLoan();

	    test.info("Verifying Loan Amount field is displayed");

	    boolean result = home.isLoanAmountDisplayed();

	    if (result) {
	        test.pass("Loan Amount field is displayed for Personal Loan");
	    } else {
	        test.fail("Loan Amount field is NOT displayed for Personal Loan");
	    }

	    Assert.assertTrue(result);
	}

	//To check if Pie Chart is Displayed
	@Test(priority=4)
	public void verifyChartVisible() {

	    test.info("Checking if Pie Chart is displayed");

	    boolean result = home.isChartDisplayed();

	    if (result) {
	        test.pass("Pie Chart is displayed");
	    } else {
	        test.fail("Pie Chart is NOT displayed");
	    }

	    Assert.assertTrue(result);
	}
	
	//To check if Bar Chart is Displayed
	@Test(priority=5)
	public void verifyBarChartVisible() {

	    test.info("Checking if Bar Chart is displayed");

	    boolean result = home.isBarChartDisplayed();

	    if (result) {
	        test.pass("Bar Chart is displayed");
	    } else {
	        test.fail("Bar Chart is NOT displayed");
	    }

	    Assert.assertTrue(result);
	}
}


