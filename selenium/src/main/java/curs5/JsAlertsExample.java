package curs5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;

public class JsAlertsExample extends BaseTest {

	@Test(priority = 0)
	public void simpleJsAlertExample() throws InterruptedException {
		
		driver.findElement(By.cssSelector("button[onclick*='Alert']")).click();
		Thread.sleep(3000);
		Alert alertJs = driver.switchTo().alert();
		alertJs.accept();
		String result = driver.findElement(By.id("result")).getText();
		assertEquals(result, "You successfully clicked an alert");
		Thread.sleep(2000);
	}
	
	@Test(priority = 1) 
	public void confirmJsAlertExample() throws InterruptedException {
		
		driver.findElement(By.cssSelector("button[onclick*='Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		String result = driver.findElement(By.id("result")).getText();
		assertEquals(result, "You clicked: Cancel");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void jsPromptAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick*='Prompt']")).click();
		Thread.sleep(3000);
		Alert alertJs = driver.switchTo().alert();
		alertJs.sendKeys("Test test");
		alertJs.accept();
		String result = driver.findElement(By.id("result")).getText();
		assertEquals(result, "You entered: Test test");
		Thread.sleep(2000);
	}
}
