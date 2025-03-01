package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistration;

public class UserRegistrationTC extends TestBase{
	
	//on va instancier des objets pour les pages home et UserRegister et login pour qu'on puisse travailler avec les méthodes et objets dessous
	HomePage homeobject;
	UserRegistration registerObject;
	LoginPage loginObject; 
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration("Marwa", "Ben Driss", "test5@test.com", "123456");
        Assert.assertTrue(registerObject.sucessMesgRegist.getText().contains("Your registration completed"));		
	}
	
	//lorsque le user est bien dans son compte il peut cliquer sur logout
	
	@Test(dependsOnMethods = ("RegisterUserCanLogin"))
	public void RegisterUserCanLogout()
	{
		registerObject.userLogout();
	}
	
	//implementation de user Login (after registration)
	@Test(dependsOnMethods ="userCanRegisterSuccessfully" )
	public void RegisterUserCanLogin()
	{
		homeobject.OpenLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin("test5@test.com", "123456");
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed()); on peut ecrire ça ou ça aussi
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		
	}
	

}
