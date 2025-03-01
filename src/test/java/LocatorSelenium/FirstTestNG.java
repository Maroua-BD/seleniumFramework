package LocatorSelenium;

import static org.testng.Assert.fail;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

public class FirstTestNG {

	ChromeDriver driver;
	
	@BeforeTest
	public void openUTL()
	{
		
		//System.out.println("I run only one test before ");
		    driver= new ChromeDriver();
		 	driver.navigate().to("https://smi-darty-dev.web.app");
	}
	
	@Test(priority = 0)
	public void userLogin()
	{
		System.out.println(driver.getCurrentUrl());
		//fail ("Throw exception"); on force une exception pour tester la dépendence 
	}
	
	
	@Test(priority = 1,dependsOnMethods= {"userLogin()"})
	public void userPwd()
	{
		System.out.println(driver.getTitle());
	}
	
	@Test(enabled=false)
	public void UserRegsitration()
	{
		System.out.println("hello");
	}
	
	@AfterTest
	public void closeWebsite()
	{
			driver.quit();
	}
}
