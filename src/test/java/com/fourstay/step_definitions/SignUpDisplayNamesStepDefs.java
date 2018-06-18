package com.fourstay.step_definitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;
import com.fourstay.utilities.StringUtilities;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpDisplayNamesStepDefs {
	
	HomePage homePage=new HomePage();
	
	@Given("^the user is on the FourStay sign up dialog$")
	public void the_user_is_on_the_FourStay_sign_up_dialog() throws Throwable {
	    Driver.getInstance().get(Config.getProperty("url"));
	    homePage.signUpLink.click();
	}

	@Given("^the user enters enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void the_user_enters_enter_first_name_and_last_name(String firstName, String lastName) throws Throwable{
		homePage.firstName.sendKeys(firstName);
		homePage.lastName.sendKeys(lastName);
	}

	@Given("^the user enters any unregistered email and password$")
	public void the_user_enters_any_unregistered_email_and_password() throws Throwable {
		String email=StringUtilities.generateGmailUsername("testemail");
		homePage.emailSignUp.sendKeys(email);
		Page.sleep(2000);
		homePage.passwordSignUp.sendKeys("password");
	}

	@When("^the user click on the Sign up button$")
	public void the_user_click_on_the_Sign_up_button() throws Throwable {
		homePage.signUpBtn.click();
	}

	@Then("^first name \"([^\"]*)\" and last name \"([^\"]*)\" should be displayed on account details page$")
    public void first_name_and_last_name_should_be_displayed_on_account_details_page
                (String firstName, String lastName) throws Throwable {
	    
		 UserAccountPage userAccountPage=new UserAccountPage();
//wait here
		 Page.waitFor(userAccountPage.accountHolderName, 5);
		 String actual=userAccountPage.accountHolderName.getText();
		 String expected=firstName+" "+lastName;
		 assertEquals(expected, actual);
	}
	
	@Given("^the user clicks the guest radiobutton$")
	public void the_user_clicks_the_guest_radiobutton() throws Throwable {
	    homePage.guestSignUp.click();
	}
	
}
