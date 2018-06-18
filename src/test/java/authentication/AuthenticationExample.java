package authentication;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationExample {
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", 
				"./src/test/resources/com/fourstay/drivers/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.engprod-charter.net/");
		
	

	}

}
