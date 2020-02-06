package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW extends CommonMethods {
	@BeforeMethod(alwaysRun=true)
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@AfterMethod(alwaysRun=true)
	public void close() {
		driver.close();
	}

	@Test(priority=2, dependsOnMethods = {"validationOfMessage"}, enabled=false, groups = "regression")
	public void validationOfLogo() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		boolean isTrue = driver.findElement(By.xpath("//img[contains(@src,'syntax.png')]")).isDisplayed();
		if (isTrue) {
			System.out.println("Logo is dislayed");
		} else {
			System.out.println("Logo is NOT displayed");
		}
	}

	@Test(priority=1)
	public void validationOfMessage() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		WebElement errorMessage = driver.findElement(By.id("spanMessage"));
		String expectedError = "Password cannot be empty";
		// boolean message=driver.findElement(By.id("spanMessage")).isDisplayed();
		if (errorMessage.isDisplayed()) {
			System.out.println("error is dislayed");
			if (errorMessage.getText().equals(expectedError)) {
				System.out.println("Error message is correct.Pass");
			} else {
				System.out.println("Error message is NOT correct.Fail");
			}
		} else {
			System.out.println("message is NOT displayed");
		}
	}
}
