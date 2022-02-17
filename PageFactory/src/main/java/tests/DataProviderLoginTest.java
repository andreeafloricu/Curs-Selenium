package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseTest;

public class DataProviderLoginTest extends BaseTest {
	
	@DataProvider(name = "loginTestData")
	public Object[][] loginTestData() {
		Object[][] data = new Object[4][3]; //2 seturi de date, fiecare set de date va avea doua campuri, unu user, unu parola
		
		data[0][0] = "TestUser";
		data[0][1] = "12345@67890";
		data[0][2] = true;
		
		data[1][0] = "UserGresit";
		data[1][1] = "00000";
		data[1][2] = false;
		
		data[2][0] = "test.test";
		data[2][1] = "test.test@123";
		data[2][2] = true;
		
		data[3][0] = "AltUserGresit";
		data[3][1] = "1111111";
		data[3][2] = false;

		return data;
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTests(String username, String password, Boolean success) throws InterruptedException {
		page.navMenu.navigateTo(page.navMenu.loginLink);
		page.loginPage.loginInApp(username, password);
		if(success) {
			assertEquals(page.loginPage.popupSucces.isDisplayed(), true);
			page.loginPage.logoutFromApp();
		} else {
			Thread.sleep(2000);
			assertEquals(page.loginPage.popupFailed.isDisplayed(), true);
			page.loginPage.closeLoginButton.click();
		}	
		Thread.sleep(4000);
	}
}
