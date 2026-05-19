package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarLoanPage{
	WebDriver driver;
	
	//constructor
	public CarLoanPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By car_Loan_Link = By.linkText("Car Loan");
	By enterLoanAmount = By.id("loanamount");
	By enterInterestRate = By.id("loaninterest");
	By loan_Tenure_Month = By.xpath("//*[@id=\'emicalculatorinnerform\']/div[7]/div/div/div/div/div/label[2]");
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
	
	
	public void carLoanAmount(String cAmount) {
		WebElement carAmount = driver.findElement(enterLoanAmount);
		carAmount.sendKeys(cAmount);
	}
	
	public void interestRate(String cInterest) {
		WebElement carInterestRate = driver.findElement(enterInterestRate);
		carInterestRate.sendKeys(cInterest);
	}
	
	public void loanTenurePerMonth(String cTenure) {
		WebElement carLoanPerMonth = driver.findElement(loan_Tenure_Month);
		carLoanPerMonth.click();
		
		WebElement tenPerMonth = driver.findElement(enterTenure);
		tenPerMonth.sendKeys(cTenure);
	}
	
	
	public void clickEmiAdvance() {
		WebElement emiAdvance = driver.findElement(advanceEMI);
		emiAdvance.click();
	}
	
	public void clickEmiArrears() {
		WebElement emiArrears = driver.findElement(arrearsEMI);
		emiArrears.click();
	}
	
	public void clickYear() {
		WebElement yearInTableAdv = driver.findElement(year_Click);
		yearInTableAdv.click();
	}
	
	public String getFirstMonthPrincipal() {
		WebElement advPrincipal = driver.findElement(principal);
		return advPrincipal.getText();
		
	}
	
	public String getFirstMonthInterest() {
		WebElement advInterest = driver.findElement(interest);
		return advInterest.getText();
	}
	
	public String getLoanEmi() {
		WebElement advLoanEmi = driver.findElement(loanEmi);
		return advLoanEmi.getText();
	}
	
	
	
	
	
	 
	
	
	
	
	
	
       
}

