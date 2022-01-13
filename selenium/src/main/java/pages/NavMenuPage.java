package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavMenuPage  {
	
	public WebDriver driver;
	
	public NavMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loginLink = By.linkText("Login");
	public By shopLink = By.linkText("BOOKS");
	public By contactLink = By.linkText("CONTACTS");
	
	public void navigateToLogin() {
		//WebWait
		driver.findElement(loginLink).click();
		//customClick(loginLink);
	}
	
	public LoginPage navToLogin () {
		driver.findElement(loginLink).click();
		return new LoginPage(driver);
	}
	
	public ShopPage navToShop() {
		driver.findElement(shopLink).click();
		return new ShopPage(driver);
	}
	
	public ContactPage navToContact() {
		driver.findElement(contactLink);
		return new ContactPage(driver);
	}
}