package LocatorSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PromptAlerte {

	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
	 driver= new ChromeDriver();
	 driver.navigate().to("https://cookbook.seleniumacademy.com/Alerts.html");
	}
	
	@Test
	public void promtalerte() throws InterruptedException
	{
		//on click sur le bouton pour afficher l'alerte
		WebElement alrt = driver.findElement(By.id("prompt"));
		alrt.click();
		 Thread.sleep(4000);

		//on pointe sur l'alerte
		Alert alert = driver.switchTo().alert();
		
	
		alert.sendKeys("Marwa");

		alert.accept();
		 Thread.sleep(4000);

		WebElement message = driver.findElement(By.id("prompt_demo"));
		
		Assert.assertEquals("Hello Marwa! How are you today?",message.getText());
		 Thread.sleep(4000);
	}
	
	@AfterTest
	public void closewindow()
	{
		driver.close();
	}
	
}
