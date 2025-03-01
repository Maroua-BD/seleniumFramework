package tests;

import java.io.IOException;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.time.Duration;

//import org.graalvm.compiler.replacements.SnippetTemplate.AbstractTemplates;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"}) //ce parametre dans testNG.xml pour tester le browser
	public void statrDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		   }
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://demo.nopcommerce.com/");
	}


	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
	//après chaque fin de méthode on test sur le retour de l'api
	//take scren shoot when test case failed and add it in the screnshoot folder
//ItestReslut contient le retour de l'api de chaque méthode
	@AfterMethod
     public void sceenShotOnfailur(ITestResult result) throws IOException
     {
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("failed!");
			System.out.println("taking screenShoot");
			Helper.captureScreenshot(driver, result.getName());
		}
		
     }
}
