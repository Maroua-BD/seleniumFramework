package LocatorSelenium;

import java.io.IOException;
import java.util.List;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpResponse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAllBrokenImg {
	
	public WebDriver driver;
	private int  invalideImgCount;
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
	}
	
	@Test
	public void TestBrokenImg()
	{
		invalideImgCount=0;
		List<WebElement> imgList =driver.findElements(By.tagName("img"));
		for (WebElement imgElement: imgList)
		{
			if(imgElement!= null)
			{
				VerifyImageActive(imgElement);
			}
			
		}
		
		System.out.println("Total img broken : "+invalideImgCount);
		
	}
	
	public void VerifyImageActive(WebElement imgElemnt)
	{
		HttpClient client= HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(imgElemnt.getAttribute("src"));
		try {
			@SuppressWarnings("deprecation")
			HttpResponse response= (HttpResponse) client.execute(request);
			/*if(response.getStatusLine().getStatusCode() != 200)
			{
				invalideImgCount++;
				
			}*/
			
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public void CloseWindow()
	{
		driver.quit();
	}

}
