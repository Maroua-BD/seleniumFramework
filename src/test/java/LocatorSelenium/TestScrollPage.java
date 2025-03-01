package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScrollPage {
	
	WebDriver driver;
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com");
	}

	@Test
	public void scrollPage() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,4300)");
		Thread.sleep(3000);
		
		WebElement logo= driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
		Assert.assertTrue(logo.isDisplayed());
		
	}
	
	@AfterClass
	public void closeWindow()
	{
		driver.quit();
	}
	
}
