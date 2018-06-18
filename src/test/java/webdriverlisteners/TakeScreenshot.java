package webdriverlisteners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", 
		                   "./src/test/resources/com/fourstay/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.etsy.com");
//here we're casting the driver. In order to use TakesScreenshot interfaces method, we have to cast driver.
        TakesScreenshot screenShot=(TakesScreenshot)driver;
        //here we useing getScreenshotAs method
        File picture=screenShot.getScreenshotAs(OutputType.FILE); //image file
        FileUtils.copyFile(picture, new File("/Users/sunatulloabdullaev/Desktop/etsy.png"));
        
	}

}
