package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.PersonalLoanPage;

public class PersonalLoanTest extends TestLandingPage {

    PersonalLoanPage pp;

    // Setup
    @Test(priority=0)
    public void personalLoanSetUp() throws InterruptedException {
        pp = new PersonalLoanPage(getDriver());

        // Create Test in Extent Report
        getTest().assignAuthor("Rithwik");
        getTest().assignCategory("Personal Loan Tests");
        getTest().assignDevice("Chrome");
    }

    // TC01 - Navigate to Personal Loan Tab
    @Test(priority = 1)
    public void clickPersonalLoanTab() throws InterruptedException {
    	getTest().info("Clicking on Personal Loan Tab");
        pp.clickPLoanTab();
        Thread.sleep(2000);
        getTest().pass("Personal Loan Tab clicked successfully");
    }

    // TC02 - Enter Loan Amount
    @Test(priority = 2)
    public void loanAmount() throws InterruptedException {
    	getTest().info("Entering Loan Amount: ₹15,00,000");
        pp.enter_Loan_Amount();
        Thread.sleep(2000);
        getTest().pass("Loan Amount entered successfully");
    }

    // TC03 - Enter Interest Rate
    @Test(priority = 3)
    public void interestRate() throws InterruptedException {
    	getTest().info("Entering Interest Rate");
        pp.enter_Interest_rate();
        Thread.sleep(2000);
        getTest().pass("Interest Rate entered successfully");
    }

    // TC04 - Enter Loan Tenure
    @Test(priority = 4)
    public void loanTenure() throws InterruptedException {
    	getTest().info("Entering Loan Tenure");
        pp.enter_Loan_tenure();
        Thread.sleep(2000);
        getTest().pass("Loan Tenure entered successfully");
    }

    // TC05 - Verify EMI Per Month is displayed
    @Test(priority = 5)
    public void testGetEMIPerMonth() {
        getTest().info("Fetching EMI value");
        String emiValue = pp.returnEMI();
        System.out.println("Total EMI Value per month(Personal Loan): " + emiValue);

        if (emiValue != null && !emiValue.isEmpty()) {
        	getTest().pass("EMI value displayed successfully: " + emiValue);
        } else {
        	getTest().fail("EMI value is null or empty");
        }

        Assert.assertNotNull(emiValue, "EMI value should not be null");
        Assert.assertFalse(emiValue.isEmpty(), "EMI value should not be empty");
    }

    // TC06 - Verify Principal Amount Per Month from payment schedule
    @Test(priority = 6)
    public void testGetPrincipalAmountPerMonth() {
        getTest().info("Expanding 2026 year row in payment schedule");
        pp.clickYear();

        getTest().info("Fetching Principal Amount from schedule");
        String principalAmount = pp.returnPrincipal();
        System.out.println("Principal Amount per month(Personal Loan): " + principalAmount);

        if (principalAmount != null && !principalAmount.isEmpty()) {
        	getTest().pass("Principal Amount displayed successfully: " + principalAmount);
        } else {
        	getTest().fail("Principal Amount is null or empty");
        }

        Assert.assertNotNull(principalAmount, "Principal amount should not be null");
        Assert.assertFalse(principalAmount.isEmpty(), "Principal amount should not be empty");
    }

    // TC07 - Verify Interest Amount Per Month from payment schedule
    @Test(priority = 7)
    public void testGetInterestAmountPerMonth() {
    	getTest().info("Entering loan details to view payment schedule");
        pp.enter_Loan_Amount();
        pp.enter_Interest_rate();
        pp.enter_Loan_tenure();

        getTest().info("Expanding 2026 year row in payment schedule");
        pp.clickYear();

        getTest().info("Fetching Interest Amount from schedule");
        String interestAmount = pp.returnInterestAmount();
        System.out.println("Interest Amount per month(Personal Loan): " + interestAmount);

        if (interestAmount != null && !interestAmount.isEmpty()) {
        	getTest().pass("Interest Amount displayed successfully: " + interestAmount);
        } else {
        	getTest().fail("Interest Amount is null or empty");
        }

        Assert.assertNotNull(interestAmount, "Interest amount should not be null");
        Assert.assertFalse(interestAmount.isEmpty(), "Interest amount should not be empty");
    }
}