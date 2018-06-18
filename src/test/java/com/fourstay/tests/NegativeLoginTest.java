package com.fourstay.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

public class NegativeLoginTest {
	WebDriver driver;
	
	@Before
	public void setUp(){
		driver=Driver.getInstance();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}
	
	@Test
	public void invalidPasswordTest(){
		HomePage home=new HomePage();
		home.loginLink.click();
		home.email.sendKeys(Config.getProperty("guest_username"));
		home.password.sendKeys("12345");
		home.loginBtn.click();
		Page.sleep(500);
		assertTrue(home.loginBtn.isDisplayed());
		  System.out.println(home.incorrectPasswordMessage.getText());
		assertTrue(home.incorrectPasswordMessage.isDisplayed());
	}
	
	@Test
	public void invalidUserNameTest(){
		HomePage home=new HomePage();
		home.login("wrong@email.com", Config.getProperty("host_password"));
		assertTrue(home.loginBtn.isDisplayed());
	}

}
