package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework10 extends BaseTest {
	
	@Test 
	public void dragAndDropTest() throws InterruptedException {
		page.navMenu.hoverElement(page.navMenu.blogLink);
		page.navMenu.navigateTo(page.navMenu.postFormatsLink);
		page.postFormats.openAudioSection();
		
		Actions action = new Actions(driver);
		
		assertTrue(page.audioPage.checkCurrentUrl("https://keybooks.ro/2016/02/02/audio-post/"));
		
		assertTrue(page.audioPage.timeSlider.isDisplayed());
		
		Thread.sleep(5000);

//		System.out.println(driver.findElement(By.cssSelector("a[aria-label='Volume Slider']")).getAttribute("ariavalueNow"));
//		
//		action.moveToElement(page.audioPage.volumeSlider)
//			   .click()
//			   .dragAndDropBy(page.audioPage.volumeSlider, 10, 20)
//			   .build()
//			   .perform();
//		
//		System.out.println(driver.findElement(By.cssSelector("a[aria-label='Volume Slider']")).getAttribute("aria-valuenow"));

	}
}
