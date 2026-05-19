package TestCases;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import BrowserImplementation.BrowserDetails;
import ObjectImplementation.ObjectReaders;

public class TestLandingPage {
	WebDriver driver;
	BrowserDetails bd;
	ObjectReaders or;
	Scanner obj=new Scanner(System.in);
	
	//Launch Browser and Navigate to EmiCalculator WebPage
	@BeforeTest
	public void Launch_Browser_Test() throws InterruptedException, IOException {
		System.out.println("Select the Broser: \n 1.Chrome \n 2.Edge \n 3.Firefox");
		int choice=obj.nextInt();
		bd= new BrowserDetails(driver);
		driver=bd.select_Browser(choice);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		or= new ObjectReaders();
		driver.get(or.getBaseUrl());
		Thread.sleep(3000);
	}
	
	//Quit Browser
	@AfterTest
	public void QuitBrowser() {
		driver.quit();
	}
}
