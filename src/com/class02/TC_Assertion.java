package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TC_Assertion extends CommonMethods{

	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@Test
	public void validationOfLogo() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		boolean isDisplayed = driver.findElement(By.xpath("//img[contains(@src,'syntax.png')]")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Syntax logo is displayed");
	}

	@Test(priority=1, enabled=false)
	public void validationOfMessage() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		WebElement errorMessage = driver.findElement(By.id("spanMessage"));
		String actualMessage = errorMessage.getText();
		String expectedError = "Password cannot be empty";
		
		Assert.assertEquals(actualMessage, expectedError, "Message is displayed");
	}
}
