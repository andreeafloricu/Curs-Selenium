package curs3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectorsExample extends BaseTest{
	
	@Test
	public void cssExamples() {
		
		WebElement login =  driver.findElement(By.cssSelector("#menu_user"));
		System.out.println(login.getText());
		WebElement logoSlogan =  driver.findElement(By.cssSelector(".logo_slogan"));
		System.out.println(logoSlogan.getText());
		
		WebElement textAllanGreen =  driver.findElement(By.cssSelector("div.wpb_wrapper p"));
		System.out.println(textAllanGreen.getText());
		//div.wpb_wrapper p
		
		WebElement selectedMenu =  driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-expanded='true']"));
		System.out.println(selectedMenu.getText());
		
		//li[class*='sc_tabs_title'][aria-expanded='true']
		
	}
}