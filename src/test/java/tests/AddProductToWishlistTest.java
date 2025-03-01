package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase {
	
	String productName="Apple MacBook Pro 13-inch";

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;
	
	@Test(priority=1)
	public void UserCanSearchWithAutoSuggest()
	{
	try {
		
		searchObject = new SearchPage(driver);
		searchObject.searchProductUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

	} catch (Exception e) {
		System.out.println("Error Occured "+e.getMessage());
	}}
	
	@Test(priority=2)
	public void userCanAddProductToWishlist()
	{
		detailsObject= new ProductDetailsPage(driver);
		detailsObject.addProductToWishlist();
		driver.navigate().to("https://demo.nopcommerce.com"+"/wishlist");
		wishlistObject = new WishlistPage(driver);
		Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
        
	}
 
	@Test(priority=3)
	public void userCanRemoveProductFromWishlist()
	{
		wishlistObject= new WishlistPage(driver);
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.emptyWishlistTxt.getText().contains("The wishlist is empty!"));
	}
	
}
