package LocatorSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAllbrokenLinks {
	
	public WebDriver driver;
	
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://shopmyinfluence-dev.web.app/admin/dashboard");
		
	}
	
	
	@Test
	public void brokenLinks()
	{
		// on va faire une liste qui contient tous les liens de notre site
		
		List<WebElement> link = driver.findElements(By.tagName("a"));
	    System.out.println("total links are "+ link.size());	
	    
	    /*on va parcourir tous les lien de notre page et pour chaque lien on va prendre l'attribut
	    href puis pour chaque link on va faire appel à notre méthode */
	    for (int i =0; i<link.size(); i++)
	    {
	    	WebElement element = link.get(i);
	    	String url = element.getAttribute("href");
	    	verifyLinks(url);
	    	
	    }
	
	}
	
	
	public static void verifyLinks(String urlLink)
	{
		try
		{
		URL link = new URL(urlLink);
		
		//create a connection using url
		
		//ouvrir une connexion à l'aide de l'url entré en paramétre
		HttpURLConnection httpConn =  (HttpURLConnection) link.openConnection();
		//mettre un timeout
		httpConn.setConnectTimeout(5000);
		//faire une connexion
		httpConn.connect();
		
		//use  getResponseCode() to get the reponse code
		if (httpConn.getResponseCode()== 200)
		{
		   System.out.println(urlLink+" -- "+httpConn.getResponseMessage());
		}
		
		if (httpConn.getResponseCode() == 400 )
		{
			System.out.println(urlLink+" -- "+httpConn.getResponseMessage());
		}
		
		
		
		}catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@AfterClass
	public void closeWindow()
	{
		driver.quit();
	}

}
