package testCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomeLoanPage;
import utils.ExcelUtility;
import utils.ReusableMethods;

public class HomeLoanPageTest extends TestLandingPage {
    HomeLoanPage hp;
    
    // Setup
    @BeforeMethod
    public void homeSetUp(Method method) throws InterruptedException {
        hp = new HomeLoanPage(ReusableMethods.getDriver());

        ReusableMethods.getTest().assignAuthor("Laya");
        ReusableMethods.getTest().assignCategory("HomeLoanPage Tests");
        ReusableMethods.getTest().assignDevice("Chrome");      
        ReusableMethods.waitForPageToLoad();
    }
    
    //enter the Loan amount, Interest Rate, Loan Tenure
    @Test(priority=1)
    public void loanDetails() throws InterruptedException {

    	ReusableMethods.getTest().info("Starting Car Loan Test");
	    try {
	        hp.enterLoanAmount();
	        ReusableMethods.getTest().pass("Car Loan Amount entered successfully");
	        ReusableMethods.waitForPageToLoad();

	        hp.enterInterestRate();
	        ReusableMethods.getTest().pass("Interest Rate entered successfully");
	        ReusableMethods.waitForPageToLoad();

	        hp.enterLoanTenure();
	        ReusableMethods.getTest().pass("Loan Tenure entered successfully");
	        ReusableMethods.waitForPageToLoad();

	    } catch (Exception e) {
	    	ReusableMethods.getTest().fail("Car Loan Test failed: " + e.getMessage());
	        Assert.fail("Car Loan Test failed", e);
	    }
	    ReusableMethods.waitForPageToLoad();
    }


    //Return Total Amount Per month
    @Test(priority=2)
    public void testGetEMIPerMonth() {

    	ReusableMethods.getTest().info("Fetching EMI Per Month");

    	try {
    		String emi = hp.getEMIPerMonth();
    		ReusableMethods.getTest().pass("Total EMI Per Month(Home Loan): " + emi);
    		System.out.println("EMI Per Month: " + emi);
    	} catch (Exception e) {
    		ReusableMethods.getTest().fail("Failed to fetch EMI: " + e.getMessage());
    		Assert.fail("EMI fetch failed", e);
    	}
    }


    //Return Principal Amount Per month
    @Test(priority=3)
    public void testGetPrincipalAmountPerMonth() {

    	ReusableMethods.getTest().info("Fetching Principal Amount");

        try {
        	
        	hp.clickYearTable();
        	
            String principal = hp.getHomePrincipalAmountPerMonth();
            ReusableMethods.getTest().pass("Principal Amount: " + principal);
            System.out.println("Principal Amount per month(Home Loan): " + principal);
        } catch (Exception e) {
        	ReusableMethods.getTest().fail("Principal fetch failed: " + e.getMessage());
            Assert.fail("Principal failed", e);
        }
    }

    // Return Interest Amount Per Month
    @Test(priority=4)
    public void testGetInterestAmountPerMonth() {

    	ReusableMethods.getTest().info("Fetching Interest Amount");

    	try {
    		String interest = hp.getHomeInterestAmountPerMonth();
    		ReusableMethods.getTest().pass("Interest Amount: " + interest);
    		System.out.println("Interest Amount per month(Home Loan): " + interest);
    	} catch (Exception e) {
    		ReusableMethods.getTest().fail("Interest fetch failed: " + e.getMessage());
    		Assert.fail("Interest failed", e);
    	}
    }
    
    //Write Loan Amount, InterestRate and TotalEMI per month in excel
    @Test(priority = 5)
    public void writeHomeLoanDataToExcel() throws Exception {

        //enter values
        hp.enterLoanAmount();
        hp.enterInterestRate();
        hp.enterLoanTenure();

        //fetch values
        hp.clickYearTable();
        ReusableMethods.waitForPageToLoad();
        
        String emi = hp.getEMIPerMonth();
        String principal = hp.getHomePrincipalAmountPerMonth();
        String interest = hp.getHomeInterestAmountPerMonth();

        //write to Excel
        ExcelUtility.writeHomeLoanData(principal, interest, emi);
    }

}
















