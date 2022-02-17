package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

public class Homework13 extends BaseTest {
	
	
	@Test
	public void homework() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		WebElement blogButton = driver.findElement(By.linkText("BLOG"));
		blogButton.click();
		
		Thread.sleep(2000);	
		
		List<WebElement> posts = driver.findElements(By.cssSelector("article.klb-article"));
		
		//int nrOfPosts = (int) jse.executeScript("document.getElementsByClassName('klb-article').length");
		
		assertEquals(posts.size(), 4);
			    
		for (int i = 0; i < posts.size(); i++) {
			jse.executeScript("document.getElementsByClassName('post-thumbnail')[" + i +"].childNodes[1].click()");
			Thread.sleep(2000);
			
			jse.executeScript("document.getElementsByName('comment')[0].value='commentariu" + i + "'");
			jse.executeScript("document.getElementsByName('author')[0].value='andreea'");
			jse.executeScript("document.getElementsByName('email')[0].value='andreea@email.com'");
			
			jse.executeScript("document.getElementsByName('submit')[0].click()");
			
			Thread.sleep(3000);
			
			WebElement comments = driver.findElement(By.cssSelector("ol.comment-list"));
			
			assertTrue(comments.getText().contains("comment" + i));

			driver.get("https://keyfood.ro/blog/");
		}	
	}
}
