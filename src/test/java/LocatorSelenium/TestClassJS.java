package LocatorSelenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClassJS {
	
	WebDriver driver;
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("http://www.google.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestJS()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//on veut extraire le titre de la page à l'aide de JS
		String title =(String) js.executeScript("return document.title");
		assertEquals("Google",title);
		System.out.println(title);
		//on va extraire le nbr de links dans notre page
		long links = (long) js.executeScript("var links= document.getElementsByTagName('A'); return links.length");
	System.out.println(links);
	}
	
	
	@AfterClass
	public void closeWindow()
	{
		driver.quit();
	}

}
