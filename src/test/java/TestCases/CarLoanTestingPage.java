package TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CarLoanPage;

public class CarLoanTestingPage extends TestLandingPage{
	
	CarLoanPage cp ;
	
	//Calling CarLoanPage Class
	@BeforeMethod
	public void setUp(Method method) {
		cp = new CarLoanPage(driver) ;
		
		// Create report
		 test = extent.createTest(method.getName());
	        test.assignAuthor("Neha");
	        test.assignCategory("CarLoanPage Tests");
	        test.assignDevice("Chrome");
	}	
	  
	// Testing CarLoanClick
	@Test(priority =1)
	  public void clickCarLoanTest() throws InterruptedException {
		test.info("Clicking Car Loan");
		try {
	        cp.clickCarLoan();
	        test.pass("Car Loan tab clicked successfully");
	    } catch (Exception e) {
	        test.fail("Failed to click Car Loan tab: " + e.getMessage());
	        Assert.fail("Car Loan tab click failed", e);
	    }
		Thread.sleep(1000);
	  }

	 // Testing  Loan Amount , Interest , Tenure for EMI in Advance
	@Test(priority = 2)
	public void carLoanTest() throws InterruptedException {
		
		test.info("Starting Car Loan Test");
	    try {
	        cp.carLoanAmount();
	        test.pass("Car Loan Amount entered successfully");
	        Thread.sleep(3000);

	        cp.interestRate();
	        test.pass("Interest Rate entered successfully");
	        Thread.sleep(3000);

	        cp.loanTenurePerMonth();
	        test.pass("Loan Tenure entered successfully");
	        Thread.sleep(4000);

	    } catch (Exception e) {
	        test.fail("Car Loan Test failed: " + e.getMessage());
	        Assert.fail("Car Loan Test failed", e);
	    }
	}
	
	// Testing click EMI in Advance
	@Test (priority =3)
	public void clickAdvance() throws InterruptedException {
		test.info("Clicking EMI Advance option");
	    try {
	        cp.clickEmiAdvance();
	        Thread.sleep(1000);
	        test.pass("EMI Advance option clicked successfully");
	    } catch (Exception e) {
	        test.fail("Failed to click EMI Advance option: " + e.getMessage());
	        Assert.fail("Advance option click failed", e);
	    }
	    Thread.sleep(1000);
	}
	
	//Validating Advance Loan EMI details
	@Test(priority =4)
	public void advanceLoan() throws InterruptedException {
		test.info("Validating Advance Loan EMI details");
		System.out.println("Validating Advance Loan EMI details");
	    try {
	        cp.clickYear();
	        Thread.sleep(2000);

	        test.pass("First Month Principal (Advance): " + cp.getFirstMonthPrincipal());
	        System.out.println("First Month Principal (Advance): " + cp.getFirstMonthPrincipal());
	        
	        test.pass("First Month Interest (Advance): " + cp.getFirstMonthInterest());
	        System.out.println("First Month Interest (Advance): " + cp.getFirstMonthInterest());

	        test.pass("Loan EMI (Advance): " + cp.getLoanEmi());
	        System.out.println("Loan EMI (Advance): " + cp.getLoanEmi());
	        
	    } catch (Exception e) {
	        test.fail("Advance Loan EMI validation failed: " + e.getMessage());
	        Assert.fail("Advance Loan EMI failed", e);
	    }
	    Thread.sleep(2000);
		
	}
	
	//Clicking EMI Arrears option
	@Test(priority =5)
	public void clickArrears() throws InterruptedException {
		 test.info("Clicking EMI Arrears option");
		 System.out.println("Clicking EMI Arrears option");
		    try {
		        cp.clickEmiArrears();
		        Thread.sleep(1000);
		        test.pass("EMI Arrears option clicked successfully");
		    } catch (Exception e) {
		        test.fail("Failed to click EMI Arrears option: " + e.getMessage());
		        Assert.fail("Arrears option click failed", e);
		    }
		    Thread.sleep(1000);
	}
	
	//Validating Arrears Loan EMI details
	@Test(priority =6)
	public void arrearLoan() throws InterruptedException {
		test.info("Validating Arrears Loan EMI details");
	    try {
	        cp.clickYear();
	        Thread.sleep(1000);

	        test.pass("First Month Principal (Arrears): " + cp.getFirstMonthPrincipal());
	        System.out.println("First Month Principal (Arrears): " + cp.getFirstMonthPrincipal());

	        test.pass("First Month Interest (Arrears): " + cp.getFirstMonthInterest());
	        System.out.println("First Month Interest (Arrears): " + cp.getFirstMonthInterest());

	        test.pass("Loan EMI (Arrears): " + cp.getLoanEmi());
	        System.out.println("Loan EMI (Arrears): " + cp.getLoanEmi());
	    } catch (Exception e) {
	        test.fail("Arrears Loan EMI validation failed: " + e.getMessage());
	        Assert.fail("Arrears Loan EMI failed", e);
	    }
	    Thread.sleep(2000);
	}
}
