package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarLoanPage{
	WebDriver driver;
	
	
	public CarLoanPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By car_Loan_Link = By.linkText("Car Loan");
	By enterLoanAmount = By.id("loanamount");
	By enterInterestRate = By.id("loaninterest");
	By enterTenure = By.id("loanterm");
	
	By advanceEMI = By.xpath("//*[@id=\'leschemewrapper\']/div/div/div/div/label[1]");
	By arrearsEMI = By.xpath("//*[@id=\'leschemewrapper\']/div/div/div/div/label[2]");
	By year_Click = By.id("year2026");
	
	By principal = By.xpath("//*[@id=\'monthyear2026\']/td/div/table/tbody/tr[1]/td[2]");
	By interest = By.xpath("//*[@id=\'monthyear2026\']/td/div/table/tbody/tr[1]/td[3]");
	By loanEmi = By.xpath("//*[@id=\'emiamount\']/p/span");

	

	

	//To click the car loan text
	public void clickCarLoan() {
		WebElement carLink = driver.findElement(car_Loan_Link);
		carLink.click();
	}
	
	//Enter the Amount 
	public void carLoanAmount() {
		
		WebElement carLoan = driver.findElement(enterLoanAmount);
		carLoan.clear();
		carLoan.sendKeys("1500000");

	}
	
	// Enter the Interest
	public void interestRate() {
		WebElement carInterest = driver.findElement(enterInterestRate);
		carInterest.clear();
		carInterest.sendKeys(".5");

	}
	
	//Enter Tenure
	public void loanTenurePerMonth() {
		WebElement carTenure = driver.findElement(enterTenure);
		carTenure.clear();
		carTenure.sendKeys("");

	}
	
	// Click EMI in Advance
	public void clickEmiAdvance() {
		WebElement emiAdvance = driver.findElement(advanceEMI);
		emiAdvance.click();
	}
	
	//Click EMI in Arrears
	public void clickEmiArrears() {
		WebElement emiArrears = driver.findElement(arrearsEMI);
		emiArrears.click();
	}
	
	// Click Year Field
	public void clickYear() {
		WebElement yearInTableAdv = driver.findElement(year_Click);
		yearInTableAdv.click();
	}
	
	// Get First Month Principal 
	public String getFirstMonthPrincipal() {
		WebElement advPrincipal = driver.findElement(principal);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",advPrincipal);
		return advPrincipal.getText();
		
	}
	
	// Get First Month Interest
	public String getFirstMonthInterest() {
		WebElement advInterest = driver.findElement(interest);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",advInterest);
		return advInterest.getText();
	}
	
	//Get Loan EMI
	public String getLoanEmi() {
		WebElement advLoanEmi = driver.findElement(loanEmi);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",advLoanEmi);
		return advLoanEmi.getText();
	}


       
}

