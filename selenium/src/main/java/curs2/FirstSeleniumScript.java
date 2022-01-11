package curs2;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumScript {
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.keybooks.ro");
	}
	
	@Test
	public void test1() {
		String webPageTitle = driver.getTitle();
		System.out.println(webPageTitle);
		
		String sloganText = driver.findElement(By.className("logo_slogan")).getText();
		System.out.println(sloganText);
	}
	
	@Test(priority = 1)
	public void linkTextLocatorExample() {
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		booksLink.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
	}
	
	@Test(priority = 2)
	public void partialLinkTextLocatorExample() {
		WebElement cookingBook = driver.findElement(By.partialLinkText("Cooking"));
		cookingBook.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/cooking-with-love/");
	}
	
	@Test(priority = 3)
	public void classNameExample() {
		WebElement productTitle = driver.findElement(By.className("price"));
		productTitle.isDisplayed();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border: 2px solid red')", productTitle);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit(); //inchide toata instanta de briwser; close inchide doar un tab
	}
}