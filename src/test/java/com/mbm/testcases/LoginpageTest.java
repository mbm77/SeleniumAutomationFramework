package com.mbm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.mbm.driver.DriverManager;

public final class LoginpageTest extends Base {
	
	private LoginpageTest() {
		
	}

	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
	}

	

}
