import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

	WebDriver driver;
	
	
	@BeforeMethod
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\data\\data1\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		driver.get("https://www.costco.com");
		
		
		
	}
	
	
	@Test
	public void costcoTitleTest() {
		driver.get("https://www.costco.com");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Welcome to Costco Wholesale");
		
	}
	
	@Test
	public void costcoLogoTest() {
		boolean b=driver.findElement(By.xpath("//img[@class='bc-logo logo-us']")).isDisplayed();
		assertTrue(true);
	}
	
	@AfterMethod
	public void aftertest() {
		driver.quit();
	}

	
}
