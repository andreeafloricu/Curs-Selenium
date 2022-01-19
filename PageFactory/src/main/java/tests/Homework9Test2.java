package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.NavMenuPage;
import pages.ProductPage;
import pages.ShopPage;
import utils.BaseTest;

public class Homework9Test2 extends BaseTest {
	
	NavMenuPage navMenu;
	ShopPage shopPage;
	ProductPage productPage;

	@Test
	public void checkBookElements() throws InterruptedException {
		navMenu = new NavMenuPage(driver);
		shopPage = new ShopPage(driver);
		
		SoftAssert sa = new SoftAssert();
		
		navMenu.navigateTo(navMenu.shopLink);
		
		productPage = shopPage.openBookPage(shopPage.letThesunshineBook);
		
		Thread.sleep(3000);
		
		sa.assertTrue(productPage.title.isDisplayed());
		sa.assertTrue(productPage.gallery.isDisplayed());
		sa.assertTrue(productPage.price.isDisplayed());
		sa.assertTrue(productPage.details.isDisplayed());
		sa.assertTrue(productPage.rating.isDisplayed());
		sa.assertTrue(productPage.quantity.isDisplayed());
		sa.assertTrue(productPage.addToCartButton.isDisplayed());
		sa.assertTrue(productPage.productMeta.isDisplayed());
		sa.assertAll();
	}
}
