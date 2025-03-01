package LocatorSelenium;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Selector {


		public static String username = "mazloutrami@gmail.com";

		public static String pwd = "123456789";

		// Déclaration des objets WebDriver et WebDriverWait

		static WebDriverWait wait;

		static WebDriver driver;


		public static void main(String[] args) {


		// Configuration du pilote Chrome via WebDriverManager

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		By email = By.name("email");
		
		
		// open application

		driver.get("https://smi-darty-dev.web.app");

		// maximase la fenetre du navigateur

		driver.manage().window().maximize();

		// Attendre que l'élément avec le nom "email" soit visible

		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.visibilityOfElementLocated(email));


		// Remplir le formulaire de connexion


		driver.findElement(By.name("email")).sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(pwd);

		driver.findElement(By.id("mui-1")).click();


		// Attendre que le bouton du menu soit cliquable

		//wait.until(ExpectedConditions.visibilit(By.xpath("//*[@class='MuiBox-rootcss-1neij5f']")));
try {
	Thread.sleep(6000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		// redirection vers la section menu

		WebElement boutton_menu =
		driver.findElement(By.xpath("//*[@class='MuiBox-root css-1neij5f']"));

		boutton_menu.click();


		// Attendre que le lien "Influenceurs" soit cliquable

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Influenceurs")));


		// Cliquer sur le lien "Influenceurs"

		WebElement boutton_Influenceurs =
		driver.findElement(By.linkText("Influenceurs"));

		boutton_Influenceurs.click();


		// héthi zayéda twali mta3 wléd s8ar :P

		// driver.navigate().to("https://smi-darty-dev.web.app/influencers");


		// Attendre que le bouton "Mes Influenceurs" soit présent

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab-0")));


		// Cliquer sur le bouton Mes influenceurs

		WebElement bouton_mes_Influenceurs = driver.findElement(By.id("tab-0"));

		// Récupèrer le nom du bouton Mes influenceurs

		String tabnametext0 = bouton_mes_Influenceurs.getText();

		// Cliquer sur le nom du bouton Mes influenceurs

		bouton_mes_Influenceurs.click();

		// Afficher dans la console le texte recupèré

		System.out.println(tabnametext0 + "Asma");


		// Influenceurs à valider


		WebElement bouton_Influenceurs_a_valider = driver.findElement(By.id("tab-1"));


		String tabnametext1 = bouton_Influenceurs_a_valider.getText();


		bouton_Influenceurs_a_valider.click();


		System.out.println(tabnametext1 + "MArwa1");


		// Influenceurs refusés


		WebElement bouton_Influenceurs_refusés = driver.findElement(By.id("tab-2"));


		String tabnametext2 = bouton_Influenceurs_refusés.getText();


		bouton_Influenceurs_refusés.click();


		System.out.println(tabnametext2 + " Marwa");


		// driver.close();


		}

}
