package LocatorSelenium;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
public class QACart {

	public static void main(String[] args) throws InterruptedException {
		
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://smi-darty-dev.web.app");
    
    //Thread.sleep(30);
    //tester si l'input est existant sur l'interface
    /*boolean  email = driver.findElement(By.name("email")).isDisplayed();
    System.out.println(email);
    /* pour que Email retourne false faut ajouter dans le style de l'input un attribut display :none
      style ={ { display :'none'}}
     	
    */
    
    //tester si l'input est saisissable , si elle est dans le code disabled alors email retourne false 
    boolean  email = driver.findElement(By.name("email")).isEnabled();
    System.out.println(email);
    
    /*tester si le checkbox est selectionné ou nn : on pointe sur le xpath du checkbox 
     * 
     
    boolean check = driver.findElement(By.xpath("//*[@data-testid='complete-task']")).isSelected();
    System.out.println(check);
 		*/
    
    /*prendre la valeur des attributsdu checkbox est selectionné ou nn : on pointe sur le xpath du checkbox 
     * dans getAttribute on peut mettre name: ou classe: 
     
     * 
     
    String checkValue = driver.findElement(By.xpath("//*[@data-testid='complete-task']")).getAttribut(name:"");
    System.out.println(checkValue);
		
		*/
		
	}

}
