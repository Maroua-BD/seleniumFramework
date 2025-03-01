package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class SerchProductUsingAutoSuggest extends TestBase{
	
	String productName="Apple MacBook Pro 13-inch";

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
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
	

	

}
