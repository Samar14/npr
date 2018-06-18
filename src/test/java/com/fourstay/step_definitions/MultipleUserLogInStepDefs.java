package com.fourstay.step_definitions;


import static org.junit.Assert.assertEquals;

import java.util.List;

import com.fourstay.models.User;
import com.fourstay.pages.GeneralSettingsPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Page;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MultipleUserLogInStepDefs {
	
	HomePage homePage=new HomePage();
	GeneralSettingsPage generalSettings=new GeneralSettingsPage();
	
	@Given("^the user is on the FourStay homepage$")
	public void the_user_is_on_the_FourStay_homepage() throws Throwable {
		homePage.open();
	}

	@Given("^the user sings in using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_sings_in_using_and(String userName, String password) throws Throwable {
		homePage.login(userName, password);
	}

	@Given("^the user goes to the user general setting page$")
	public void the_user_goes_to_the_user_general_setting_page() throws Throwable {
		Page.sleep(5000);
		UserAccountPage userAccountPage=new UserAccountPage();
		//Page.waitForPageLoad();
		userAccountPage.profilePicture.click();
	    userAccountPage.editProfile.click();
	}

	@Then("^the user full name should be \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_full_name_should_be(String firstName, String lastName) throws Throwable {
		Page.sleep(5000);
	    assertEquals(firstName, generalSettings.firstName.getAttribute("value"));
	    assertEquals(lastName, generalSettings.lastName.getAttribute("value"));
	}

	@Then("^the user phone number should be \"([^\"]*)\"$")
	public void the_user_phone_number_should_be(String phoneNumber) throws Throwable {
		Page.waitFor(generalSettings.phoneNumber, 10);
	    assertEquals(phoneNumber, generalSettings.phoneNumber.getAttribute("value"));
	}

	@Then("^the user email should be \"([^\"]*)\"$")
	public void the_user_email_should_be(String email) throws Throwable {
		Page.waitFor(generalSettings.email, 10);
	    assertEquals(email, generalSettings.email.getAttribute("value"));
	}
	
	@When("^the user sings in using \"([^\"]*)\" and \"([^\"]*)\" information$")
	public void the_user_sings_in_using_and_information(String email, String password) throws Throwable {
	    homePage.login(email, password);
	}

	@Then("^general settings page should have the correct personal information$")
	public void general_settings_page_should_have_the_correct_personal_information(List<User> list) throws Throwable {
		Page.sleep(5000);
		UserAccountPage userAccountPage=new UserAccountPage();
		userAccountPage.profilePicture.click();
	    userAccountPage.editProfile.click();
	    
	    Page.sleep(5000);
	    User user=list.get(0);
	    assertEquals(user.getEmail(), generalSettings.email.getAttribute("value"));
	    assertEquals(user.getFirstName(), generalSettings.firstName.getAttribute("value"));
	    assertEquals(user.getLastName(), generalSettings.lastName.getAttribute("value"));
	    assertEquals(user.getPhoneNumber(), generalSettings.phoneNumber.getAttribute("value"));
	    
	    //user.isHost();
    }
}
