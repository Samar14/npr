package com.fourstay.step_definitions;


import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fourstay.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hook {
	
	@Before
	public void setUp(){
		Driver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
//	@After 
//	public void tearDown(){
//		Driver.closeDriver();
//	}
	
//if is any bug found, we have to report it like this.
	//this method takes a screenshot, if the current scenario fails.
	@After 
	public void tearDown(Scenario scenario){
	  if(scenario.isFailed()){
	     final byte[] screenshot=((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
       scenario.embed(screenshot, "image/png");
	   }
		Driver.closeDriver();
	}

}
