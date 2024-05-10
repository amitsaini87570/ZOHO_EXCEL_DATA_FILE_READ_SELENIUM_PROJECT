package login_to_zoho;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base_package.basetest;

public class login_to_zoho_page extends basetest {

	@Test(dataProviderClass =readxldata.class,dataProvider="testdata")
	   public static void LoginTest(String username,String password,String mobile) throws InterruptedException {
	      driver.findElement(By.xpath(loc.getProperty("signinlink"))).click();	
		  driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("pwd"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("mob"))).sendKeys(mobile);	
		driver.findElement(By.xpath(loc.getProperty("click_on_term_box"))).click();	
		driver.findElement(By.xpath(loc.getProperty("signup"))).click();	

				}
}
