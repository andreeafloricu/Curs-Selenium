package curs3;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class GetExample extends BaseTest {
	
	
	@Test
	public void getExample() {
		
		List<WebElement> books = driver.findElements(By.cssSelector("h3[class*='sc_title']"));
		books.get(2).click();
		
		String currentUrl =  driver.getCurrentUrl();
		String expectedUrl = "https://keybooks.ro/shop/life-in-the-garden/";
		assertEquals(currentUrl, expectedUrl);
		
		String currentPageTitle = driver.getTitle();
		String expectedTitle = "Life in the garden – Booklovers";
		assertEquals(currentPageTitle, expectedTitle);
		
		WebElement bookTile =  driver.findElement(By.cssSelector("h1[class*='product_title']"));
		String actualTitle = bookTile.getText();
		String expectedBookTitle = "Life in the garden";
		assertEquals(actualTitle, expectedBookTitle);
		
	}
}