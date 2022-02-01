package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class ShopPage extends SeleniumWrappers {

	public WebDriver driver;

	@FindBy(css = "select[name='orderby']") public WebElement sortButton;
	@FindBy(css = "option[value='price']") public WebElement lowToHighButton;
	@FindBy(css = "div.post_content a[href='https://keybooks.ro/shop/cooking-with-love/']") public WebElement cookingWithLoveBook;
	@FindBy(css = "div.post_content a[href='https://keybooks.ro/shop/let-the-sun-shine/']") public WebElement letThesunshineBook;
	@FindBy(css= "ul.products>li:first-child span.amount bdi") public WebElement firstBookPrice;
	@FindBy(css= "ul.products>li:last-child span.amount bdi") public WebElement lastBookPrice;
	
	@FindBy(css="span[style='left: 0%;']") public WebElement sliderInitialPosition;
	@FindBy(css="span[style='left: 100%;']") public WebElement sliderFinalPosition;
	@FindBy(css="a[class*='add_to_cart_button']") public WebElement addToCart;
	
	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	
	}
	
	public void sortBooksLowToHigh() {
		sortButton.click();
		lowToHighButton.click();
	}
	
	public ProductPage openBookPage(WebElement book) {
		book.click();
		return new ProductPage(driver);
	}
}
