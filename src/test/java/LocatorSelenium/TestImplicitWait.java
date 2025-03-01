package LocatorSelenium;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class TestImplicitWait {

	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/AjaxDemo.html");
	
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void ImplicitWait()
	{
		//set the implicitly wait time to 20s
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Page 4")).click();
		WebElement msg = driver.findElement(By.id("page4"));
		assertTrue(msg.getText().contains("Hello,"));
		
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page4")));*/

		
	}
	
	
	@AfterTest
	public void closeWindow()
	{
		driver.close();
	}
	
}
