package com.fourstay.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class ActionsDemo {
	WebDriver driver=Driver.getInstance();
	
	//@Test
	public void hoverTest(){
		HomePage homePage=new HomePage();
		homePage.open();
		//driver.manage().window().setSize(new Dimension(1680, 1050));
		homePage.login("sking@testmail.com", "password");
		Page.waitForPageLoad();
	//Actions class provides advanced user interaction
	//such as double click, mouse hover, drag and drop	
	    Actions actions=new Actions(driver);
	//for Actions we need the element first	
	    Page.sleep(5000);
		UserAccountPage accountPage=new UserAccountPage();
		accountPage.message.click();
	//moves the mouse to the middle of the element.
		actions.moveToElement(accountPage.profilePicture).perform();
		accountPage.editProfile.click();
			
//this is the code to use a scrollbar/build(): chaining actions/perform(): executing the  action/actions
 // WebElement scrollBar=null;
  //actions.moveToElement(scrollBar).clickAndHold().moveByOffset(0, 250).build().perform();
			
	}
	
	//@Test
	public void dragAndDropTest(){
//drag and drop operations requires 2 elements 1.where you move around(source), 2.where you drop(target)
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target).perform();  //this both lines do same action
	    //actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
	}	
	
	@Test
	public void scrollToElement(){
		driver.get("http://the-internet.herokuapp.com/");
		Page.sleep(2000);
		WebElement link=driver.findElement(By.linkText("Elemental Selenium"));
		Actions actions=new Actions(driver);
		//actions.moveToElement(link).perform();
//JavascriptExecutor is used to execute javascript commands using selenium	
	   // JavascriptExecutor js=(JavascriptExecutor) driver;
//executeScript takes a string which is a javascript code	    
	   // js.executeScript("arguments[0].scrollIntoView(true);", link);
	    
		Page.scrollToElement(link);
	}
}
