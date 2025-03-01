package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUploadFile {
	
	
	public WebDriver driver;
	
	
	@BeforeClass
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		
	}
	
	@Test
	public void UploadFile() throws InterruptedException
	{
		String imgName= "super.jpg";
		String imgPath=System.getProperty("user.dir")+"/uploads/"+imgName;
		
		
		WebElement fileUpload = driver.findElement(By.id("file-upload"));
		fileUpload.click();
		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
		fileSubmit.click();
		
		WebElement uploadfiles = driver.findElement(By.id("uploaded-files"));
		System.out.println(uploadfiles.getText());
		Thread.sleep(3000);
		Assert.assertEquals(imgName,uploadfiles.getText());
	}
	
	
	@AfterClass
	public void closeWindow()
	{
		driver.quit();
	}
	

}
