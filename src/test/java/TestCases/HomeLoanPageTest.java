package TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import Pages.HomeLoanPage;

public class HomeLoanPageTest extends TestLandingPage {

    HomeLoanPage hp;

    // Setup
    @BeforeMethod
    public void homeSetUp(Method method) throws InterruptedException {
        hp = new HomeLoanPage(driver);

        test = extent.createTest(method.getName());
        test.assignAuthor("Laya");
        test.assignCategory("HomeLoanPage Tests");
        test.assignDevice("Chrome");

        

        Thread.sleep(1000);
    }
    
    //enter the loan amount
    @Test(priority=1)
    public void loanAmount() throws InterruptedException {

    	 test.info("Entering Loan Amount");

    	        try {
    	            hp.enterLoanAmount();
    	            test.pass("Loan Amount entered successfully");
    	        } catch (Exception e) {
    	            test.fail("Loan Amount entry failed: " + e.getMessage());
    	            Assert.fail("Loan Amount failed", e);
    	        }

    	        Thread.sleep(1000);
    	    }

    
    //enter the interest rate
    @Test(priority=2)
    public void interestRate() throws InterruptedException {

test.info("Entering Interest Rate");

        try {
            hp.enterInterestRate();
            test.pass("Interest Rate entered successfully");
        } catch (Exception e) {
            test.fail("Interest Rate failed: " + e.getMessage());
            Assert.fail("Interest rate failed", e);
        }

        Thread.sleep(1000);
    }

    
    //enter the loanTenure
    @Test(priority=3)
    public void LoanTenure() throws InterruptedException {

    	 test.info("Entering Loan Tenure");

    	        try {
    	            hp.enterLoanTenure();
    	            test.pass("Loan Tenure entered successfully");
    	        } catch (Exception e) {
    	            test.fail("Loan Tenure failed: " + e.getMessage());
    	            Assert.fail("Loan Tenure failed", e);
    	        }

    	        Thread.sleep(1000);
    	    }


    //Return Total Amount Per month
    @Test(priority=4)
    public void testGetEMIPerMonth() {

    	 test.info("Fetching EMI Per Month");

    	        try {
    	            String emi = hp.getEMIPerMonth();
    	            test.pass("EMI Per Month: " + emi);
    	            System.out.println("EMI Per Month: " + emi);
    	        } catch (Exception e) {
    	            test.fail("Failed to fetch EMI: " + e.getMessage());
    	            Assert.fail("EMI fetch failed", e);
    	        }
    	    }


    //Return Principal Amount Per month
    @Test(priority=5)
    public void testGetPrincipalAmountPerMonth() {

test.info("Fetching Principal Amount");

        try {
            String principal = hp.getPrincipalAmountPerMonth();
            test.pass("Principal Amount: " + principal);
            System.out.println("Principal Amount: " + principal);
        } catch (Exception e) {
            test.fail("Principal fetch failed: " + e.getMessage());
            Assert.fail("Principal failed", e);
        }
    }

    // Return Interest Amount Per Month
    @Test(priority=6)
    public void testGetInterestAmountPerMonth() {

    	 test.info("Fetching Interest Amount");

    	        try {
    	            String interest = hp.getInterestAmountPerMonth();
    	            test.pass("Interest Amount: " + interest);
    	            System.out.println("Interest Amount: " + interest);
    	        } catch (Exception e) {
    	            test.fail("Interest fetch failed: " + e.getMessage());
    	            Assert.fail("Interest failed", e);
    	        }
    	    }

}
















