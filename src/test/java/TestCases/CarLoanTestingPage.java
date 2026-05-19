package TestCases;

import java.util.Scanner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CarLoanPage;

public class CarLoanTestingPage extends TestLandingPage{
	
	CarLoanPage cp ;
	Scanner sc = new Scanner(System.in);
	
	@BeforeMethod
	public void setUp() {
		cp = new CarLoanPage(driver) ;
	}	
	  
	@Test(priority =1)
	  public void clickCarLoanTest() {
		  cp.clickCarLoan();
	  }
	
	@Test(priority =2)
	 public void carLoanTest() {

		System.out.println("Enter the Loan Amount for Car");
		String cAmount = sc.next();
	     cp.carLoanAmount(interestRate);
	      
	      System.out.println("Enter Interest Rate for Car");
	      cInterest = sc.nextDouble();
	      cp.interestRate();
	      System.out.println("Enter Tenure Per Month for Car");
	      cTenure = sc.nextDouble();
	      cp.loanTenurePerMonth();
	
	 }
	@Test(priority =3)
	public void clickAdvance() {
		cp.clickEmiAdvance();
	}
	
	@Test(priority =4)
	public void advanceLoan() {
		cp.clickYearAdv();
		cp.getFirstMonthPrincipal_Adv();
		cp.getFirstMonthInterest_Adv();
		cp.getAdvanceLoanEmi();
	}
	
	@Test(priority =5)
	public void clickArrears() {
		cp.clickEmiArrears();
	}
	
	@Test(priority =6)
	public void arrearLoan() {
		cp.clickYearArr();
		cp.getFirstMonthPrincipal_Arr();
		cp.getFirstMonthInterest_Arr();
		cp.getArrearsLoanEmi();
	}
	
	
	
}
