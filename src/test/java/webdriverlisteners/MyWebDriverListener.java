package webdriverlisteners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyWebDriverListener extends AbstractWebDriverEventListener{
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		if(element.isDisplayed()){
			System.out.println("Element is displayed and ready to be clicked...");
		}
		System.out.println("WebDriver is about to click.....");
	}
	
	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("WebDriver just clicked on element....");
	}
	
	
}
