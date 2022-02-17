package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShippingAddress;
import utils.BaseTest;

public class Homework8 extends BaseTest {
	
	@Test
	public void login() throws InterruptedException {		
			
		LoginPage loginPage = navMenu.navToLogin();
		loginPage.loginInApp("TestUser", "12345@67890");
		
		Thread.sleep(5000);
	}

	@Test(dependsOnMethods = "login")
	public void filterByValue() throws InterruptedException {	
		
		ShippingAddress shippingPage = navMenu.navToShippingAddress();
		
		Thread.sleep(3000);
		
		shippingPage.filterRegionByValue("CA");
		assertEquals(shippingPage.getTheCurrentSelectedRegion(), "Canada");	
	}
	
	@Test(dependsOnMethods = "login")
	public void filterByIndex() throws InterruptedException {	
		
		ShippingAddress shippingPage = navMenu.navToShippingAddress();
		
		Thread.sleep(3000);
		
		int indexCountry = shippingPage.getIndexForCountryName("Canada");
		
		shippingPage.filterRegionByIndex(indexCountry);
		assertEquals(shippingPage.getTheCurrentSelectedRegion(), "Canada");	
	}
}
