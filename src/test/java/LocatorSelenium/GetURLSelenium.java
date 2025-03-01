package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GetURLSelenium {

	public static void main(String[] args)throws InterruptedException  {
		
		//lunch chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://smi-darty-dev.web.app");
		
		
		
		//getURLCurrent
		String URL = driver.getCurrentUrl();
		System.out.println("The current url is : "+URL);
		
		//getIDWindw
		String IdWindiw = driver.getWindowHandle();
		System.out.println("The Id of this window is :"+IdWindiw);
		
		//getIDWindw
		String Title = driver.getTitle();
		System.out.println("The Title of this window is :"+Title);
		
		//getPageSource
		String PageSource=driver.getPageSource();
		System.out.println("The page source is :"+ PageSource);
		
		Thread.sleep(5000);
		//naviguer dans une autre page
		driver.navigate().to("https://smi-darty-dev.web.app/statistiques");
		/*
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();*/
		
		//getElement by id 
		driver.findElement(By.id("tab-0")).getText();
		
		driver.quit(); //ferme toutes les fenêtres ouverte à partir du test 
		driver.close(); //ferme seulement 1 fenêtre
		
	}

}
