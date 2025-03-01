package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestIframes {
	
	public WebDriver driver;
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/Frames.html");
	    driver.manage().window().maximize();
	}
	
	@Test
	public void TestIframeWithIdOrName()
	{
		driver.switchTo().frame("left");
		WebElement msg = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Left Frame",msg.getText());
	    System.out.println(msg.getText());
		
	    //retourner sur la page principale et sortir du frame left
		driver.switchTo().defaultContent();
		
		//on va switcher vers l'autre frame à droite
		driver.switchTo().frame("right");
		WebElement msg2 = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Right Frame",msg2.getText());
		System.out.println(msg2.getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		WebElement msg3= driver.findElement(By.tagName("p"));
		Assert.assertEquals("This Frame doesn't have id or name",msg3.getText());
		System.out.println(msg3.getText());
		
		driver.switchTo().defaultContent();
	}
	
	@AfterClass
	public void closeWindow()
	{
		driver.quit();//fermer tous les fenêtres
	}

}
