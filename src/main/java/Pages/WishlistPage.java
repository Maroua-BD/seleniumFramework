package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dev.failsafe.internal.util.Assert;

public class WishlistPage extends PageBase{

	public WishlistPage(WebDriver driver) {
		super(driver);
	}

     @FindBy(name="addtocart")
     WebElement checkAddToCart;
     
     @FindBy(css="button.remove-btn")
     WebElement removeWishlistCheck;
     
     
     @FindBy(css="td.product")
     public WebElement productCell;
     
     @FindBy(css="h1")
    public WebElement wishlistHeader;
     
     @FindBy(id="updatecart")
     WebElement updateWishlistBtn;
     
     @FindBy(css="div.page.wishlist-page")
     WebElement wishlistRemovePage;
     
     @FindBy(name="addtocartbutton")
     WebElement addToCardWishlist;
     
     @FindBy(css="div.no-data")
     public WebElement emptyWishlistTxt;
     
     
     public void removeProductFromWishlist()
     {
    	 ClickButton(addToCardWishlist);
    	 ClickButton(removeWishlistCheck);
     }

}
