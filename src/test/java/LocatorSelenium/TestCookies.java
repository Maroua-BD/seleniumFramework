package LocatorSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCookies {

	ChromeDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://magento-demo.lexiconn.com/");
	}
	
	@Test
	public void testcookies()
	{
	
		//on va pointer sur un dropdown contenant les langues
		WebElement langugelist = driver.findElement(By.id("select-language"));
		Select select =new Select(langugelist);
		Assert.assertEquals("English", select.getFirstSelectedOption().getText());
		
		//store cookies should be none (null) 
		Cookie storeCookie =driver.manage().getCookieNamed("store");
		Assert.assertEquals(null, storeCookie);
		
		//select german language
		select.selectByVisibleText("German");
		
		//tester si le cookie est pleine par les valeur du langue qu'on a choisi
		// store cookie should be populated with selected country German
		
		storeCookie= driver.manage().getCookieNamed("store");
		Assert.assertEquals("german",storeCookie.getValue());
		System.out.println(storeCookie.getValue());
		
		
		// on va lister tous les cookies existante dans notre website
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Nbr de cookies dans notres site est : "+cookies.size());
		
		// on va louper sur la liste des cookies
		Iterator<Cookie> itr = cookies.iterator();
		//itr.hasNext() cad on a tjr des valeur en suivant
		while (itr.hasNext())
		{
			Cookie cookie = itr.next();
		 	System.out.println("le domaine est : "+cookie.getDomain());
		 	System.out.println("le nom du cookie est : "+cookie.getName());
		 	System.out.println("la valeur du cookie est : "+cookie.getValue());
		 	
		}
		
	}
	
	
	@AfterTest()
	public void closewindow()
	{
		//fermer tous les fenêtres
		driver.close();
		
		//fermer la fenêtre actuelle driver.quit();
	}
	
}
