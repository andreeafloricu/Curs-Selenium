package curs6;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LoginExample extends BaseTest{

	
	@Parameters({"user", "pass"})
	@Test(priority = 1)
	public void validVlogin(String user, String pass) throws InterruptedException {
		
		WebElement popupLink = driver.findElement(By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		popupLink.click();
		Thread.sleep(3000);
		
		// //form[contains(@class, 'popup_form')]/descendant::input[@id='log']
		// //form[contains(@class, 'popup_form')]/child::div/child::input[@id='log']
		WebElement usernameField = driver.findElement(By.xpath("//form[contains(@class, 'popup_form')]/preceding::input[@id='log']"));
		usernameField.sendKeys(user);
		
		// //input[contains(@class, 'submit_button')]/ancestor::form/div[contains(@class, 'password_field')]/input
		// //input[contains(@class, 'submit_button')]/ancestor::form/child::div[contains(@class, 'password_field')]/input
		// //input[contains(@class, 'submit_button')]/ancestor::form/preceding::input[@id='password']
		
		
		WebElement passwordField =  driver.findElement(By.xpath("//div[contains(@class, 'login_field' )]/following-sibling::div/input"));
		passwordField.sendKeys(pass);
		
		Thread.sleep(3000);
		
		//(//div[contains(@class, 'popup_form_field' )]/descendant::input[@class='submit_button'])[1]
		WebElement submitButton =  driver.findElement(By.xpath("(//div[contains(@class, 'popup_form_field' )]/descendant::input[@class='submit_button'])[1]"));
		submitButton.click();
		
		Thread.sleep(4000);
		
		WebElement username = driver.findElement(By.xpath("//span[@class='user_name']"));
		assertEquals(username.getText(), "Test User");
		WebElement logoutButton = driver.findElement(By.xpath("//li[@class='menu_user_logout']"));
		logoutButton.click();
		Thread.sleep(5000);

	}
	@Parameters({"wronguser", "wrongpass"})
	@Test(priority = 2)
	public void invalidVlogin(String user, String pass) throws InterruptedException {
		
		WebElement popupLink = driver.findElement(By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		popupLink.click();
		Thread.sleep(3000);
		
		// //form[contains(@class, 'popup_form')]/descendant::input[@id='log']
		// //form[contains(@class, 'popup_form')]/child::div/child::input[@id='log']
		WebElement usernameField = driver.findElement(By.xpath("//form[contains(@class, 'popup_form')]/preceding::input[@id='log']"));
		usernameField.sendKeys(user);
		
		// //input[contains(@class, 'submit_button')]/ancestor::form/div[contains(@class, 'password_field')]/input
		// //input[contains(@class, 'submit_button')]/ancestor::form/child::div[contains(@class, 'password_field')]/input
		// //input[contains(@class, 'submit_button')]/ancestor::form/preceding::input[@id='password']
		
		
		WebElement passwordField =  driver.findElement(By.xpath("//div[contains(@class, 'login_field' )]/following-sibling::div/input"));
		passwordField.sendKeys(pass);
		
		Thread.sleep(3000);
		
		//(//div[contains(@class, 'popup_form_field' )]/descendant::input[@class='submit_button'])[1]
		WebElement submitButton =  driver.findElement(By.xpath("(//div[contains(@class, 'popup_form_field' )]/descendant::input[@class='submit_button'])[1]"));
		submitButton.click();
		
		Thread.sleep(1000);
		
		//WebElement username = driver.findElement(By.xpath("//span[@class='user_name']"));
		//assertEquals(username.getText(), "Test User");
		//WebElement logoutButton = driver.findElement(By.xpath("//li[@class='menu_user_logout']"));
		//logoutButton.click();
		
		WebElement errorMessage = driver.findElement(By.cssSelector("div[class*='sc_infobox_style_error']"));
		assertTrue(errorMessage.isDisplayed());
		
		//sc_infobox_style_error
		
		Thread.sleep(3000);
		
	}	
}