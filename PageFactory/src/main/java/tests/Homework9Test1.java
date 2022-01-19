package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.NavMenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class Homework9Test1 extends BaseTest {
	
	NavMenuPage navMenu;
	ShopPage shopPage;

	@Test
	public void sortBooks() throws InterruptedException {
		navMenu = new NavMenuPage(driver);
		shopPage = new ShopPage(driver);
		
		navMenu.navigateTo(navMenu.shopLink);

		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
		
		shopPage.sortBooksLowToHigh();
		
		Thread.sleep(3000);
		
		int firstBookPrice = Integer.parseInt(shopPage.firstBookPrice.getText().replace("$", "").replace(".", ""));
		int lastBookPrice = Integer.parseInt(shopPage.lastBookPrice.getText().replace("$", "").replace(".", ""));
		
		assertTrue(firstBookPrice < lastBookPrice);
	}

}
