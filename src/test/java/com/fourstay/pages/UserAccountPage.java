package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class UserAccountPage {
	private WebDriver driver;
	
	public UserAccountPage() {
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h3.user-name")
	public WebElement accountHolderName;
	
	@FindBy(xpath="//section/div/div/h3[@class='row zrl-margin headings-with-icon ng-binding']")
	public WebElement message;

	//xpath="//*[@id='main_nav']/ul/li[5]/a/img"
	@FindBy(css="[ng-if='userImage']")
	public WebElement profilePicture;
	
	//xpath="//*[@id='main_nav']/ul/li[5]/ul/li[1]/a"
	@FindBy(linkText="Edit Profile")
	public WebElement editProfile;

}

