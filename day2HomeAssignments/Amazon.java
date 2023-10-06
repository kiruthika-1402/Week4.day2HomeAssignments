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
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();		
		String text = driver.findElement(By.xpath("//span[text()='9,999']")).getText();
		System.out.println("Phone price :"+ text);
		String text2 = driver.findElement(By.xpath("//span[text()='7,515']")).getText();
		System.out.println("Customer's rating :"+ text2);
		driver.findElement(By.xpath("//span[contains(text(),'realme narzo N53')]/parent::a")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
        File src = driver.getScreenshotAs(OutputType.FILE);
       File des = new File("./SnapShots/img.png");
       FileUtils.copyFile(src, des);
       Thread.sleep(3000);
      driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
      String text3 = driver.findElement(By.xpath("//span[text()='₹9,999.00']/parent::div")).getText();
      System.out.println(text3);
      
  //     driver.close();
      
     
       
        
        
        
        
        
        
        
        
        
        
        
        
      
        
	}

}
