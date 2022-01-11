package curs4;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class HomeworkCurs4 extends BaseTest {

	@Test
	public void review () throws InterruptedException {
		WebElement theForestBook = driver.findElement(By.cssSelector("div[aria-hidden='false'] > div > div > h3 > a[href='the-forest']"));
		theForestBook.click();
		
		WebElement reviewsTab = driver.findElement(By.cssSelector("li.reviews_tab"));
		reviewsTab.click();
		
		WebElement checkBox = driver.findElement(By.cssSelector("input#wp-comment-cookies-consent"));
		assertTrue(!checkBox.isSelected());
		
		WebElement starRating = driver.findElement(By.cssSelector("a.star-5"));
		starRating.click();
		Thread.sleep(1000);
		
		WebElement yourReview = driver.findElement(By.cssSelector("textarea#comment"));
		yourReview.sendKeys("My review is here!");
		Thread.sleep(1000);
		
		WebElement name = driver.findElement(By.cssSelector("input#author"));
		name.sendKeys("name");
		Thread.sleep(1000);
		
		WebElement email = driver.findElement(By.cssSelector("input#email"));
		email.sendKeys("name@email.com");
		Thread.sleep(1000);
		
		checkBox.click();
		Thread.sleep(1000);
		assertTrue(checkBox.isSelected());
		
		WebElement submitButton = driver.findElement(By.cssSelector("input#submit"));
		submitButton.click();
		Thread.sleep(2000);
		
		WebElement message = driver.findElement(By.cssSelector("em.woocommerce-review__awaiting-approval"));
		assertTrue(message.isDisplayed());
	}
}
