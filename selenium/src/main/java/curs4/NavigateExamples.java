package curs4;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import utils.BaseTest;

public class NavigateExamples extends BaseTest{
	
	@Ignore
	public void navigateExamples() throws InterruptedException {
		Thread.sleep(1000);
		driver.navigate().to("https://keyfood.ro/");
		Thread.sleep(1000);
		driver.get("https://www.emag.ro/");
		Thread.sleep(1000);
		driver.navigate().to("https://altex.ro/");
		driver.navigate().back();
		
	}
	
	@Test
	public void navigateBackFwExample() {
		driver.get("https://keybooks.ro/");
		driver.navigate().refresh();
		driver.navigate().to("https://keybooks.ro/shop/");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.get("https://keybooks.ro/events_calendar/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
			
	}	
}