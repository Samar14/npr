package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class GeneralSettingsPage {
	private WebDriver driver;
	
	public GeneralSettingsPage (){
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[ng-model*='FirstName']")
	 public WebElement firstName;
	 
	@FindBy(css = "[ng-model*='LastName']")
	 public WebElement lastName;
	
	@FindBy(xpath = "(//input[contains(@ng-model, 'email')])[2]")
	 public WebElement email;
	 
	@FindBy(xpath = "(//input[contains(@ng-model, 'phone')])[2]")
	 public WebElement phoneNumber;
}
