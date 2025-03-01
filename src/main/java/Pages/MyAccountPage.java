package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Change password")
	WebElement changepwdLink;
	
	@FindBy(id="OldPassword")
	WebElement oldPwdTxt;
	
	@FindBy(id="NewPassword")
	WebElement newPwdTxt;

	@FindBy(id="ConfirmNewPassword")
	WebElement confirmNewPwdTxt;
	
	@FindBy(css="button.button-1.change-password-button")
	WebElement changePwdButton;
	
		@FindBy(css="div.bar-notification.success")
	public 	WebElement resultLb;
	
		@FindBy(css="span.close")
		public WebElement notifclose;
	
	public void openChangePwdPage()
	{
		ClickButton(changepwdLink);
	}
	
	public void changePwd(String oldpwd, String newpwd)
	{
		setTextElement(oldPwdTxt, oldpwd);
		setTextElement(newPwdTxt, newpwd);
		setTextElement(confirmNewPwdTxt, newpwd);
		ClickButton(changePwdButton);
	}
	
	
}
