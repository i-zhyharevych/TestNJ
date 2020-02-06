package com.class01;

import org.testng.annotations.Test;

public class TestNGDemo {

	@Test
	public void testOne() {
		System.out.println("hello");
	}
	
	@Test
	public void secondTest() {
		System.out.println("Heloo from test 2");
	}
	
	@Test
	public void pass() {
		System.out.println("hello from test 3");
	}
}
