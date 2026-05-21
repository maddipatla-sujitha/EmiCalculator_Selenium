 package testCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CarLoanPage;
import utils.ExcelUtility;
import utils.ReusableMethods;

public class CarLoanPageTest extends TestLandingPage{
	
	CarLoanPage cp ;
	
	//Calling CarLoanPage Class
	@BeforeMethod
	public void setUp(Method method) {
		cp = new CarLoanPage(ReusableMethods.getDriver()) ;
		
		ReusableMethods.getTest().assignAuthor("Neha");
		ReusableMethods.getTest().assignCategory("CarLoanPage Tests");
		ReusableMethods.getTest().assignDevice("Chrome");
	}	
	  
	// Testing CarLoanClick
	@Test(priority =1)
	  public void clickCarLoanTest() throws InterruptedException {
		ReusableMethods.getTest().info("Clicking Car Loan");
		try {
	        cp.clickCarLoan();
	        ReusableMethods.getTest().pass("Car Loan tab clicked successfully");
	    } catch (Exception e) {
	    	ReusableMethods.getTest().fail("Failed to click Car Loan tab: " + e.getMessage());
	        Assert.fail("Car Loan tab click failed", e);
	    }
		Thread.sleep(1000);
	  }

	 // Testing  Loan Amount , Interest , Tenure for EMI in Advance
	@Test(priority = 2)
	public void carLoanTest() throws InterruptedException {
		
		ReusableMethods.getTest().info("Starting Car Loan Test");
	    try {
	        cp.carLoanAmount();
	        ReusableMethods.getTest().pass("Car Loan Amount entered successfully");
	        Thread.sleep(3000);

	        cp.interestRate();
	        ReusableMethods.getTest().pass("Interest Rate entered successfully");
	        Thread.sleep(3000);

	        cp.loanTenurePerMonth();
	        ReusableMethods.getTest().pass("Loan Tenure entered successfully");
	        Thread.sleep(4000);

	    } 
	    catch (Exception e) {
	    	ReusableMethods.getTest().fail("Car Loan Test failed: " + e.getMessage());
	        Assert.fail("Car Loan Test failed", e);
	    }
	}
	
	// Testing click EMI in Advance
	@Test (priority =3)
	public void clickAdvance() throws InterruptedException {
		ReusableMethods.getTest().info("Clicking EMI Advance option");
	    try {
	        cp.clickEmiAdvance();
	        Thread.sleep(1000);
	        ReusableMethods.getTest().pass("EMI Advance option clicked successfully");
	    } catch (Exception e) {
	    	ReusableMethods.getTest().fail("Failed to click EMI Advance option: " + e.getMessage());
	        Assert.fail("Advance option click failed", e);
	    }
	    Thread.sleep(1000);
	}
	
	//Validating Advance Loan EMI details
	@Test(priority =4)
	public void advanceLoan() throws InterruptedException {
		ReusableMethods.getTest().info("Validating Advance Loan EMI details");
		System.out.println("Validating Advance Loan EMI details(Car Loan)");
	    try {
	        cp.clickYear();
	        Thread.sleep(2000);

	        ReusableMethods.getTest().pass("First Month Principal (Advance): " + cp.getFirstMonthPrincipal());
	        System.out.println("First Month Principal (Advance)(Car Loan): " + cp.getFirstMonthPrincipal());
	        
	        ReusableMethods.getTest().pass("First Month Interest (Advance): " + cp.getFirstMonthInterest());
	        System.out.println("First Month Interest (Advance)(Car Loan): " + cp.getFirstMonthInterest());

	        ReusableMethods.getTest().pass("Loan EMI (Advance): " + cp.getLoanEmi());
	        System.out.println("Loan EMI (Advance)(Car Loan): " + cp.getLoanEmi());
	        
	    } catch (Exception e) {
	    	ReusableMethods.getTest().fail("Advance Loan EMI validation failed: " + e.getMessage());
	        Assert.fail("Advance Loan EMI failed", e);
	    }
	    Thread.sleep(2000);
		
	}
	
	//Clicking EMI Arrears option
	@Test(priority =5)
	public void clickArrears() throws InterruptedException {
		ReusableMethods.getTest().info("Clicking EMI Arrears option");
		 System.out.println("Clicking EMI Arrears option(Car Loan)");
		    try {
		        cp.clickEmiArrears();
		        Thread.sleep(1000);
		        ReusableMethods.getTest().pass("EMI Arrears option clicked successfully");
		    } catch (Exception e) {
		    	ReusableMethods.getTest().fail("Failed to click EMI Arrears option: " + e.getMessage());
		        Assert.fail("Arrears option click failed", e);
		    }
		    Thread.sleep(1000);
	}
	
	//Validating Arrears Loan EMI details
	@Test(priority =6)
	public void arrearLoan() throws InterruptedException {
		ReusableMethods.getTest().info("Validating Arrears Loan EMI details");
	    try {
	        cp.clickYear();
	        Thread.sleep(1000);

	        ReusableMethods.getTest().pass("First Month Principal (Arrears): " + cp.getFirstMonthPrincipal());
	        System.out.println("First Month Principal (Arrears)(Car Loan): " + cp.getFirstMonthPrincipal());

	        ReusableMethods.getTest().pass("First Month Interest (Arrears): " + cp.getFirstMonthInterest());
	        System.out.println("First Month Interest (Arrears)(Car Loan): " + cp.getFirstMonthInterest());

	        ReusableMethods.getTest().pass("Loan EMI (Arrears): " + cp.getLoanEmi());
	        System.out.println("Loan EMI (Arrears)(Car Loan): " + cp.getLoanEmi());
	    } catch (Exception e) {
	    	ReusableMethods.getTest().fail("Arrears Loan EMI validation failed: " + e.getMessage());
	        Assert.fail("Arrears Loan EMI failed", e);
	    }
	    Thread.sleep(2000);
	}
	
	//Write Loan Amount, InterestRate and TotalEMI per month in excel
	@Test(priority = 7)
	public void writeCarLoanDataToExcel() throws Exception {

	    // Enter data
	    cp.carLoanAmount();
	    cp.interestRate();
	    cp.loanTenurePerMonth();

	    //Select Advance
	    cp.clickEmiAdvance();

	    cp.clickYear();

	    String advPrincipal = cp.getFirstMonthPrincipal();
	    String advInterest = cp.getFirstMonthInterest();
	    String advEmi = cp.getLoanEmi();

	    //Write Advance data
	    ExcelUtility.writeCarLoanData("Advance", advPrincipal, advInterest, advEmi);

	    //Step 3: Switch to Arrears
	    cp.clickEmiArrears();
	    Thread.sleep(1000);

	    cp.clickYear();
	    Thread.sleep(1000);

	    String arrPrincipal = cp.getFirstMonthPrincipal();
	    String arrInterest = cp.getFirstMonthInterest();
	    String arrEmi = cp.getLoanEmi();

	    //Write Arrears data
	    ExcelUtility.writeCarLoanData("Arrears", arrPrincipal, arrInterest, arrEmi);
	}
}
