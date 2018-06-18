package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

public class HomePage {
 //this class will hold all the web element and the actions from the home page
	//of the 4stay application
//this initilizes we need for uses Pagefactory initElements method	
	private WebDriver driver;
	
	public HomePage() {
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
// @FindBy annotation from Selenium, it holds the locator for weblement
	//xpath, id, name, linkText, partialLinkText, css, tagName	
	
	@FindBy(css="[data-target='#modal-login']")
	public WebElement loginLink;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="key")
	public WebElement password;
	
	@FindBy(id="btn-login")
	public WebElement loginBtn;
	
	@FindBy(xpath="//form[@id='login-form']//div/span")
	public WebElement incorrectPasswordMessage;
	
	@FindBy(xpath="//i[@class='fa fa-facebook']")
	public WebElement signInFaceebook;
	
	@FindBy(xpath="//i[@class='fa fa-google-plus']")
	public WebElement signInGoogle;
	
	@FindBy(css="[data-target='#modal-signup']")
	public WebElement signUpLink;
	
	@FindBy(id="FirstName")
	public WebElement firstName;
	
	@FindBy(id="LastName")
	public WebElement lastName;
	
	@FindBy(xpath="//form[@id='login-form2']//div/input[@id='email']")
	public WebElement emailSignUp;
	
	@FindBy(xpath="//form[@id='login-form2']//div/input[@id='key']")
	public WebElement passwordSignUp;
	
	@FindBy(id="btn-signup")
	public WebElement signUpBtn;
	
	@FindBy(id ="guest")
	public WebElement guestSignUp;
	
	//search
	//login
	public void login(String userEmail, String userPassword){
	  //click on login
	 loginLink.click();	
	  //type email
	 email.sendKeys(userEmail);
	 Page.sleep(1000);
	  //password
	 password.sendKeys(userPassword);
	 Page.sleep(1000);
	  //click login btn	
	 loginBtn.click();
	
	}
	
	public void open(){
		Driver.getInstance().get(Config.getProperty("url"));
	}
	
}
