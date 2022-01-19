package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public WebDriver driver;

	@FindBy(css = "h1[class*='product_title']") public WebElement title;
	@FindBy(css = "div[class*='gallery']") public WebElement gallery;
	@FindBy(css = "div[class*='summary']  span[class*='amount']") public WebElement price;
	@FindBy(css = "div[class*='summary']  div[class*='product-details']") public WebElement details;
	@FindBy(css = "div[class*='summary']  div[class*='woocommerce-product-rating']") public WebElement rating;
	@FindBy(css = "div[class*='summary']  input[name='quantity']") public WebElement quantity;
	@FindBy(css = "div[class*='summary'] button[name='add-to-cart']") public WebElement addToCartButton;
	@FindBy(css = "div[class*='summary'] div.product_meta") public WebElement productMeta;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
