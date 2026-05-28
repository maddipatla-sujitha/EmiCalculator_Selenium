package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	// Locators
    By homeLoanTab = By.id("home-loan");   
    By carLoanTab = By.id("car-loan");
    By personalLoanTab = By.id("personal-loan");

    By loanAmountField = By.id("loanamount");
    By interestField = By.id("loaninterest");
    By tenureField = By.id("loanterm");

    By pieChart = By.id("emipiechart");
    By barChart = By.id("emibarchart");
	
	//Title of the page
	public String getPageTitle() {
		String title=driver.getTitle();
		return title;
	}
    
    // Actions
    public boolean isHomeLoanTabVisible() {
        return wait.until(ExpectedConditions.elementToBeClickable(homeLoanTab)).isDisplayed();
    }

    public void clickHomeLoan() {
    	wait.until(ExpectedConditions.elementToBeClickable(homeLoanTab)).click();
    }

    public void clickCarLoan() {
    	wait.until(ExpectedConditions.elementToBeClickable(carLoanTab)).click();
    }

    public void clickPersonalLoan() {
    	wait.until(ExpectedConditions.elementToBeClickable(personalLoanTab)).click();
    }

    public boolean isLoanAmountDisplayed() {
        return driver.findElement(loanAmountField).isDisplayed();
    }

    public boolean isChartDisplayed() {
        try {
            WebElement element = driver.findElement(pieChart);

            // Scroll to element
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);

            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isBarChartDisplayed() {
        try {
            WebElement element = driver.findElement(barChart);

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);

            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

}


