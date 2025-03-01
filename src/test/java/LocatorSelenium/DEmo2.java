package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DEmo2 {

	ChromeDriver driver;
	
	@BeforeClass
	public void openURL()
	{
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	public void loginScean()
	{
		WebElement txtusername = driver.findElement(By.id("username"));
		WebElement txtpwd= driver.findElement(By.id("password"));
		WebElement btn = driver.findElement(By.className("radius"));
		
		txtusername.clear();
		txtusername.sendKeys("tomsmith");
		
		txtpwd.clear();
		txtpwd.sendKeys("SuperSecretPassword!");
		
		btn.click();
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
	
}
