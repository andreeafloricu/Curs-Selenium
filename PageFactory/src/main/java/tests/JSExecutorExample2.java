package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JSExecutorExample2 extends BaseTest {
	
	
	@Test
	public void testJS() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// jse.executeScript("arguments[0].click()", page.navMenu.searchIcon);
		// jse.executeScript("arguments[0].value='cooking'", page.navMenu.searchInput);
		// jse.executeScript("arguments[0].click()", page.navMenu.searchIcon);

		
		
	//	jse.executeScript("arguments[0].click(), arguments[1].value='cooking' , arguments[2].click() ", 
	//			page.navMenu.searchIcon,
	//			page.navMenu.searchInput);
		
		
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");

		
		String bookTitle = jse.executeScript(" return document.getElementsByClassName('post_title')[0].childNodes[0].innerHTML").toString();
		
		System.out.println(bookTitle);
		
		System.out.println("Titlu initial : " +driver.getTitle());

		jse.executeScript("window.schimbTitlu =function(){document.title = 'This title is changed by me!';};" + "window.schimbTitlu.call();");
		
		System.out.println("Titlu schimbat : "+driver.getTitle());
		
		//alte actiuni...
		jse.executeScript("window.schimbTitlu.call();");
		Thread.sleep(5000);	
	}
}