package com.mbm.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mbm.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends Base {

	private OrangeHRMTests() {

	}

	@Test
	public void loginTest(Map<String, String> map) {
		String actualText = new OrangeHRMLoginPage().enterUsername(map.get("username"))
				.enterPassword(map.get("password")).clickLogin().verifyLogin();

		Assert.assertTrue(actualText.equalsIgnoreCase("dashboard"));
	}

	@Test
	public void logoutTest(Map<String, String> map) {
		String actualText = new OrangeHRMLoginPage().enterUsername(map.get("username"))
				.enterPassword(map.get("password")).clickLogin().clickUserDropDown().clickLogout().verifyLoginPage();

		Assert.assertTrue(actualText.equalsIgnoreCase("login"));
	}

	@DataProvider(name = "LoginDataProvider", parallel = true)
	public Object[][] loginData() {

		return new Object[][] { { "Admin", "admin123" }
				/*
				 * {"Admin","admin321"}, {"Admin","admin123"}, {"Admin","admin321"}
				 */
		};
	}
}
