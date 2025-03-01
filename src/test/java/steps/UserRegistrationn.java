package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

public class UserRegistrationn extends TestBase{

	HomePage homeObject;
	UserRegistration registerObject;


	@Given("the user in the home page")
	public void the_user_in_the_home_page()  {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();

	}
	
	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));


	}
	
	  @When("^I enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
	    public void enterRegistrationDetails(String firstname, String lastname, String email, String password) {
		  registerObject = new UserRegistration(driver);
			registerObject.userRegistration(firstname, lastname, email, password);
		  
	    }
	
	/*
	
	@When("I entered the user data")
	public void i_entered_the_user_data() {
		registerObject = new UserRegistration(driver);
		registerObject.userRegistration("Marwa", "Ben Driss", "marwa@test.com", "1234568");
	} */
	
	
	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registerObject.userLogout();

	}																																																																																																																						

}
