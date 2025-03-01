package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends TestBase{
	
	HomePage home;
	ContactUsPage contactPage;
	String email ="test@test.com";
	String fullName= "Test User";
	String enquiry= "Hello Admin, this is for test";
	
	
	@Test
	public void UserCanUSeContactUs()
	{
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage= new ContactUsPage(driver);
		contactPage.contactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPage.successMessage.getText()
				.contains("Your enquiry has been successfully sent to the store owner."));
	}
	
	
}
