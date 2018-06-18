package com.fourstay.tests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

public class LoginTest {
	//open browser
	//go to the page
	//login
	//verify that we are logged in
	WebDriver driver;
	
	@Before
	public void setUp() {
		driver=Driver.getInstance();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}
	
	
	@Test
	public void loginTest() {
		
//this is how we create an object of a page object class
	 //initElements method is from Pagefactory class of the Selenium
		 //initElement initilizes the WebElements and locates them on the page 
	HomePage home=new HomePage();	
	    home.loginLink.click();
		  //driver.findElement(By.cssSelector("[data-target='#modal-login']")).click();
	   
	    home.email.sendKeys(Config.getProperty("guest_username"));
		  //driver.findElement(By.id("email")).sendKeys(Config.getProperty("guest_username"));
		
	    home.password.sendKeys(Config.getProperty("guest_password"));
	      //driver.findElement(By.id("key")).sendKeys(Config.getProperty("guest_password"));
	    
	    //wait here
	    Page.sleep(500);
	    home.loginBtn.click();
		  //driver.findElement(By.id("btn-login")).click();
	    
//create the page Object
	    UserAccountPage userAccount=new UserAccountPage();
	    assertTrue(userAccount.accountHolderName.isDisplayed());
		  //assertTrue(driver.findElement(By.cssSelector("h3.user-name")).isDisplayed());
		  
		String expected="Currently no listings reserved by";
		assertTrue(userAccount.message.getText().contains(expected));
		  //assertTrue(driver.findElement(By.xpath("(//h3)[8]")).getText().contains(expected));
	}


}
