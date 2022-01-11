package curs4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectors extends BaseTest {
	
	@Test
	public void testCssSelectors() {
		
		//id --> #
		WebElement loginPopUp = driver.findElement(By.cssSelector("#menu_user"));
		System.out.println(loginPopUp.getText());
		
		//class --> .
		WebElement logo = driver.findElement(By.cssSelector(".logo_slogan"));
		System.out.println(logo.getText());
		
		//h3 -->h3[style] --> h3[style='text-align:center;color:#ffffff;']']
		//h3.sc_title_underline
		WebElement updatesTitle = driver.findElement(By.cssSelector("h3[style='text-align:center;color:#ffffff;']"));
		System.out.println(updatesTitle.getText());
		
		//div[class*='column-1_2'] h3.sc_title_underline
		//div.column-1_2 h3.sc_title_underline
		WebElement titleInspire = driver.findElement(By.cssSelector("div.column-1_2 h3.sc_title_underline"));
		System.out.println(titleInspire.getText());
		WebElement titleInspire2 = driver.findElement(By.cssSelector("div[class*='column-1_2'] h3.sc_title_underline"));
		System.out.println(titleInspire2.getText());
		WebElement titleInspire3 = driver.findElement(By.cssSelector("div[class*='column-1_2'] h3[class*='sc_title_underline']"));
		System.out.println(titleInspire3.getText());
		
		
		//div[class*='column-1_2']>div[class*='wpb_text_column']>div[class*='wpb_wrapper'] 
		//div[class*='column-1_2'] div[class*='wpb_wrapper']
		
		WebElement quoteText = driver.findElement(By.cssSelector("div[class*='column-1_2'] div[class*='wpb_wrapper']"));
		System.out.println(quoteText.getText());
		
		/*
		 * WebElement loginPopup =
		 * driver.findElement(By.cssSelector("a[class*='popup_link']"));
		 * loginPopup.click();
		 * 
		 * //and //input[id='log'][name='log'][type='text']
		 * 
		 * WebElement element =driver.findElement(By.cssSelector("input[id='log']"));
		 * JavascriptExecutor jse = (JavascriptExecutor) driver; jse.
		 * executeScript("arguments[0].setAttribute('style', 'background:yellow; border: 12px solid red;')"
		 * , element); //jse.executeScript("arguments[0].setAttribute('name', 'log3')",
		 * element);
		 * 
		 * WebElement usernameField =
		 * driver.findElement(By.cssSelector("input[id='log'][name='log'][type='text']")
		 * ); usernameField.sendKeys("TestUser");
		 * 
		 * WebElement passelement
		 * =driver.findElement(By.cssSelector("input[id='password']"));
		 * jse.executeScript("arguments[0].setAttribute('type', 'test')", passelement);
		 * 
		 * //or WebElement passwordField = driver.findElement(By.cssSelector(
		 * "input[id='password'],[type='password'],[name='pwd']"));
		 * passwordField.sendKeys("12345@67890");
		 * 
		 * WebElement submitButton = driver.findElement(By.cssSelector(
		 * "input[class='submit_button'],[type='submit'],[name='Login']"));
		 * submitButton.click();
		 */
		
		//contains
		WebElement booktitle = driver.findElement(By.cssSelector("h3[class*='sc_title_regular']"));
		System.out.println(booktitle.getText());
		
		//contains word
		WebElement buttonDiscoverMore = driver.findElement(By.cssSelector("a[class~='sc_button_style_filled']"));
		System.out.println(buttonDiscoverMore.getText());
		
		
		//starting with
		WebElement booktitleStartingWith = driver.findElement(By.cssSelector("a[href^='its']"));
		System.out.println(booktitleStartingWith.getText());
		
		//ends with
		WebElement bookTitleEndingWith = driver.findElement(By.cssSelector("a[href$='garden']"));
		System.out.println(bookTitleEndingWith.getText());

		//not
		//li[class*='sc_tabs_title']:not([aria-selected="true"])
		//li[class*='sc_tabs_title']:not([class*="ui-state-active"])
		//li[class*='sc_tabs_title']:not(.ui-state-active)
		List<WebElement> menuTabs = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		
		for(WebElement elem : menuTabs) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border: 6px solid red;')", elem);
		}
		
		//nth-child
		WebElement menuTab2 = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-child(2)"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border: 6px solid red;')", menuTab2);
		
	}
}
