package LocatorSelenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	static ChromeDriver driver;
	static WebDriverWait wait; 
		
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		driver= new ChromeDriver();
		WebElement error = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
		
		
		driver.get("http://www.automationpractice.pl/index.php");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]")).click();
		
		//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		wait = new WebDriverWait (driver,Duration.ofSeconds(60));
		
		
		driver.findElement(By.id("email_create")).sendKeys("test@gmail.com");
		
		
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]/ol/li")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]/ol/li")));
		
		String errorMessage = error.getText();
        System.out.println("hello"); 	
		
	}
	
	

}
