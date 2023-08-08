package com.mbm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mbm.driver.DriverManager;
import com.mbm.enums.WaitStrategy;
import com.mbm.utils.DecodeUtils;

public final class OrangeHRMLoginPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

	private final By login = By.xpath("//h5[normalize-space()='Login']");
	private final By textboxUsername = By.name("username");
	private final By textboxPassword = By.xpath("//input[@type='password' and @name='password']");
	private final By subButton = By.xpath("//button[contains(@class,orangehrm-login-button)]");

	public String verifyLoginPage() {
		return getText(login, WaitStrategy.PRESENCE);
	}

	public OrangeHRMLoginPage enterUsername(String username) {
		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE, "Username");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "Password");
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		click(subButton, WaitStrategy.CLICKABLE,"Login Button");
		return new OrangeHRMHomePage();
	}
}
