package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css="strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement pricevalue;
	
	@FindBy(id="add-to-wishlist-button-4")
	public WebElement addToWishlistBtn;
	
	@FindBy(linkText = "wishlist")
	public WebElement linkViewWishlist;
	
	//si on va pointer sur un bouton avec sa classe on doit mettre input.classe
	@FindBy(css="button.button-2.add-to-compare-list-button")
	public WebElement addtoCompBtn;
	
	
	public void sendEmail()
	{
		ClickButton(emailFriendBtn);
	}
	
	public void addProductToWishlist()
	{
		ClickButton(addToWishlistBtn);
	}
	
	public void productToCampare()
	{
		ClickButton(addtoCompBtn);
	}
}
