package LocatorSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfirmAlerte {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		driver = new ChromeDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/Alerts.html");
	}
	
	
	@Test(priority = 1)
	public void confirmAlert() throws InterruptedException
	{
		WebElement btnalrt = driver.findElement(By.id("confirm"));
		btnalrt.click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		//on va tester si l'utilisateur a cliqué sur ok ou nn par la comparaison du texte affiché
		WebElement msg =driver.findElement(By.id("demo"));
		Assert.assertEquals("You Accepted Alert!",msg.getText());
		
	}
	
	@Test(priority = 2)
	public void DismissmAlert() throws InterruptedException
	{
		WebElement btnalrt = driver.findElement(By.id("confirm"));
		btnalrt.click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		Thread.sleep(2000);
		//on va tester si l'utilisateur a cliqué sur ok ou nn par la comparaison du texte affiché
		WebElement msg =driver.findElement(By.id("demo"));
		Assert.assertEquals("You Dismissed Alert!",msg.getText());
		
	}
	
	
	
	@AfterTest
	public void closeWindow()
	{
		driver.close();
	}

}
