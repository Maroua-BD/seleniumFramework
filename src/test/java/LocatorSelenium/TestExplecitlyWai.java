package LocatorSelenium;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExplecitlyWai {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
	}

	
	@Test
	public void ExplecitWait()
	{
		WebElement key =driver.findElement(By.id("APjFqb"));
		key.sendKeys("Selenium WebDriver");
		key.submit();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("WebDriver"));
		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
	}
	
	@AfterTest
	public void closeWindow()
	{
		driver.close();
	}
}
