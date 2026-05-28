package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PersonalLoanPage;
import utils.ExcelUtility;
import utils.ReusableMethods;

public class PersonalLoanPageTest extends TestLandingPage {

    PersonalLoanPage pp;
    
    // Setup
    @BeforeMethod
    public void personalLoanSetUp() throws InterruptedException {
        pp = new PersonalLoanPage(ReusableMethods.getDriver());

        // Create Test in Extent Report
        ReusableMethods.getTest().assignAuthor("Rithwik");
        ReusableMethods.getTest().assignCategory("Personal Loan Tests");
        ReusableMethods.getTest().assignDevice("Chrome");
    }

    // TC01 - Navigate to Personal Loan Tab
    @Test(priority = 1)
    public void clickPersonalLoanTab() throws InterruptedException {
    	ReusableMethods.getTest().info("Clicking on Personal Loan Tab");
        pp.clickPLoanTab();
        ReusableMethods.waitForPageToLoad();
        ReusableMethods.getTest().pass("Personal Loan Tab clicked successfully");
    }

    // TC02 - Enter Loan Amount, Interest Rate and Loan Tenure
    @Test(priority = 2)
    public void loanDetails() throws InterruptedException {
    	ReusableMethods.getTest().info("Starting Car Loan Test");
	    try {
	        pp.enterLoanAmount();
	        ReusableMethods.getTest().pass("Car Loan Amount entered successfully");
	        ReusableMethods.waitForPageToLoad();

	        pp.enterInterestRate();
	        ReusableMethods.getTest().pass("Interest Rate entered successfully");
	        ReusableMethods.waitForPageToLoad();

	        pp.enterLoanTenure();
	        ReusableMethods.getTest().pass("Loan Tenure entered successfully");
	        ReusableMethods.waitForPageToLoad();

	    } catch (Exception e) {
	    	ReusableMethods.getTest().fail("Car Loan Test failed: " + e.getMessage());
	        Assert.fail("Car Loan Test failed", e);
	    }
    }


    // TC05 - Verify EMI Per Month is displayed
    @Test(priority = 3)
    public void testGetEMIPerMonth() {
    	ReusableMethods.getTest().info("Fetching EMI value");
        String emiValue = pp.getEMIPerMonth();
        System.out.println("Total EMI Value per month(Personal Loan): " + emiValue);

        if (emiValue != null && !emiValue.isEmpty()) {
        	ReusableMethods.getTest().pass("EMI value displayed successfully: " + emiValue);
        } else {
        	ReusableMethods.getTest().fail("EMI value is null or empty");
        }

        Assert.assertNotNull(emiValue, "EMI value should not be null");
        Assert.assertFalse(emiValue.isEmpty(), "EMI value should not be empty");
    }

    // TC06 - Verify Principal Amount Per Month from payment schedule
    @Test(priority = 4)
    public void testGetPrincipalAmountPerMonth() {
    	ReusableMethods.getTest().info("Expanding 2026 year row in payment schedule");
        pp.clickYear();

        ReusableMethods.getTest().info("Fetching Principal Amount from schedule");
        String principalAmount = pp.getPrincipalAmountPerMonth();
        System.out.println("Principal Amount per month(Personal Loan): " + principalAmount);

        if (principalAmount != null && !principalAmount.isEmpty()) {
        	ReusableMethods.getTest().pass("Principal Amount displayed successfully: " + principalAmount);
        } else {
        	ReusableMethods.getTest().fail("Principal Amount is null or empty");
        }

        Assert.assertNotNull(principalAmount, "Principal amount should not be null");
        Assert.assertFalse(principalAmount.isEmpty(), "Principal amount should not be empty");
    }

    // TC07 - Verify Interest Amount Per Month from payment schedule
    @Test(priority = 5)
    public void testGetInterestAmountPerMonth() {
    	ReusableMethods.getTest().info("Entering loan details to view payment schedule");
        pp.enterLoanAmount();
        pp.enterInterestRate();
        pp.enterLoanTenure();

        ReusableMethods.getTest().info("Expanding 2026 year row in payment schedule");
        pp.clickYear();

        ReusableMethods.getTest().info("Fetching Interest Amount from schedule");
        String interestAmount = pp.getInterestAmountPerMonth();
        System.out.println("Interest Amount per month(Personal Loan): " + interestAmount);

        if (interestAmount != null && !interestAmount.isEmpty()) {
        	ReusableMethods.getTest().pass("Interest Amount displayed successfully: " + interestAmount);
        } else {
        	ReusableMethods.getTest().fail("Interest Amount is null or empty");
        }

        Assert.assertNotNull(interestAmount, "Interest amount should not be null");
        Assert.assertFalse(interestAmount.isEmpty(), "Interest amount should not be empty");
    }
    
  //Write Loan Amount, InterestRate and TotalEMI per month in excel
    @Test(priority = 6)
    public void writePersonalLoanDataToExcel() throws Exception {

        //enter values
        pp.enterLoanAmount();
        pp.enterInterestRate();
        pp.enterLoanTenure();

        //fetch values
        pp.clickYear();
        ReusableMethods.waitForPageToLoad();
        
        String emi = pp.getEMIPerMonth();
        String principal = pp.getPrincipalAmountPerMonth();
        String interest = pp.getInterestAmountPerMonth();

        //write to Excel
        ExcelUtility.writePersonalLoanData(principal, interest, emi);
    }
}