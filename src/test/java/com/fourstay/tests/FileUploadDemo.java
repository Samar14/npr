package com.fourstay.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.Driver;

public class FileUploadDemo {
	WebDriver driver=Driver.getInstance();
	
	@Test
	public void fileUpload(){
		driver.get("http://the-internet.herokuapp.com/upload");
		
		WebElement uploadInput=driver.findElement(By.id("file-upload"));
	
	//this line gets the path of the project	
        String projectFolder=System.getProperty("user.dir"); 
        
		String textFile="/src/test/resources/com/fourstay/test_data/test.txt";
		uploadInput.sendKeys(projectFolder+textFile);
		
		String jpgFile="/src/test/resources/com/fourstay/test_data/image.jpg";
		uploadInput.sendKeys(projectFolder+jpgFile);
		
		WebElement uploadButton=driver.findElement(By.id("file-submit"));
		uploadButton.click();	
	}

}
