import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestAuto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 
		
		// manuel appel à chrome driver
		//System.setProperty("webdriver.chrome.driver", "/home/shopmyinfluence/Bureau/testing/chromedriver_linux64");
		
		//Appel au dependencie du fichier pom.xml
		
		//1. launch chrome
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		//2.open Url
				driver.get("https://test.shopmyinfluence.fr/login");
				driver.manage().window().maximize(); // pour ouvrir l'interface en taille grand 
				Thread.sleep(5000);
		
		//3.provide username Admin
		
				/*WebElement txtUsername= driver.findElement(By.name("email"));  //find element de type webElement 
				txtUsername.sendKeys("Admin");  //take the key
				*/
				
				// autre méthode
				driver.findElement(By.name("email")).sendKeys("mohamed@shopmyinfluence.com");
	  
		//4. provide pwd	
				driver.findElement(By.name("password")).sendKeys("Tellmedia44Admin");
       
	   //5. click on login botton : clic droite sur le bouton et copie XPath
				driver.findElement(By.xpath("//*[@id=\"mui-1\"]")).click();
				
	  //6. verify title dashborad page
				String act_title= driver.getTitle();
				String exp_title ="Shopmyinfluence";
				
				if (act_title.equals(exp_title))
				{
					System.out.println("Test is passed");
				}
				else System.out.println("Test is failed");
				
	//7. close broser 
				//driver.close();
				//driver.quit();
	
	
	
	
	}

}
