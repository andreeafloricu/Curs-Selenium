package curs2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementExample {
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keytrainingtravelshop.herokuapp.com/login");
	}
	
	@Test
	public void test1() throws InterruptedException {
		WebElement inputEmail = driver.findElement(By.id("email"));
		inputEmail.isEnabled();
		inputEmail.click();
		inputEmail.sendKeys("TestUser");
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
