package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalLoanPage {
    WebDriver driver;
    WebDriverWait wait;

    public PersonalLoanPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators

    By pLoanTab = By.linkText("Personal Loan");
    By pLoanAmount = By.id("loanamount");
    By pInterestRate = By.id("loaninterest");
    By pLoanTenure = By.id("loanterm");
    By yearClick = By.id("year2026");
    By principleAmount = By.xpath("//*[@id=\'monthyear2026\']/td/div/table/tbody/tr[1]/td[2]");
    By pInterestAmount = By.xpath("//*[@id=\'monthyear2026\']/td/div/table/tbody/tr[1]/td[3]");
    By pLoanEmi =  By.xpath("//*[@id=\'emiamount\']/p/span");




    public void clickPLoanTab(){
        wait.until(ExpectedConditions.elementToBeClickable(pLoanTab)).click();
    }

    public void enter_Loan_Amount(){
        WebElement loanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pLoanAmount));
        loanElement.clear();
        loanElement.sendKeys("1500000");


    }

    public void enter_Interest_rate(){
        WebElement interElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pInterestRate));
        interElement.clear();
        interElement.sendKeys(".5");

    }

    public void enter_Loan_tenure(){
        WebElement tElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pLoanTenure));
        tElement.clear();
        tElement.sendKeys("");


    }
    public void clickYear(){
        WebElement year = driver.findElement(yearClick);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",year);
        year.click();
    }

    public String returnPrincipal(){
        WebElement principal = driver.findElement(principleAmount);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",principal)
        return principal.getText();
    }
    public String returnInterestAmount() {
        WebElement interest = driver.findElement(pInterestAmount);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",interest);
        return interest.getText();

    }
        public String returnEMI(){
        WebElement emi = driver.findElement(pLoanEmi);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);",emi);
        return emi.getText();
    }


}