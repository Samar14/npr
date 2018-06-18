package webdriverlisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestListeners {
	
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				           "./src/test/resources/com/fourstay/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		//Create EventFiringWebDriver so that we can hear/listen to each action
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		//create instance of your custom events listener class
		MyWebDriverListener eventListener=new MyWebDriverListener();
		
		eDriver.register(eventListener);
		
		eDriver.get("http://www.google.com");
		eDriver.findElement(By.linkText("Business")).click();
		
		
	}
}
