package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkboxclass {

	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
		
	}
	
	@Test
	public void checkbox() throws InterruptedException
	{
		WebElement check1= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		check1.click();
		Thread.sleep(2000);
		
		WebElement check2= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		check2.click();
		
		if(check2.isSelected())
		{
			check2.click();
		}
		
	}
	
	
	@AfterTest
	public void closenavigater()
	{
		driver.quit();
	}
}
