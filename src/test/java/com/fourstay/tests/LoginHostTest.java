package com.fourstay.tests;

import static org.junit.Assert.*;

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

public class LoginHostTest {
	WebDriver driver;
	
	
	@Before
	public void setUp(){
		driver=Driver.getInstance();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}
	
	@Test
	public void loginTest(){
		
		HomePage home=new HomePage();	
	    home.loginLink.click();
		  //driver.findElement(By.cssSelector("[data-target='#modal-login']")).click();
	    
	    home.email.sendKeys(Config.getProperty("host_username"));
		  //driver.findElement(By.id("email")).sendKeys(Config.getProperty("host_username"));
	    
	    home.password.sendKeys(Config.getProperty("host_password"));
		  //driver.findElement(By.id("key")).sendKeys(Config.getProperty("host_password"));
	    Page.sleep(500);
	    home.loginBtn.click();
		  //driver.findElement(By.id("btn-login")).click();
		
	    UserAccountPage userAccount=new UserAccountPage();
	    assertTrue(userAccount.accountHolderName.isDisplayed());
		  //assertTrue(driver.findElement(By.cssSelector("h3.user-name")).isDisplayed());
		  
		String expected="Currently no listings by";
		assertTrue(userAccount.message.getText().contains(expected));
		  //assertTrue(driver.findElement(By.xpath("(//h3)[7]")).getText().contains(expected));
	}
}
