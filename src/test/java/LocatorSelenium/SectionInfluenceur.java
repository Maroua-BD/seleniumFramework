package LocatorSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SectionInfluenceur {

	public static String username="mazloutrami@gmail.com";
	public static String pwd="123456789";
	
	static WebDriverWait wait;
	static WebDriver driver;
	
	
	public static void main(String[] args) {
	
		//configuration du pilot chrome
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	//open app
	driver.get("https://smi-darty-dev.web.app");
	driver.manage().window().maximize();
	
	
	//remplir le formulaire de connexion
	driver.findElement(By.name("email")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(pwd);
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")).click();
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	
	String element = driver.findElement(By.cssSelector(".MuiTypography-root MuiTypography-body1 css-9toqf8")).getText();
	
	
	
	/*
	
	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='MuiBox-root css-1neij5f']")));
	
	//pour qu'on puisse détecter l'élement 
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//redirection vers menu 
	WebElement bouton_menu = driver.findElement(By.xpath("//*[@class='MuiBox-root css-1neij5f']"));
	bouton_menu.click();

	//attendre que le liens Influenceurs soit cliquable 
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Influenceurs")));
	
	//cliquer sur le lien influenceur
	
	WebElement bouton_influenceur =driver.findElement(By.linkText("Influenceurs"));
	bouton_influenceur.click();
		
		
		
		
		
*/
	}

}
