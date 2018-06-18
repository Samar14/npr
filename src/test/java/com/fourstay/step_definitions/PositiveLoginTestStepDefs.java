package com.fourstay.step_definitions;

import static org.junit.Assert.assertTrue;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PositiveLoginTestStepDefs {
	
	@Given("^I am on the FourStay home page$")
	public void i_am_on_the_FourStay_home_page() throws Throwable {
	// here we will do the actual steps using java and selenium
	// Driver.getInstance() returns a driver object
		Driver.getInstance().get(Config.getProperty("url"));
	}

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
		
	    HomePage homePage=new HomePage();
	    String email=Config.getProperty("host_username");
	    String password=Config.getProperty("host_password");
	    homePage.login(email, password);
	}

	@Then("^I should be able to verify I am logged in$")
	public void i_should_be_able_to_verify_I_am_logged_in() throws Throwable {
	    Page.sleep(5000);
		UserAccountPage userAccountPage=new UserAccountPage();
		assertTrue(userAccountPage.accountHolderName.isDisplayed());
		//Driver.closeDriver();
	}
	
	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
		
	    HomePage homePage=new HomePage();
	    String email=Config.getProperty("guest_username");
	    String password=Config.getProperty("guest_password");
	    homePage.login(email, password);
	}
	

}
