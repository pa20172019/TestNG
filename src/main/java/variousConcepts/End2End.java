package variousConcepts;

		import java.util.concurrent.TimeUnit;

		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;



		public class End2End {

			public static void main(String[] args) throws InterruptedException {
				  System.setProperty("webdriver.chrome.driver","C:\\Users\\parve\\September2021_Selenium\\FirstSelenium\\driver\\chromedriver.exe");
				   WebDriver driver = new ChromeDriver();
				   driver.get("http://spicejet.com");
				   driver.manage().window().maximize();
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				   
				   driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[1]/div")).click();

				   driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[2]")).click();

				   driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]")).click();

				   Thread.sleep(2000);

				   driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

				   driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

				   if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

				   {

				   System.out.println("its disabled");

				   Assert.assertTrue(true);

				   }

				   else

				   {

				   Assert.assertTrue(false);

				   }

				   driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

				   driver.findElement(By.id("divpaxinfo")).click();

				      Thread.sleep(2000L);

				   for(int i=1;i<5;i++)

				   {

				   driver.findElement(By.id("hrefIncAdt")).click();

				   }

				   driver.findElement(By.id("btnclosepaxoption")).click();

				   Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

				   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

				   // driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

				   driver.findElement(By.cssSelector("input[value='Search']")).click();

				   // driver.findElement(By.xpath("//input[@value='Search']")).click();

				   // driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

				   }

}

		

	


