package LocatorSelenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlerteSimpleClass {

	ChromeDriver driver;
	
	
	@BeforeTest
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/Alerts.html");
	}
	
	
	@Test
	public void AlertSimple()
	{
         WebElement btnalerte= driver.findElement(By.id("simple"));
		 btnalerte.click();
		 	
		 	Alert alert = driver.switchTo().alert();
		 	String alertText = alert.getText();
		 	assertEquals("Hello! I am an alerte box!", alertText);
		 	alert.accept();
	}
	
	@AfterTest
	public void closewindow()
	{
		driver.close();
	}
}
