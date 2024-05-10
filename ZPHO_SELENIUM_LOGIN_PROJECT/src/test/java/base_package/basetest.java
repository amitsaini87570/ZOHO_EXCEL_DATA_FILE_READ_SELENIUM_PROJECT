package base_package;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr1;
	public static FileReader fr2;
	
	
	@BeforeMethod
	public void setup() throws IOException{
			
		if(driver == null) {
			fr1 = new FileReader("C:\\Users\\amits\\eclipse-workspace\\ZPHO_SELENIUM_LOGIN_PROJECT\\src\\test\\resources\\confligs\\config.properties");
			fr2 = new FileReader("C:\\Users\\amits\\eclipse-workspace\\ZPHO_SELENIUM_LOGIN_PROJECT\\src\\test\\resources\\confligs\\locators.properties");
			prop.load(fr1);
			loc.load(fr2);
		}
		 if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("testurl"));
		}
		 driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void teardown() {
	//	driver.close();
		System.out.println("teardoen app close successfull");
	}
		
}
