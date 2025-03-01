package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CamparePage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class AddProductToCampareTest extends TestBase{
	
	String firstProdcutName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";
	
	//1- Search for product number 1
	//2- Search for product number 2
	//3- Add to Campare
	//4- Clear list
	
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	CamparePage campareObject;
	SearchPage searchObject;
	
	
	@Test(priority=1)
	public void userCanCampareProducts()
	{
		searchObject = new SearchPage(driver);
		campareObject= new CamparePage(driver);
		detailsObject= new ProductDetailsPage(driver);
		
		//1-
		searchObject.searchProductUsingAutoSuggest("MacB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProdcutName));
        detailsObject.productToCampare();
        
        //2-
        searchObject.searchProductUsingAutoSuggest("Asus");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
        detailsObject.productToCampare();
        
        // on va naviger vers la page de compare products
        driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
       // Assert.assertTrue(campareObject.macProduct.isDisplayed());
        //Assert.assertTrue(campareObject.asusProduct.isDisplayed());
        
        campareObject.campareProducts();
		
	}
	
	
	@Test(priority=2)
	public void userCanClearCampareList()
	{
		campareObject.clearCampareList();
	}

}
