package curs3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindEelementsExample extends BaseTest{

	@Test
	public void testFindElements() throws InterruptedException {
		List<WebElement> bookPictures = driver.findElements(By.cssSelector("figure[class*='sc_image']"));
		
		for(WebElement element : bookPictures) {
			JavascriptExecutor jse =  (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border: 12px solid red;')", element);
			Thread.sleep(1000);
		}
	}
	
	@Test(priority = 1)
	public void testFindElements2() {
		
		List<WebElement> books = driver.findElements(By.cssSelector("h3[class*='sc_title']"));
		System.out.println(driver.getCurrentUrl());
		books.get(2).click();
		System.out.println(books.size());
		String currentUrl =  driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		//List<String>
		//List<Integer>
		//List<Object>
		
		//lista books = (book1 , book2, book3)
		// index books = (0, 1, 2)
		//books.get(2)
	}
}