package authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;

public class UserAuthenticationSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"./src/test/resources/com/fourstay/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		String username="aerobatic";
		String password="aerobatic";
		driver.get("https://"+username+":"+password+ "@auth-demo.aerobatic.io/protected-standard/");
		//driver.get("https://aerobatic:aerobatic@auth-demo.aerobatic.io/protected-standard/");

		
	}

}
