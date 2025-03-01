package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
		jse =(JavascriptExecutor) driver;
	}
	
	//on va pointer sur le lien Register
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	//on va pointer sur le lien login
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	//On va pointer sur le menu Computer
	@FindBy(linkText="Computers")
	WebElement computerMenu;
	
	@FindBy(linkText= "notebooks")
	WebElement NotebooksMenu;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUs;
	
	@FindBy(id="customerCurrency")
	WebElement currency;
	
	
	// on va créer une méthode qui va cliquer sur le lien Register
	public void OpenRegistrationPage()
	{
       ClickButton(registerLink);
	}
	
	// on va créer une méthode qui va cliquer sur le lien Login
	public void OpenLoginPage()
	{
		ClickButton(loginLink);
	}

	//méthode pour cliquer sur le menu
	public void selectNotebooksMenu()
	{
		System.out.println("ok");

		action.moveToElement(computerMenu).
		moveToElement(NotebooksMenu).click().build().perform();

	}
	
	public void openContactUsPage()
	{
	  //on fait apel à la fct scroll implémenter dans la PageBase
		scrollToBottom();
        contactUs.click();				
	}
	
	public void changeCurrency()
	{
		select = new Select(currency);
		select.selectByVisibleText("Euro"); // on va selectionner le signe euro
	}
}
