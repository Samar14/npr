package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class DiceHomePage {
	private WebDriver driver; 

	public DiceHomePage(){ 
	this.driver=Driver.getInstance(); 
	PageFactory.initElements(driver,this); 
	} 

	//3 Elements 
	@FindBy(id="search-field-keyword") 
	public WebElement keyword; 

	@FindBy(id="search-field-location") 
	public WebElement city; 

	@FindBy(xpath="//button[.='Find Tech Jobs']") 
	public WebElement find; 

	public void search(String jobTitle,String location){ 
	keyword.clear(); 
	keyword.sendKeys(jobTitle); 
	city.clear(); 
	city.sendKeys(location); 

	find.submit(); 
	} 
	
	public void search(String location){ 
		keyword.clear(); 
		 
		city.clear(); 
		city.sendKeys(location); 

		find.submit(); 
		} 

	}

