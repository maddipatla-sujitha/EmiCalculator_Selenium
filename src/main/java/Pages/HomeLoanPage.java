package Pages;

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
	By PrincipalAmountPerMonth=By.xpath("//*[@id=\'monthyear2026\']/td/div/table/tbody/tr[1]/td[2]");
	By InterestAmountPerMonth=By.xpath("//*[@id=\'monthyear2026\']/td/div/table/tbody/tr[1]/td[3]");
	
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
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(loanTenure));
		element.clear();
	}
	
	//Get EMI value
	public String getEMIPerMonth() { 
		
		WebElement emi=wait.until(ExpectedConditions.visibilityOfElementLocated(emiValuePerMonth));
				return emi.getText();
	}
	
	
	//Scroll down to year table
	 public String getPrincipalAmountPerMonth() {
		 WebElement Year26P=wait.until(ExpectedConditions.visibilityOfElementLocated(year));
		 Year26P.click();
		 
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PrincipalAmountPerMonth));

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
			return element.getText();
	    }
	
	//Get InterestAmount
	public String getInterestAmountPerMonth() {
		WebElement Year26Interest=wait.until(ExpectedConditions.visibilityOfElementLocated(year));
		Year26Interest.click();
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(InterestAmountPerMonth));
		return element.getText();
	}
	
}
