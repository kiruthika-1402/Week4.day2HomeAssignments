package week4.day2HomeAssignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Initialize chromedriver
		ChromeDriver driver = new ChromeDriver();
		
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Load the url
		driver.get("https://www.amazon.in/");
		
		// To maximize the screen
		driver.manage().window().maximize();
		
		// Search oneplus 9 pro in the search field
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		
		// Click search icon
		driver.findElement(By.id("nav-search-submit-button")).click();		
		
		// Get the price of the first product an print in the console
		String text = driver.findElement(By.xpath("//span[text()='9,999']")).getText();
		System.out.println("Phone price :"+ text);
		
		//Print the number of customer ratings for the first displayed product.

		String text2 = driver.findElement(By.xpath("//span[text()='7,515']")).getText();
		System.out.println("Customer's rating :"+ text2);
		
		// Click the first text link of the first image
		driver.findElement(By.xpath("//span[contains(text(),'realme narzo N53')]/parent::a")).click();
		
		// To handle windows
		Set<String> windowHandles = driver.getWindowHandles();
		
		// Convert set into list
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
		// step 1- take a snap
        File src = driver.getScreenshotAs(OutputType.FILE);
        
        // step 2-create folder
        File des = new File("./SnapShots/img.png");
       
        // step 3- copy the file
        FileUtils.copyFile(src, des);
        Thread.sleep(3000);
        
        // Click the 'Add to Cart' button
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
      
        //Get the cart subtotal and verify if it is correct
        String text3 = driver.findElement(By.xpath("//span[text()='₹9,999.00']/parent::div")).getText();
        System.out.println(text3);
      
        // To close
        driver.close();
      
     
       
        
        
        
        
        
        
        
        
        
        
        
        
      
        
	}

}
