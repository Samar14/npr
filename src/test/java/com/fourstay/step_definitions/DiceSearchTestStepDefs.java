package com.fourstay.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.fourstay.pages.DiceHomePage;
import com.fourstay.pages.DiceSearchResultsPage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DiceSearchTestStepDefs {
	
	private static WebDriver driver=Driver.getInstance();
	
	DiceHomePage diceHomePage=new DiceHomePage();
	DiceSearchResultsPage diceSearchResultsPage=new DiceSearchResultsPage();
	private String cityAndState;
	private String title;
	
	
    @Then("^Jobs listings should be displayed$")
    public void jobs_listings_should_be_displayed(Map<String,Integer> jobSearches) throws Throwable {
    	for(Map.Entry<String, Integer> search: jobSearches.entrySet()){
    		System.out.println(search.getKey() +" in "+ search.getValue());
    	
    	diceHomePage.search(search.getKey(), String.valueOf(search.getValue()));
    	//assert that results are > 0
    	assertTrue(diceSearchResultsPage.getPositionsCount()> 0);
    	
    	driver.navigate().back();
      }
 
    }
	
	@Given("^User is on dice homepage$")
	public void user_is_on_dice_homepage() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(Config.getProperty("diceUrl"));
	    assertEquals("Tech Jobs | US Contract and Permanent IT Jobs | Dice.com",
	    		     driver.getTitle());
	}

	@When("^User enters \"([^\"]*)\" into location field$")
	public void user_enters_into_location_field(String cityAndState) throws Throwable {
	    diceHomePage.city.clear();
		diceHomePage.city.sendKeys(cityAndState);
		this.cityAndState=cityAndState;
	}

	@Then("^User clicks on Find Tech Jobs$")
	public void user_clicks_on_Find_Tech_Jobs() throws Throwable {
	   diceHomePage.find.click();
	}
	
	@When("^User searches for \"([^\"]*)\" in \"([^\"]*)\"$")
	public void user_searches_for_in(String title, String cityAndState) throws Throwable {
		diceHomePage.search(title, cityAndState);
		this.title=title;
		this.cityAndState=cityAndState;
	}

	@Then("^Search results should be displayed$")
	public void search_results_should_be_displayed() throws Throwable {
       
		assertEquals("Search results not displayed", "All Tech jobs in "+cityAndState,
				      diceSearchResultsPage.resultsLabel.getText());
		//Driver.closeDriver();
	}
	
	
	@Then("^Search results should be displayed for the keyword$")
	public void search_results_should_be_displayed_for_the_keyword() throws Throwable {
		
		assertEquals("Search results not displayed", title+" jobs in "+cityAndState,
			      diceSearchResultsPage.resultsLabel.getText());
		Driver.closeDriver();	
	}

}
