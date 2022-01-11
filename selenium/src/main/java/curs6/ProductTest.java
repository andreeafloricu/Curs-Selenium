package curs6;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ProductTest extends BaseTest{
	
	@Test
	public void testProduct() {
		WebElement book = driver.findElement(By.linkText("The forest"));
		book.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/");
	}
}