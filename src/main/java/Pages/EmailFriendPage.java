package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="input.friend-email")
	WebElement emailfriend;
	
	@FindBy(css="input.your-email valid")
	WebElement myemail;
	
	@FindBy(id="PersonalMessage")
	WebElement messagefriend;
	
	@FindBy(css="button.button-1.send-email-a-friend-button")
	WebElement sendbtn;
	
	@FindBy(css="div.result")
	public WebElement resultTxt;
	
	public void sendEmailToFriend(String friendEmail, String personnalMsg)
	{
		setTextElement(emailfriend, friendEmail);
		setTextElement(messagefriend, personnalMsg);
		ClickButton(sendbtn);
	}
	
}
