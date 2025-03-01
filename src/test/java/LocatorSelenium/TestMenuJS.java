package LocatorSelenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMenuJS {
	
	WebDriver driver;
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
	}
	
	@Test
	public void TestMenu() throws InterruptedException
	{
		//By.cssSelector(nombalise.nomclasse)
		WebElement btnMenu= 
				driver.findElement
				(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		//prendre le bouton edit du menu
		WebElement menu= 
				driver.findElement
				(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));
	
		//pour faire des actions sur les webElement bouton et menu on a besoin d Actions
	Actions builder= new Actions (driver);
	
	//on va lui dire après avoir cliquer sur le bouton pointer sur le menu
	builder.contextClick(btnMenu).moveToElement(menu).click().perform();
	
	Thread.sleep(3000);
	//on va attendre jusqu'à l'alerte s'affiche 
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	Alert alert= wait.until(ExpectedConditions.alertIsPresent());
	
	assertEquals("clicked: edit",alert.getText());
	alert.dismiss();
	}
	
	@AfterClass
	public void closeWindow()
	{
		driver.quit();
	}

}
