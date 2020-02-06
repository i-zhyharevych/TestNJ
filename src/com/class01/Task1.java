package com.class01;

import org.testng.annotations.*;

public class Task1 {

	@BeforeClass
	public void bClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public void aClass() {
		System.out.println("After class");
	}
	
	@BeforeMethod
	public void bMethod() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void aMethod() {
		System.out.println("After Method");
	}
	
	@Test
	public void test1() {
		System.out.println("I am first test");
	}
	
	@Test
	public void test2() {
		System.out.println("I am second Test");
	}
	
}
