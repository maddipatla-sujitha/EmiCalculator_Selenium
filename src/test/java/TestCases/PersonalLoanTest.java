package TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.PersonalLoanPage;

public class PersonalLoanTest extends TestLandingPage {

    PersonalLoanPage pp;

    // Setup
    @BeforeMethod
    public void personalLoanSetUp(Method method) throws InterruptedException {
        pp = new PersonalLoanPage(driver);

        // Create Test in Extent Report
        test = extent.createTest(method.getName());
        test.assignAuthor("Rithwik");
        test.assignCategory("Personal Loan Tests");
        test.assignDevice("Chrome");

        pp.clickPLoanTab();
        Thread.sleep(2000);
    }

    // TC01 - Navigate to Personal Loan Tab
    @Test(priority = 1)
    public void clickPersonalLoanTab() throws InterruptedException {
        test.info("Clicking on Personal Loan Tab");
        pp.clickPLoanTab();
        Thread.sleep(2000);
        test.pass("Personal Loan Tab clicked successfully");
    }

    // TC02 - Enter Loan Amount
    @Test(priority = 2)
    public void loanAmount() throws InterruptedException {
        test.info("Entering Loan Amount: ₹15,00,000");
        pp.enter_Loan_Amount();
        Thread.sleep(2000);
        test.pass("Loan Amount entered successfully");
    }

    // TC03 - Enter Interest Rate
    @Test(priority = 3)
    public void interestRate() throws InterruptedException {
        test.info("Entering Interest Rate");
        pp.enter_Interest_rate();
        Thread.sleep(2000);
        test.pass("Interest Rate entered successfully");
    }

    // TC04 - Enter Loan Tenure
    @Test(priority = 4)
    public void loanTenure() throws InterruptedException {
        test.info("Entering Loan Tenure");
        pp.enter_Loan_tenure();
        Thread.sleep(2000);
        test.pass("Loan Tenure entered successfully");
    }

    // TC05 - Verify EMI Per Month is displayed
    @Test(priority = 5)
    public void testGetEMIPerMonth() {
        test.info("Entering loan details to calculate EMI");
        pp.enter_Loan_Amount();
        pp.enter_Interest_rate();
        pp.enter_Loan_tenure();

        test.info("Fetching EMI value");
        String emiValue = pp.returnEMI();
        System.out.println("EMI Value: " + emiValue);

        if (emiValue != null && !emiValue.isEmpty()) {
            test.pass("EMI value displayed successfully: " + emiValue);
        } else {
            test.fail("EMI value is null or empty");
        }

        Assert.assertNotNull(emiValue, "EMI value should not be null");
        Assert.assertFalse(emiValue.isEmpty(), "EMI value should not be empty");
    }

    // TC06 - Verify Principal Amount Per Month from payment schedule
    @Test(priority = 6)
    public void testGetPrincipalAmountPerMonth() {
        test.info("Entering loan details to view payment schedule");
        pp.enter_Loan_Amount();
        pp.enter_Interest_rate();
        pp.enter_Loan_tenure();

        test.info("Expanding 2026 year row in payment schedule");
        pp.clickYear();

        test.info("Fetching Principal Amount from schedule");
        String principalAmount = pp.returnPrincipal();
        System.out.println("Principal Amount: " + principalAmount);

        if (principalAmount != null && !principalAmount.isEmpty()) {
            test.pass("Principal Amount displayed successfully: " + principalAmount);
        } else {
            test.fail("Principal Amount is null or empty");
        }

        Assert.assertNotNull(principalAmount, "Principal amount should not be null");
        Assert.assertFalse(principalAmount.isEmpty(), "Principal amount should not be empty");
    }

    // TC07 - Verify Interest Amount Per Month from payment schedule
    @Test(priority = 7)
    public void testGetInterestAmountPerMonth() {
        test.info("Entering loan details to view payment schedule");
        pp.enter_Loan_Amount();
        pp.enter_Interest_rate();
        pp.enter_Loan_tenure();

        test.info("Expanding 2026 year row in payment schedule");
        pp.clickYear();

        test.info("Fetching Interest Amount from schedule");
        String interestAmount = pp.returnInterestAmount();
        System.out.println("Interest Amount: " + interestAmount);

        if (interestAmount != null && !interestAmount.isEmpty()) {
            test.pass("Interest Amount displayed successfully: " + interestAmount);
        } else {
            test.fail("Interest Amount is null or empty");
        }

        Assert.assertNotNull(interestAmount, "Interest amount should not be null");
        Assert.assertFalse(interestAmount.isEmpty(), "Interest amount should not be empty");
    }
}