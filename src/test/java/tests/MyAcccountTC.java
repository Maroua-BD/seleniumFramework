package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistration;

public class MyAcccountTC extends TestBase{
	
	//on va instancier des objets pour les pages home et UserRegister et login pour qu'on puisse travailler avec les méthodes et objets dessous
	HomePage homeobject;
	UserRegistration registerObject;
	MyAccountPage myaccountObject;
	LoginPage loginObject; 

	String oldpwd="123456";
	String newpwd="1234567";
	String firstName ="Marwa";
	String lastName="Ben Driss";
	String email="test02@test.com";
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration(firstName,lastName,email, oldpwd);
        Assert.assertTrue(registerObject.sucessMesgRegist.getText().contains("Your registration completed"));		
	}
	
	@Test(dependsOnMethods = ("RegisterUserCanLogin"))
	public void userCanChangePwd()
	{
		myaccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myaccountObject.openChangePwdPage();
		myaccountObject.changePwd(oldpwd, newpwd);
		Assert.assertTrue(myaccountObject.resultLb.getText().contains("Password was changed"));
		myaccountObject.notifclose.click();
	}
	
	@Test(dependsOnMethods = ("userCanChangePwd"))
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
		loginObject.UserLogin(email, oldpwd);
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed()); on peut ecrire ça ou ça aussi
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		
	}
	
	@Test(dependsOnMethods ="RegisterUserCanLogout" )
	public void RegisterUserCanLoginNewpwd()
	{
		homeobject.OpenLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, newpwd);
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed()); on peut ecrire ça ou ça aussi
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		
	}

}
