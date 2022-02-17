package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.SingleAutorPage;
import utils.BaseTest;

public class Homework7 extends BaseTest {
		
	@Test
	public void checkValues() throws InterruptedException {
		
		SingleAutorPage singleAuthorPage = navMenu.navToSingleAuthor();
		
		Thread.sleep(5000);

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(singleAuthorPage.getSkillValue("Drama"), "95%");
		sa.assertEquals(singleAuthorPage.getSkillValue("Biography"), "75%");
		sa.assertEquals(singleAuthorPage.getSkillValue("Cookbooks"), "82%");
		sa.assertAll();
	}
}
