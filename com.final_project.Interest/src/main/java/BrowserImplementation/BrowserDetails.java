package BrowserImplementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDetails {
	WebDriver driver;
	public BrowserDetails(WebDriver driver) {
		this.driver=driver;
	}
	public WebDriver select_Browser(int choice) {
		switch(choice) {
		case 1:
			driver=new ChromeDriver();
			break;
		case 2:
			driver=new EdgeDriver();
			break;
		case 3:
			driver=new FirefoxDriver();
			break;
		default:
			driver=null;
			break;
		}
		System.out.println("Browser Opened");
		return driver;
	}
}
