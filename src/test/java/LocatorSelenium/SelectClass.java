package LocatorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectClass {
	
	ChromeDriver driver;
	

	@BeforeTest
	public void openUrl()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
	}
	
	
	@Test
	public void Selectmethode() throws InterruptedException
	{
		//on va parcourir le dropdown qui est de type webElement
		
       WebElement optionList = driver.findElement(By.id("dropdown"));
       Select selectoptions = new Select(optionList);
       
       //on va vérifier que le dropdown n'est pas de multiple selection 
       Assert.assertFalse(selectoptions.isMultiple());
       
       //on va vérifier que la select posséde 3 options
       Assert.assertEquals(3,selectoptions.getOptions().size());
       
       //on veux selectionner le 1er elem de la liste est d'index 0
       // selectoptions.selectByIndex(0);
       
       //on veux se pointer sur lelem de valeur =1
       selectoptions.selectByValue("1");
       //on va tester est ce que lelem selectionner = option 1 
      Assert.assertEquals("option 1",selectoptions.getFirstSelectedOption().getText());

       
        //on veux selectionner lelem avec le text = "option2"
       //selectoptions.selectByVisibleText("option 2");
       
       
       Thread.sleep(2000);
       
	}

	
	@AfterTest
	public void closewindow()
	{
		driver.quit();
	}
}
