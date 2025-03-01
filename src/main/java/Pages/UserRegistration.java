package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistration extends PageBase{

	public UserRegistration(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy(id = "gender-male")
	WebElement genderRadioBtn;
	
	@FindBy(id = "FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id = "LastName")
	WebElement lnTxtBox;
	
	@FindBy(id = "Email")
	WebElement emTxtBox;
	
	@FindBy(id = "Password")
	WebElement pwdTxtBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confpwdTxtBox;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css="div.result")
	public WebElement sucessMesgRegist;
	
	//on va pointer sur le link Log Out après avoir entrer dans notre compte
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account33")
	public WebElement myAccountLink;
	
	public void userRegistration(String firstName, String lastName, String email, String pwd)
	{
        ClickButton(genderRadioBtn);
		setTextElement(fnTxtBox, firstName);
		setTextElement(lnTxtBox, lastName);
		setTextElement(emTxtBox, email);
		setTextElement(pwdTxtBox, pwd);
		setTextElement(confpwdTxtBox, pwd);
        ClickButton(registerBtn);
	}
	
	//méthode permettant de clicker sur le lien logout
	public void userLogout()
	{
		ClickButton(logoutLink);
	}
	
	public void openMyAccountPage()
	{
		ClickButton(myAccountLink);
	}
	
}
