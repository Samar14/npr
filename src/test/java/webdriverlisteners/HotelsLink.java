package webdriverlisteners;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelsLink {
	
	public static void main(String [] args){
		System.setProperty("webdriver.chrome.driver", 
		           "./src/test/resources/com/fourstay/drivers/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://phptravels.net/login");
		
		//WebElement userName=driver.findElement(By.name("username"));
		//userName.sendkeys("user@phptravels.com");
		String userName="user@phptravels.com";
		driver.findElement(By.name("username")).sendKeys(userName);

		String password="demouser";
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> hotelNames=driver.findElements(By.tagName("a"));
		 System.out.println(hotelNames.size());
		   for(WebElement links: hotelNames){
			   System.out.println(links.getAttribute("href"));
		   }
	
		
	}

}
