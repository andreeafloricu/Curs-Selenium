package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.DataProviderClass;

public class DataProviderBooksSearchTest extends BaseTest {
	
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "bookNamesDataProivder")
	public void searchBooksTest(String book, String bookPictureName ) throws InterruptedException {
		
		page.navMenu.searchBooks(book);

		Thread.sleep(2000);
		WebElement element  = driver.findElement(By.cssSelector("div[data-image*='" + bookPictureName+"']"));
		
		assertTrue(element.isDisplayed());
		
		
		Thread.sleep(2000);

	}

}