package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TC_VerifyAddedEmployee extends CommonMethods {

	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test
	public void addEmployee() {
		//log in
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		// navigate to add employee
		driver.findElement(By.linkText("PIM")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee")));

		driver.findElement(By.linkText("Add Employee")).click();
		
		//verify  labels
		boolean fullName = driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']")).isDisplayed();
		boolean eID = driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
		boolean photo = driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
		
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(fullName, "Full name label was not displayed");
		softAssert.assertTrue(eID, "Employee ID wa not displayed");
		softAssert.assertTrue(photo, "Photofraph wa not displayed");

		//add first and last name,
		driver.findElement(By.id("firstName")).sendKeys("TestName");
		driver.findElement(By.id("lastName")).sendKeys("TestLastName");
		
		// upload picture, click save
		driver.findElement(By.id("photofile")).sendKeys("/Users/ivankazhyharevych/Desktop/img.png");
		driver.findElement(By.id("btnSave")).click();
		
		//verify if user was added successfully
		boolean verification = driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed();
		softAssert.assertTrue(verification, "Employee was not added");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
