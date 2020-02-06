package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AssertionsDemo extends CommonMethods{

	@BeforeMethod(alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}



	@Test(groups="regression")
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Titles are match");
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("test pass");
		} else {
			System.out.println("test fails");
		}
	}

	@Test(enabled=true, groups="regression")
	public void logoValidation() {
		boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		//isDisplayed=false;
		Assert.assertTrue(isDisplayed, "Syntax logo is displayed");
//		if (isDisplayed) {
//			System.out.println("test pass");
//		} else {
//			System.out.println("test fails");
//		}
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
}
