package com.fourstay.step_definitions;

import static org.junit.Assert.assertTrue;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInSocialMedia {
	
	HomePage homepage=new HomePage();
	
	@Given("^User on the FourStay home page$")
	public void user_on_the_FourStay_home_page() throws Throwable {
	    Driver.getInstance().get(Config.getProperty("url"));
	}

	@When("^User clicks on the SIGN IN link$")
	public void user_clicks_on_the_SIGN_IN_link() throws Throwable {
	   
		homepage.loginLink.click();
	}

	@Then("^the Sign in with Facebook option should be available$")
	public void the_Sign_in_with_Facebook_option_should_be_available() throws Throwable {
		
		assertTrue(homepage.signInFaceebook.isDisplayed());
	}
	
	@Then("^the Sign in with Google option should be available$")
	public void the_Sign_in_with_Google_option_should_be_available() throws Throwable {
		
		assertTrue(homepage.signInGoogle.isDisplayed());
	}
	
}
