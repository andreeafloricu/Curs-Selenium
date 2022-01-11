package curs2;

import org.testng.annotations.Test;

public class PriorityExample {
	
	@Test(priority = 0)
	public void one() {
		System.out.println("First");
	}

	@Test(priority = 1)
	public void two() {
		System.out.println("Second");
	}
	
	@Test(priority = 2)
	public void three() {
		System.out.println("Third");
	}
	
	@Test
	public void fourth() {
		System.out.println("Fourth");
	}
	
	@Test
	public void fifth() {
		System.out.println("Fifth");
	}
}
