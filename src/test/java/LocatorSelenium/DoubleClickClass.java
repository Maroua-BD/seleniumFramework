package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickClass {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		 driver= new ChromeDriver();
		 driver.navigate().to("https://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	
	@Test
	public void doubleclick() throws InterruptedException
	{
		/*WebElement msg = driver.findElement(By.id("message"));	
		System.out.println(msg.getCssValue("background-color"));
		Actions builder = new Actions(driver);
		
		
		builder.doubleClick(msg).perform();
		
		System.out.println(msg.getCssValue("background-color"));

		Thread.sleep(4000);*/
		
		try {
		    WebElement msg = driver.findElement(By.id("message"));    
		    Actions builder = new Actions(driver);
		    builder.doubleClick(msg).perform();
			System.out.println(msg.getCssValue("background-color"));

		    Thread.sleep(4000);
		} catch (Exception e) {
		    System.out.println("Erreur lors de l'exécution du double-clic : " + e.getMessage());
		}

	}

	@AfterTest
	public void closewindow()
	{
		driver.close();
	}
}
