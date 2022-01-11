package curs5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XPathExamples extends BaseTest {

	@Test(priority = 1)
	public void xpathLoginExample() throws InterruptedException {
		WebElement loginMenu = driver.findElement(By.xpath("//li[@class='menu_user_login']"));
		loginMenu.click();
		
		WebElement usernameField = driver.findElement(By.xpath("//input[@id='log' or @name='log']"));
		usernameField.sendKeys("TestUser");
		Thread.sleep(1000);
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password' and @name='pwd']"));
		passwordField.sendKeys("12345@67890");
		Thread.sleep(1000);

		WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@id='rememberme' and @name='rememberme']"));
		rememberMeCheckbox.click();
		Thread.sleep(1000);
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		loginButton.click();
		Thread.sleep(4000);
		
		WebElement userName = driver.findElement(By.xpath("//span[@class='user_name']"));
		assertEquals(userName.getText(), "Test User");
	}
	
	@Test(priority = 2, dependsOnMethods = "xpathLoginExample")
	public void testAccountDetails() {
		
		navigateToAccount();
		WebElement recentOrdersLink = driver.findElement(By.xpath("//a[contains(text(), 'recent orders')]"));
		recentOrdersLink.click();
		
		WebElement orderHeader = driver.findElement(By.xpath("//th[contains(@class, 'woocommerce-orders-table__header woocommerce-orders-table__header-order-number')]"));
		orderHeader.isDisplayed();
		
		WebElement orderNumber = driver.findElement(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(), '1674')]"));
		orderNumber.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/view-order/1641/");
	}
	
	@Test(priority = 3)
	public void testShopExamples() {
		
		//WebElement 
		////div[@class='star-rating']/span[not(contains(@style, 'width:100%'))]
	
		//div[@class='star-rating']/span[not(contains(@style, 'width:100%'))]/ancestor::div[@class='post_content']//child::*[@href='https://keybooks.ro/shop/life-in-the-garden/']
		
	}
}
