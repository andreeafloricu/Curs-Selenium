package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

	public WebDriver driver;
	
	public By inputName = By.cssSelector("input[name='your-name']");
	public By inputEmail = By.cssSelector("input[name='your-email']");
	public By inputSubject = By.cssSelector("input[name='your-s']");
	public By inputMessage = By.cssSelector("input[name='your-message']");
	public By sendMessageButton = By.cssSelector("input[value='Send Message']");
	public By messageSent = By.cssSelector("div[class='wpcf7-response-output']");
	public By emptyFieldMessage = By.cssSelector("span[class='wpcf7-not-valid-tip']");

	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//dinamica, de fiecare data cand o folosesc ii dau ce parametrii vreau, emtpy sau nu, ca sa testez cu ea toate scenariile
	public void sendMessage(String name, String email, String subject, String message) {
		driver.findElement(inputName).sendKeys(name);
		driver.findElement(inputEmail).sendKeys(email);
		driver.findElement(inputSubject).sendKeys(subject);
		driver.findElement(inputMessage).sendKeys(message);
	}
	
	public boolean returnMessageSentInfo (String textToBePresent) {
		try {
			WebElement message = driver.findElement(messageSent);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(message, textToBePresent));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean emptyFieldWarningMessage () {
		try {
			WebElement message = driver.findElement(emptyFieldMessage);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(message, "The filed is required."));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
}
