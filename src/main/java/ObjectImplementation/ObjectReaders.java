package ObjectImplementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ObjectReaders {
	WebDriver driver;
	FileInputStream fis;
	Properties pro;
	
	//Reading Object Properties File
	public ObjectReaders() throws IOException {
		pro=new Properties();
		String path="ObjectRepository/object.properties";
		fis=new FileInputStream(path);
		pro.load(fis);
	}
	
	//Getting Browser Url 
	public String getBaseUrl() {
		return pro.getProperty("BaseUrl");
	}
}
