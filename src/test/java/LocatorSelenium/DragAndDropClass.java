package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropClass {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/DragDropDemo.html");
	}
	
	@Test
	public void DragAndDrop() throws InterruptedException
	{
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
	    Assert.assertEquals("Dropped!", target.getText());
	    Thread.sleep(3000);
	}

	@AfterTest
	public void closeWindow()
	{
		driver.close();
	}
}
