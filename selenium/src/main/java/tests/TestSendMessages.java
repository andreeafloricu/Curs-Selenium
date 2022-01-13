package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.ContactPage;
import utils.BaseTest;

public class TestSendMessages extends BaseTest {
	
	ContactPage contactPage;
	
	@Test
	public void sendMessageReturnsSuccess() {
		contactPage = navMenu.navToContact();
		contactPage.sendMessage("Test", "test@test.com", "Test subject", "Test message");
		assertTrue(contactPage.returnMessageSentInfo("Thank you for your message. It has been sent."));	
	}
	
	@Test
	public void sendMessageWithoutNameReturnsFalse() {
		contactPage = navMenu.navToContact();
		contactPage.sendMessage("", "test@test.com", "Test subject", "Test message");
		assertTrue(contactPage.emptyFieldWarningMessage());
		assertTrue(contactPage.returnMessageSentInfo("One or more fields have an error. Please check and try again."));	
	}
	
	@Test
	public void sendMessageWithoutEmailReturnsFalse() {
		contactPage = navMenu.navToContact();
		contactPage.sendMessage("Test", "", "Test subject", "Test message");
		assertTrue(contactPage.emptyFieldWarningMessage());
		assertTrue(contactPage.returnMessageSentInfo("One or more fields have an error. Please check and try again."));	
	}
}