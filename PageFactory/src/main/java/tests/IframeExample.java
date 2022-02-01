package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class IframeExample extends BaseTest {
	
	//@Test
	public void iFrameExample() throws InterruptedException {
		page.navMenu.navigateTo(page.navMenu.contactLink);
		
		page.contactPage.zoomMap(page.contactPage.zoomOut);
		Thread.sleep(5000);
	}
	
	@Test
	public void iframeExample2() throws InterruptedException {
		
		page.navMenu.navigateTo(page.navMenu.eventsPage);
		page.eventPage.click(page.eventPage.festivalOfOldFilms);
		page.singleEventPage.clickMap();
		Thread.sleep(5000);
		//System.out.println(driver.getWindowHandles());
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
	//	System.out.println(browserTabs.size());
	//	System.out.println(browserTabs.get(0));
//		System.out.println(browserTabs.get(1));
		driver.switchTo().window(browserTabs.get(1));
		driver.close();
		Thread.sleep(5000);	
	}
}