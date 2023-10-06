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
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize(); 
		
		WebElement mouseHover = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHover).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Count of the sports shoes :"+ text);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
//		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::div")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		String S = "Price Low To High";
		String text2 = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/div")).getText();
		System.out.println(text2);
		if (S.equals(text2)) {
			System.out.println("Sorted Correctly");
		}  
		else {
            System.out.println("Sorted Incorrect");
		}
		//WebElement element = driver.findElement(By.xpath("//div[contains(@class,'filter-price-slider')]"));
//		WebElement element = driver.findElement(By.xpath("(//a[contains(@class,'price-slider-scroll')])[2]"));
//	    Actions actions1 = new Actions(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='filter-name hashAdded']/preceding-sibling::span)[3]")).click();
		String S1 = " White & Blue";
		String text3 = driver.findElement(By.xpath("//span[@class='filter-color-tile White&Blue ']/following-sibling::a")).getText();
		System.out.println(text3);
		
		if (S1.equals(text3)) {
			System.out.println("Applied filters are verified");
		} 
		else {
			System.out.println("Applied filters are not verified");
		}
		
		WebElement mousehover1 = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(mousehover1).perform();
		
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windows = new ArrayList<String>(windowHandles);
        driver.switchTo().window(windows.get(0));
        
        String title = driver.getTitle();
        System.out.println(title);
        
		String text4 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Cost of the shoe :"+ text4);
		
		String text5 = driver.findElement(By.xpath("//span[text()='25% Off']")).getText();
		System.out.println("Discount percentage :"+ text5);
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./SnapShots/img.jpg");
		
		FileUtils.copyFile(src, dest);
		
		driver.switchTo().window(windows.get(0));
		
		driver.close();
		
		
		
		
		
		
		
		
				
				
				
	}

}
