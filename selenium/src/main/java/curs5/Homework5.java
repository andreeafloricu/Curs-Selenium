package curs5;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework5 extends BaseTest{
	
	@Test(priority=1)
	public void addToCart() throws InterruptedException {
		WebElement searchButton = driver.findElement(By.cssSelector("button.search_submit"));
		WebElement inputSearch = driver.findElement(By.cssSelector("input.search_field"));
		
		searchButton.click();
		inputSearch.sendKeys("The story about me");
		searchButton.click();
		Thread.sleep(2000);
		
		WebElement loadMoreButton = driver.findElement(By.linkText("LOAD MORE"));
		loadMoreButton.click();
				
		WebElement book = driver.findElement(By.linkText("The story about me"));
		book.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/");
		
		WebElement addToCartButton = driver.findElement(By.cssSelector("button[name='add-to-cart']"));
		addToCartButton.click();
		
		WebElement message = driver.findElement(By.cssSelector("div.woocommerce-message"));
		
		assertTrue(message.isDisplayed());
		
		WebElement viewCartButton = driver.findElement(By.linkText("VIEW CART"));
		viewCartButton.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/");	
	}	
	
	@Test(priority=2)
	public void updateCart() throws InterruptedException {
		
		WebElement increaseQuantityButton = driver.findElement(By.cssSelector("span.q_inc"));
		increaseQuantityButton.click();
		Thread.sleep(2000);
		
		WebElement updateCartButton = driver.findElement(By.cssSelector("button[name='update_cart']"));
		updateCartButton.click();
		Thread.sleep(3000);
		
		WebElement message = driver.findElement(By.cssSelector("div.woocommerce-message"));
		assertTrue(message.isDisplayed());
		
		WebElement checkoutButton = driver.findElement(By.linkText("PROCEED TO CHECKOUT"));
		checkoutButton.click();
		Thread.sleep(2000);
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");
		
		WebElement billingDetails = driver.findElement(By.cssSelector("div.woocommerce-billing-fields > h3"));
		assertTrue(billingDetails.isDisplayed());
		assertEquals(billingDetails.getText(), "Billing details");
		
		WebElement additionalInformation = driver.findElement(By.cssSelector("div.woocommerce-additional-fields > h3"));
		assertTrue(additionalInformation.isDisplayed());
		assertEquals(additionalInformation.getText(), "Additional information");
	}
}
