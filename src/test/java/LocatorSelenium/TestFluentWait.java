package LocatorSelenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFluentWait {
	
	ChromeDriver driver;
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/AjaxDemo.html");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void testFluentWait()
	{
		driver.findElement(By.linkText("Page 4")).click();
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement message= fwait.until(new Function<WebDriver, WebElement>()
				{

					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(By.id("page4"));
					} // on va attendre jusqu'à trouver un elem avec id =page4
			
			
				});
		assertTrue(message.getText().contains("Hello,"));
				
		
	}
	
	@AfterClass
	public void closeWindow()
	{
		driver.close();
	}

}
