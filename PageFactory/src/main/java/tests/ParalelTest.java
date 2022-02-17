package tests;

import org.testng.annotations.Test;

import utils.BaseTest;

public class ParalelTest extends BaseTest {
	
	
	@Test
	public void testMethodOne() throws InterruptedException {
		
		long id = Thread.currentThread().getId();
		System.out.println("testMethodOne --> Thread id : " + id);
		driver.get("https://keyfood.ro");
		Thread.sleep(5000);
		System.out.println("testMethodOne --> Current url :" +driver.getCurrentUrl());		
		
	}
	
}