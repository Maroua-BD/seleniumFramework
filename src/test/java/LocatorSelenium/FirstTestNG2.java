package LocatorSelenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

public class FirstTestNG2 {

	ChromeDriver driver;
	
	@BeforeTest
	public void openUTL()
	{
		
		//System.out.println("I run only one test before ");
		    driver= new ChromeDriver();
		 	driver.navigate().to("https://smi-darty-dev.web.app");
	}
	
	@Test
	public void userLogin()
	{
		System.out.println(driver.getCurrentUrl());
	}
	
	
	@Test
	public void userPwd()
	{
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void closeWebsite()
	{
			driver.quit();
	}
}
