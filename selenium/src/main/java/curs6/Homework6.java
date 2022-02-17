package curs6;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework6 extends BaseTest {
	
	@Parameters({"name", "email", "subject", "message"})
	@Test
	public void homework(String name, String email, String subject, String message) throws InterruptedException {

		WebElement nameEl = driver.findElement(By.cssSelector("input[name='your-name']"));
		WebElement emailEl = driver.findElement(By.cssSelector("input[name='your-email']"));
		WebElement subjectEl = driver.findElement(By.cssSelector("input[name='your-s']"));
		WebElement messageEl = driver.findElement(By.cssSelector("textarea[name='your-message']"));
		WebElement sendMessageButton = driver.findElement(By.cssSelector("input[value='Send Message']"));
		
		nameEl.sendKeys(name);
		emailEl.sendKeys(email);
		subjectEl.sendKeys(subject);
		messageEl.sendKeys(message);
		
		sendMessageButton.click();
		
		Thread.sleep(3000);
		
		WebElement response = driver.findElement(By.cssSelector("div.wpcf7-response-output"));
		
		assertTrue(response.isDisplayed());
	}
}
