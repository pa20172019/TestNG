package variousConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRMTest {

	WebDriver driver;
	String browser;
	String url;
	
	// storing webElement using By Class
			By USERNAME_FIELD= By.xpath("//input[@id=\"username\"]");
			By PASSWORD_FIELD = By.xpath("//input[@id=\"password\"]");
			By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
			By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
			By CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
			By ADD_CUSTOMER_MENU_FIELD = By.xpath("//a[contains(text(), 'Add Customer')]");
			By ADD_CUSTOMER_HEADER_FIELD = By.xpath("//h5[contains(text(), 'Add Contact')]");
			
			By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
			By COMPANY_NAME_FIELD = By.xpath("//select[@id=\"cid\"]");
			By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
			By COUNTRY_NAME_FIELD =By.xpath("//*[@id=\"country\"]");
			
			//Login Data
			String username = "demo@techfios.com";
			String password = "abc123";
			
			//Test or Mock data
			String fullname = "September batch";
			String company = "Techfios";
			String email = "abc432@techfios.com";
			String country = "albania";
			
			

			/*
			 * driver.findElement(userNameLocator).clear();
			 * driver.findElement(userNameLocator).sendKeys("demo@techfios.com");
			 * driver.findElement(passWordLocator).sendKeys("abc123");
			 * driver.findElement(signInButtonLocator).click();
			 */

	@BeforeTest
	public void readConfig() {
		// Scanner //BufferedReader //InputStream // FileReader
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser used : " + browser);
			url = prop.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@BeforeMethod
	public void init() {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test (priority = 1)
	public void loginTest() {

		/*
		 * // storing webElement using By Class By userNameLocator =
		 * By.xpath("//input[@id=\"username\"]"); By passWordLocator =
		 * By.xpath("//input[@id=\"password\"]"); By signInButtonLocator =
		 * By.xpath("/html/body/div/div/div/form/div[3]/button"); By
		 * dashBoardHeaderLocator = By.xpath("//h2[contains(text,'Dashboard'])");
		 * 
		 * driver.findElement(userNameLocator).clear();
		 * driver.findElement(userNameLocator).sendKeys("demo@techfios.com");
		 * driver.findElement(passWordLocator).sendKeys("abc123");
		 * driver.findElement(signInButtonLocator).click();
		 */
		driver.findElement(USERNAME_FIELD).sendKeys(username);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		

		String dashBoardHeader = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		Assert.assertEquals(dashBoardHeader, "Dashboard", "Dashboard page not found!!!");
	}
	
	@Test (priority = 2)
	public void addcontact() {
		driver.findElement(USERNAME_FIELD).sendKeys(username);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		String dashBoardHeader = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		Assert.assertEquals(dashBoardHeader, "Dashboard", "Dashboard page not found!!!");
		
		 
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		
		
		waitForElement(driver, 5, ADD_CUSTOMER_MENU_FIELD);
		 
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		
		
		waitForElement(driver, 7, ADD_CUSTOMER_HEADER_FIELD);
		
		
		String addCustomerHeader = driver.findElement(ADD_CUSTOMER_HEADER_FIELD).getText();
		Assert.assertEquals(addCustomerHeader, "Add Contact", "Add contact page not found!!");
				
		
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(9999);
		driver.findElement(FULL_NAME_FIELD).sendKeys(fullname + generatedNum);
		
	}

	private void waitForElement(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
		
	}

	 
	
	
	  @AfterMethod public void tearDown() { 
		  driver.close(); 
		  driver.quit(); 
  }
	 
}
