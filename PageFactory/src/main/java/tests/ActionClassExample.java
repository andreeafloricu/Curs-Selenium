package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ActionClassExample extends BaseTest {

	//@Test (priority = 1)
	public void hoverExample() {
		page.navMenu.hoverElement(page.navMenu.blogLink);
		page.navMenu.navigateTo(page.navMenu.postFormatsLink);
		assertTrue(page.postFormats.checkCurrentUrl("https://keybooks.ro/category/post-formats/"));
	}
	
	//@Test (priority = 2)
	public void sendKeysExample() throws InterruptedException {
		Actions action = new Actions(driver);
		action
			.moveToElement(page.postFormats.searchField)
			.keyDown(Keys.SHIFT)
			.sendKeys(page.postFormats.searchField, "abracadabra")
			.perform();
		
		Thread.sleep(5000);
	}
	
	//@Test (priority = 3)
	public void sendKeysExample2() throws InterruptedException {
		page.navMenu.navigateTo(page.navMenu.contactLink);
		Actions action = new Actions(driver);
		Thread.sleep(3000);

		action
			.moveToElement(page.contactPage.nameField)
			.sendKeys(page.contactPage.nameField, "Name")
			.sendKeys(Keys.TAB, "abc@abc.com")
			.sendKeys(Keys.TAB, "subject")
			.sendKeys(Keys.TAB, "message")
			.sendKeys(Keys.TAB, Keys.ENTER)
			.perform();
		
		Thread.sleep(10000);

	}
	
	//@Test
		public void offsetExample() throws InterruptedException {
			
			page.navMenu.navigateTo(page.navMenu.contactLink);
			Actions action =  new Actions(driver);
			
			//page.contactPage.nameField.sendKeys("Test1");
			
			int getX = page.contactPage.nameField.getLocation().getX();
			System.out.println("X :" + getX);
			int getY = page.contactPage.nameField.getLocation().getY();
			System.out.println("X :" + getY);
			
			action.moveByOffset(getX, getY).click().sendKeys("Test").perform();
			Thread.sleep(5000);
			
		}
		
		@Test
		public void testDragAndDrop() throws InterruptedException {
			page.navMenu.navigateTo(page.navMenu.shopLink);
			
			Thread.sleep(2000);
			page.shopPage.dragAndDropSlider(page.shopPage.sliderFinalPosition, -100, 0);
			Thread.sleep(5000);
			page.shopPage.dragAndDropSlider(page.shopPage.sliderInitialPosition, 100, 0);
			Thread.sleep(5000);

		}
		
		//@Test
		public void doubleClickExample() throws InterruptedException {
			page.navMenu.navigateTo(page.navMenu.shopLink);
			page.shopPage.doubleClick(page.shopPage.addToCart);	
			Thread.sleep(5000);

		}
}
