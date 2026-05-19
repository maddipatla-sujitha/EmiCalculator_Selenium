package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTest extends TestLandingPage{
	HomePage home;
	

	@BeforeMethod
    public void initPage() {
        home = new HomePage(driver);  
    }

	
		//To check PageTitle
		@Test
		public void verifyHomePageLoads() {
	        Assert.assertTrue(home.getPageTitle().contains("EMI Calculator for Home Loan, Car Loan & Personal Loan in India"));
	    }
		
		//To check if Home Loan tab and Loan Amount is Displayed
	    @Test
	    public void verifyUIElements() {
	        Assert.assertTrue(home.isHomeLoanTabVisible());
	        Assert.assertTrue(home.isLoanAmountDisplayed());
	    }
	    
	    //To check if Car Loan tab and Loan Amount is Displayed
	    @Test
	    public void verifyCarLoanTab() {
	        home.clickCarLoan();
	        Assert.assertTrue(home.isLoanAmountDisplayed());
	    }
	    
	    //To check if Personal Loan tab and Loan Amount is Displayed
	    @Test
	    public void verifyPersonalLoanTab() {
	        home.clickPersonalLoan();
	        Assert.assertTrue(home.isLoanAmountDisplayed());
	    }
	    
	    //To check if Pie Chart is Displayed
	    @Test
	    public void verifyChartVisible() {
	        Assert.assertTrue(home.isChartDisplayed());
	    }
	    
	    //To check if Bar Chart is Displayed
	    @Test
	    public void verifyBarChartVisisble() {
	    	Assert.assertTrue(home.isBarChartDisplayed());
	    }
}


