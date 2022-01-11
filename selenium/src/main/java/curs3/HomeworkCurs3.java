package curs3;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;

public class HomeworkCurs3 extends BaseTest {
	
	@Test
	public void forest() throws InterruptedException {
		
		List<WebElement> categories = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']"));
		boolean bookExist = false;
		SoftAssert sa = new SoftAssert();

		for (WebElement element : categories) {
			element.click();
			Thread.sleep(1000);
			List<WebElement> books = driver.findElements(By.cssSelector("div[aria-hidden='false'] > div > div > h3"));
			for (WebElement book :  books) {
				if (book.getText().equals("The forest")) {
					bookExist = true;
					break;
				}
			}
			sa.assertTrue(bookExist);
			bookExist = false;
		}
		sa.assertAll();
		
		WebElement theForestBook = driver.findElement(By.cssSelector("div[aria-hidden='false'] > div > div > h3 > a[href='the-forest']"));
		theForestBook.click();
		
		String currentUrl =  driver.getCurrentUrl();
		String expectedUrl = "https://keybooks.ro/shop/the-forest/";
		assertEquals(currentUrl, expectedUrl);
	}
}