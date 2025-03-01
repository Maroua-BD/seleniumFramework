package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailFriendPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.UserRegistration;

public class EmailFriendTest extends TestBase{ 
	
	HomePage homeobject;
	UserRegistration registerObject;
	LoginPage loginObject; 
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailFriendPage emailObject;
	
	// 1 user registration
	// 2 search product
	// 3 send email to friend
	// 4 User Logout
	
	
	// 1 user registration
		@Test(priority = 1, alwaysRun = true)
		public void userCanRegisterSuccessfully()
		{
			homeobject = new HomePage(driver);
			homeobject.OpenRegistrationPage();
			
			registerObject = new UserRegistration(driver);
			registerObject.userRegistration("Marwa", "Ben Driss", "tesj89@test.com", "123456");
	        Assert.assertTrue(registerObject.sucessMesgRegist.getText().contains("Your registration completed"));		
		}
		
		
		// 2 search product

		@Test(priority = 2)
		public void UserCanSearchWithAutoSuggest()
		{
		try {
			
			searchObject = new SearchPage(driver);
			searchObject.searchProductUsingAutoSuggest("Mac");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

		} catch (Exception e) {
			System.out.println("Error Occured "+e.getMessage());
		}}
			
		
		
		// 3 send email to friend
		@Test(priority=3)
		public void RegisterUserCanSendProductToFriend()
		{
			detailsObject.sendEmail();
			emailObject = new EmailFriendPage(driver);
			emailObject.sendEmailToFriend("rtrt@test.com", "Hello My friend , check this product");
		   Assert.assertTrue(emailObject.resultTxt.getText()
				   .contains("Your message has been sent." ));
		}
		
		
		// 4 lorsque le user est bien dans son compte il peut cliquer sur logout
		
		@Test(priority=4)
		public void RegisterUserCanLogout()
		{
			registerObject.userLogout();
		}

	
	
	
}
