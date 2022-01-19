package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

	public WebDriver driver;

	@FindBy(css = "select[name='orderby']") public WebElement sortButton;
	@FindBy(css = "option[value='price']") public WebElement lowToHighButton;
	@FindBy(css = "div.post_content a[href='https://keybooks.ro/shop/cooking-with-love/']") public WebElement cookingWithLoveBook;
	@FindBy(css = "div.post_content a[href='https://keybooks.ro/shop/let-the-sun-shine/']") public WebElement letThesunshineBook;
	@FindBy(css= "ul.products>li:first-child span.amount bdi") public WebElement firstBookPrice;
	@FindBy(css= "ul.products>li:last-child span.amount bdi") public WebElement lastBookPrice;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
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
