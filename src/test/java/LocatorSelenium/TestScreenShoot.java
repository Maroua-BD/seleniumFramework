package LocatorSelenium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScreenShoot {
	
	WebDriver driver;
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.fr/");
		
	}
	
	@Test
	public void TestScreenOnFailure() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement inputsearch = driver.findElement(By.id("twotabsearchtextboxbbb"));
		inputsearch.sendKeys("selenium webDriver Book");
		inputsearch.submit();
		assertTrue(driver.getTitle().contains("selenium"));
				
	}
	
	
	//on va prendre une capture si notre méthode TestScreenOnFailure() a retourné une erreur
	@AfterMethod
	public void takescreenShoot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			//create reference of takesscreeshoot
			
			TakesScreenshot ts= (TakesScreenshot) driver;
			File scr = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File ("./ScreeShoots/"+result.getName()+".png"));
			
		}
	}
	
	
	@AfterClass
	public void closeWindow()
	{
		driver.quit();
	}

}
