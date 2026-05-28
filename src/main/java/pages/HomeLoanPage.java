package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeLoanPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public HomeLoanPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	By loanAmount=By.id("loanamount");
	By interestRate=By.id("loaninterest");
	By loanTenure=By.id("loanterm");
	
	By emiValuePerMonth=By.xpath("//*[@id=\'emiamount\']/p/span");
	By year=By.id("year2026");
	By PrincipalAmountPerMonthHome=By.xpath("//*[@id=\'monthyear2026\']/td/div/table/tbody/tr[1]/td[2]");
	By InterestAmountPerMonthHome=By.xpath("//*[@id=\'monthyear2026\']/td/div/table/tbody/tr[1]/td[3]");
	
	//verify the home loan page
	public String verifyHomePage() {
		String title=driver.getTitle();
		return title;
	}
	
	//Enter the loan amount
	public void enterLoanAmount() {
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(loanAmount));
		element.clear();
		element.sendKeys("1500000");
	}

	//Enter the interest rate
	public void enterInterestRate() {
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(interestRate));
		element.clear();
		element.sendKeys(".5");

 	}
	
	//Enter the loan tenure
	public void enterLoanTenure() {
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(loanTenure));
		element1.clear();
//		element1.sendKeys("-1");
	}
	
	//Get EMI value
	public String getEMIPerMonth() { 
		
		WebElement emi=wait.until(ExpectedConditions.visibilityOfElementLocated(emiValuePerMonth));
				return emi.getText();
	}
    
	//Click Year in Table
	public void  clickYearTable() {
		 WebElement Year26P= driver.findElement(year);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", Year26P);
		 Year26P.click();
	}
	
	//Scroll down to year table
	 public String getHomePrincipalAmountPerMonth() {
	        WebElement elementA = wait.until(ExpectedConditions.visibilityOfElementLocated(PrincipalAmountPerMonthHome));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", elementA);
			return elementA.getText();
	    }
	
	//Get InterestAmount
	public String getHomeInterestAmountPerMonth() {
		WebElement elementI=wait.until(ExpectedConditions.visibilityOfElementLocated(InterestAmountPerMonthHome));
		return elementI.getText();
	}
	
}
