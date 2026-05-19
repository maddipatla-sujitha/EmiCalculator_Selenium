package ObjectImplementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ObjectReaders {
	WebDriver driver;
	FileInputStream fis;
	Properties pro;
	
	public ObjectReaders() throws IOException {
		pro=new Properties();
		String path="C:\\Users\\2488452\\eclipse-workspace\\com.final_project.Interest\\ObjectRepository\\object.properties";
		fis=new FileInputStream(path);
		pro.load(fis);
	}
	
	public String getBaseUrl() {
		return pro.getProperty("BaseUrl");
	}
}
