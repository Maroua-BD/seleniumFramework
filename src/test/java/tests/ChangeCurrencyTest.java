package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homeObject;
	ProductDetailsPage productObject;
	String productName="Apple MacBook Pro 13-inch";

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
      @Test(priority =1)
      public void UserCanChangeCurrency()
      {
    	  homeObject = new HomePage(driver);
    	  homeObject.changeCurrency();
    	  
      }
      
      @Test(priority=2)
  	public void UserCanSearchWithAutoSuggest()
  	{
  	try {
  		
  		searchObject = new SearchPage(driver);
  		searchObject.searchProductUsingAutoSuggest("MacB");
  		detailsObject = new ProductDetailsPage(driver);
  		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
  		Assert.assertTrue(detailsObject.pricevalue.getText().contains("€"));
  		System.out.println(detailsObject.pricevalue.getText());

  	} catch (Exception e) {
  		System.out.println("Error Occured "+e.getMessage());
  	}
	
	
}}
