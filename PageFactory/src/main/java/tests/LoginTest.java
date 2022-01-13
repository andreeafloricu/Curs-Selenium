package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {
	
	NavMenuPage navMenu;
	LoginPage loginPage;
	
	@Test
	public void loginTest() {
		navMenu = new NavMenuPage(driver);
		loginPage = new LoginPage(driver);
		
		navMenu.navigateTo(navMenu.loginLink);
		loginPage.loginInApp();
		
		assertTrue(loginPage.logoutButton.isDisplayed());
	}
}