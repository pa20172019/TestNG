package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentsAlert {
          
	public static void main(String[] args) {
		  String text = "Rahul";
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\parve\\September2021_Selenium\\FirstSelenium\\driver\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		   driver.findElement(By.id("name")).sendKeys(text);
		   driver.findElement(By.id("alertbtn")).click();
		   System.out.println(driver.switchTo().alert().getText());
		   driver.switchTo().alert().accept();
		   driver.findElement(By.id("confirmbtn")).click();
		   System.out.println(driver.switchTo().alert().getText());
		   driver.switchTo().alert().dismiss();


	}

}
