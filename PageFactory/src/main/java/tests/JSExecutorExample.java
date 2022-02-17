package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.BaseTest;

public class JSExecutorExample extends BaseTest{

	
	@Ignore
	public void reloadPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.navigate().to("https://keyfood.ro");
		
		js.executeScript("window.location='https://emag.ro';");
		
		Thread.sleep(5000);
		
		js.executeScript("window.history.go(-1);");
		
		Thread.sleep(5000);

		js.executeScript("window.history.forward(-1);");
		
		
		//1
		driver.navigate().refresh();
		//2
		js.executeScript("window.history.go(0);");
		//3
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		//4
		driver.get(driver.getCurrentUrl());
		//5
		driver.navigate().to(driver.getCurrentUrl());
	
	}
	
	//"return document.title"
	
	// element.getText();
	//"return arguments[0].innerHTML" , element
	
	
	@Ignore
	public void jsScroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//js.executeScript("window.scrollBy(0,1000)");
		
		WebElement element = driver.findElement(By.cssSelector("input[value='Sign up']")); 
		//js.executeScript("arguments[0].scrollIntoView();",element );

		Thread.sleep(5000);
		
		Actions action  =  new Actions(driver);
		action.moveToElement(element).perform();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

		Thread.sleep(5000);	
		
	}
	
	@Test
	public void jsSleep() {
		JavascriptExecutor js = (JavascriptExecutor)driver;

		long start_time = System.currentTimeMillis();
		System.out.println("Start-time : " +start_time);
		
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length -1], 5000);");
		
		long current_time = System.currentTimeMillis();
		System.out.println("Current-time : " +start_time);
		
		System.out.println("Passed time : " + (current_time - start_time));	
		
	}
}