package tests;

import org.testng.annotations.Test;

import utils.BaseTest;

public class AnotherParalelTest extends BaseTest{
	
	
	@Test
	public void testMethodTwo() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println("testMethodTwo ---> Thread id : " + id);
		driver.get("https://altex.ro");
		Thread.sleep(5000);
		System.out.println("testMethodTwo --> Current url : "+driver.getCurrentUrl());
		
		
	}
}