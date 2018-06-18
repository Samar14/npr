package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class DiceSearchResultsPage {
	
	    public DiceSearchResultsPage(){ 
		PageFactory.initElements(Driver.getInstance(), this);
		} 

		@FindBy(xpath = "//*[@class='pull-left h1 jobs-page-header-h1']") 
		public WebElement resultsLabel; 
		
//		@FindBy(xpath = "//*[@class='h1 jobs-page-header-h1']")
//		public WebElement resultLabelWithEmptyTitle;

		@FindBy(id = "posiCountId") 
		public WebElement positionsCount; 

		@FindBy(xpath = "//a[starts-with(@id,'position')]") 
		public List<WebElement> positionTitles; 
		
		public int getPositionsCount(){
			String countText=positionsCount.getText();
			return Integer.valueOf(countText);
//			  if(!countText.contains("positions")){
//				  System.out.println(0);
//				  return 0;
//			  }
//			
//			String[] tempArr=countText.split(" ");
//			String actualCount=tempArr[tempArr.length-2];
//			System.out.println(actualCount);
		}

		public boolean verifyResultsLabel(String jobTitle, String location) { 

		String resultsText = resultsLabel.getText(); 
		// check if text starts with Jobtitle AND ends with Location 
		if (resultsText.startsWith(jobTitle) && resultsText.endsWith(location)) 
		return true; 
		else 
		return false; 
		} 

}
