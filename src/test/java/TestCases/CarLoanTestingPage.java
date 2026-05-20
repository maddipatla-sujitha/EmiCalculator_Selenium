package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CarLoanPage;

public class CarLoanTestingPage extends TestLandingPage{
	
	CarLoanPage cp ;
	
	//Calling CarLoanPage Class
	@BeforeMethod
	public void setUp() {
		cp = new CarLoanPage(driver) ;
	}	
	  
	@Test(priority =1)
	  public void clickCarLoanTest() {
		  cp.clickCarLoan();
	  }

	@Test(priority = 2)
	public void carLoanTest() throws InterruptedException {
		
	    cp.carLoanAmount();
	    Thread.sleep(3000);
	    cp.interestRate();
	    Thread.sleep(3000);
	    cp.loanTenurePerMonth();
	    Thread.sleep(4000);
	    
	}
	
	@Test (priority =3)
	public void clickAdvance() throws InterruptedException {
		cp.clickEmiAdvance();
		Thread.sleep(1000);
	}
	
	@Test(priority =4)
	public void advanceLoan() throws InterruptedException {
		cp.clickYear();
		Thread.sleep(1000);
		System.out.println("First Month Principal of EMI in Advance" + cp.getFirstMonthPrincipal());
		Thread.sleep(1000);
		System.out.println("First Month Interest of EMI in Advance" +cp.getFirstMonthInterest());
		Thread.sleep(1000);
		System.out.println("First Month Loan EMI of EMI in Advance" + cp.getLoanEmi());
		
	}
	
	@Test(priority =5)
	public void clickArrears() throws InterruptedException {
		cp.clickEmiArrears();
		Thread.sleep(1000);
	}
	
	@Test(priority =6)
	public void arrearLoan() throws InterruptedException {
		cp.clickYear();
		Thread.sleep(1000);
		System.out.println("First Month Principal of EMI in Arrears" + cp.getFirstMonthPrincipal());
		Thread.sleep(1000);
		System.out.println("First Month Interest of EMI in Arrears" +cp.getFirstMonthInterest());
		Thread.sleep(1000);
		System.out.println("First Month Loan EMI of EMI in Arrears" + cp.getLoanEmi());
	}
}
