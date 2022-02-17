package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework10 extends BaseTest {
	
	@Test 
	public void dragAndDropTest() throws InterruptedException {
		page.navMenu.hoverElement(page.navMenu.blogLink);
		page.navMenu.navigateTo(page.navMenu.postFormatsLink);
		page.postFormats.openAudioSection();
				
		assertTrue(page.audioPage.checkCurrentUrl("https://keybooks.ro/2016/02/02/audio-post/"));
				
		Thread.sleep(3000);
		
		Actions action =  new Actions(driver);
		
		page.audioPage.playButton.click();
		Thread.sleep(2000);
		page.audioPage.playButton.click();

		action.moveToElement(page.audioPage.timeSliderMin).click().dragAndDropBy(page.audioPage.timeSliderMin, 100, 0).build().perform();
		
		Thread.sleep(5000);

		action.moveToElement(page.audioPage.volumeSliderMin).click().dragAndDropBy(page.audioPage.volumeSliderMin, 100, 0).build().perform();
	}
}
