package LocatorSelenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMultipleWindow {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		driver = new ChromeDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/Config.html");
	}

	@Test
	public void multiplewind()
	{
		//store window handle actuel
		String currentWindowID = driver.getWindowHandle();
		
		driver.findElement(By.id("visitbutton")).click();

		//on va parcourir toutes les fenêtres ouverte
		
		for(String windowID: driver.getWindowHandles())
		{
			String title = driver.switchTo().window(windowID).getTitle();
			if (title.equals("Visit Us"))
			{
				assertEquals("Visit Us",driver.getTitle());
			}
		}		
	

	}
	
	@AfterTest
	public void closewind()
	{
		driver.close();
			
	}
}
