package curs2;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class DependencyExample {
	
	@Test
	public void method1() {
		assertTrue(false);
		System.out.println("Method 1");
	}
	
	@Test(dependsOnMethods = "method1")
	public void method2() {
		System.out.println("Method 2");
	}
	
	@Test(alwaysRun = true)
	public void method3() {
		System.out.println("Method 3");
	}

}
