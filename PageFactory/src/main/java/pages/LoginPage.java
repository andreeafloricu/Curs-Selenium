package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReadPropertiesFile;
import utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers {

	public WebDriver driver;
	public String username = ReadPropertiesFile.credentials.getProperty("user");
	public String password = ReadPropertiesFile.credentials.getProperty("pass");
	
	@FindBy(id = "log") public WebElement usernameField;
	@FindBy(id = "password") public WebElement passwordFiled;
	@FindBy(css = "input[class='submit_button']") public WebElement submitButton;
	@FindBy(css = "li[class='menu_user_logout']") public WebElement logoutButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void loginInApp() {
		//usernameField.sendKeys(username); //varianta selenium
		sendKeys(usernameField, username); //varianta selenium wrappers
		sendKeys(passwordFiled, password);
		//submitButton.click();
		click(submitButton);
	}
	
	public void logoutFromApp() {
		//logoutButton.click();
		click(logoutButton);
	}
}
