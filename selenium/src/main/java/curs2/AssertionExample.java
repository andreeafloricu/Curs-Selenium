package curs2;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionExample {

	@Test
	public void softAssertion() {
		SoftAssert sa = new SoftAssert();
		System.out.println("Soft assert started here");
		sa.assertTrue(false);
		System.out.println("Soft assert ended here");
		sa.assertAll();
	}
	
	//@Test
	public void hardAssertion() {
		System.out.println("Hard assert started here");
		assertTrue(false);
		System.out.println("Hard assert ended here");	
	}
}
