package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReadPropertiesFile;

public class LoginPage {

	public WebDriver driver;
	public String username = ReadPropertiesFile.credentials.getProperty("user");
	public String password = ReadPropertiesFile.credentials.getProperty("pass");
	
	@FindBy(id = "log") public WebElement usernameField;
	@FindBy(id = "password") public WebElement passwordFiled;
	@FindBy(css = "input[class='submit_button']") public WebElement submitButton;
	@FindBy(css = "li[class='menu_user_logout']") public WebElement logoutButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginInApp() {
		usernameField.sendKeys(username);
		passwordFiled.sendKeys(password);
		submitButton.click();
	}
}
