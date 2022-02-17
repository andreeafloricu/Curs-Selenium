package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers {

	//public WebDriver driver;
	
	public NavMenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[class*='popup_login_link']") public WebElement loginLink;
	@FindBy(linkText = "BOOKS") public WebElement shopLink;
	@FindBy(linkText = "BLOG") public WebElement blogLink;
	@FindBy(linkText = "Post Formats") public WebElement postFormatsLink;
	@FindBy(linkText = "CONTACTS") public WebElement contactLink;
	@FindBy(linkText = "EVENTS") public WebElement eventsPage;
	
	@FindBy(css="button[class*='search_submit']") public WebElement searchIcon;
	@FindBy(css="input[class='search_field']") public WebElement searchInput;

	public void navigateTo(WebElement element) {
		element.click();
	}
	
	public void searchBooks(String book) {
		click(searchIcon);
		sendKeys(searchInput, book);
		click(searchIcon);
	}
}
