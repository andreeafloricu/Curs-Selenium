package curs2;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeWorkCurs2 {
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.keybooks.ro");
	}
	
	@Test
	public void test() {
		SoftAssert sa = new SoftAssert();
		WebElement loginButton = driver.findElement(By.cssSelector("a.popup_link.popup_login_link.icon-user.inited"));
		assertTrue(loginButton.isDisplayed());
		loginButton.click();
		WebElement email = driver.findElement(By.id("log"));
		WebElement password = driver.findElement(By.id("password"));
		sa.assertTrue(email.isDisplayed());
		sa.assertTrue(password.isDisplayed());
		sa.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}