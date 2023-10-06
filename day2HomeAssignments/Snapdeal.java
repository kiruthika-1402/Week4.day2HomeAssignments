package week4.day2HomeAssignments;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Load the url
		driver.get("https://www.snapdeal.com/");
		
		// To maximize the screen
		driver.manage().window().maximize(); 
		
		// Mousehover the men's fashion
		WebElement mouseHover = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		
		// Create obj for actions class
		Actions actions = new Actions(driver);
		
		// to perform
		actions.moveToElement(mouseHover).perform();
		
		// Click sports shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		// Get the count of sports shoes
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Count of the sports shoes :"+ text);
		
		//Click on "Training Shoes"
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
//		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		
		// Sort the products by "Low to High".
		driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::div")).click();
		
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		
		// To Check if the displayed items are sorted correctly.
		String S = "Price Low To High";
		String text2 = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/div")).getText();
		System.out.println(text2);
		if (S.equals(text2)) {
			System.out.println("Sorted Correctly");
		}  
		else {
            System.out.println("Sorted Incorrect");
		}
		
		Thread.sleep(3000);
		//Filter by any colour
		driver.findElement(By.xpath("(//a[@class='filter-name hashAdded']/preceding-sibling::span)[3]")).click();
		
		// To verify all the applied filters
		String S1 = " White & Blue";
		String text3 = driver.findElement(By.xpath("//span[@class='filter-color-tile White&Blue ']/following-sibling::a")).getText();
		System.out.println(text3);
		
		if (S1.equals(text3)) {
			System.out.println("Applied filters are verified");
		} 
		else {
			System.out.println("Applied filters are not verified");
		}
		
		//Mouse hover on the first resulting "Training Shoes".
		WebElement mousehover1 = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		
		// Create obj for actions class
		Actions actions1 = new Actions(driver);
		
		// To perform
		actions1.moveToElement(mousehover1).perform();
		
		// Click the "Quick View" button.
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']")).click();
      
//        String title = driver.getTitle();
//        System.out.println(title);
        
		// Print the cost of the shoe
		String text4 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Cost of the shoe :"+ text4);
		
		// Print the discount percentage
		String text5 = driver.findElement(By.xpath("//span[text()='25% Off']")).getText();
		System.out.println("Discount percentage :"+ text5);
		
		// step 1- take a snap
		File src = driver.getScreenshotAs(OutputType.FILE);
		
		//step 2-create folder
		File dest = new File("./SnapShots/img.jpg");
		
		//step 3- copy the file
		FileUtils.copyFile(src, dest);
		
		// To close
		driver.close();
		
		
		
		
		
		
		
		
				
				
				
	}

}
