package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.DataProviderClass;

public class Homework12 extends BaseTest{
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "foodNamesDataProivder")
	public void checkProductImages(String product, String productPictureName ) throws InterruptedException {
		
		driver.get("https://keyfood.ro/product-category/fruits-vegetables/");

		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("a[title='" + product + "']")).click();
		
		Thread.sleep(2000);
		
		WebElement element  = driver.findElement(By.cssSelector("img[data-src*='" + productPictureName+"']"));
			
		assertTrue(element.isDisplayed());	
		
		Thread.sleep(2000);
	}
}
