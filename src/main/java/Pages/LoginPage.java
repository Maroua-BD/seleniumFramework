package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//on va pointer sur les input du formulaire
	@FindBy(id="Email")
	WebElement emailTxtBox;
	@FindBy(id="Password")
	WebElement pwdTxtBox;
	@FindBy(id="RememberMe")
	WebElement checkRemenber;
	/*login btn n'a pas d'id dans son input , dans ce cas on utilise
	 * FindBy css=nom-de-la-balise.nom-de-la-classe*/
	@FindBy(css="button.button-1.login-button")
	WebElement loginbtn;

public void UserLogin(String email, String pwd)
{
	//on va utiliser les méthodes dans la PageBage sui utilise le set de l'input et le click button
    	setTextElement(emailTxtBox, email);
    	setTextElement(pwdTxtBox, pwd);
    	ClickButton(loginbtn);
}
	
}
