package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {
	
	
	NavMenuPage navMenu; 
	LoginPage loginPage;
	@Parameters({"user", "pass"})
	@Test(priority =1)
	public void loginTest(String user, String pass) throws InterruptedException {
		
		navMenu =  new NavMenuPage(driver);
		loginPage =  new LoginPage(driver);
		
		navMenu.navigateTo(navMenu.loginLink);
		loginPage.loginInApp(user, pass);
		assertTrue(loginPage.logoutButton.isDisplayed());
		loginPage.logoutFromApp();

	}
	
	@Test(priority =2)
	public void invalidLoginTest() throws InterruptedException {
		
		//navMenu =  new NavMenuPage(driver);
		//loginPage =  new LoginPage(driver);
		
		navMenu.navigateTo(navMenu.loginLink);
		loginPage.loginInApp("1235", "12345");
		assertTrue(loginPage.popupFailed.isDisplayed());

	}
	

}