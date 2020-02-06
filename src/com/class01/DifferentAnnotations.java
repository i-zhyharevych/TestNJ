package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DifferentAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@AfterTest
	public  void afterTest() {
		System.out.println("after test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public  void afterMethod() {
		System.out.println("after method");
	}
	
	@Test
	public void test() {
		System.out.println("I am acrual test");
	}
}
