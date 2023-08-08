package com.mbm.pages;

import org.openqa.selenium.By;

import com.mbm.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage{
	
	private final By dashboard = By.xpath("//span/h6[normalize-space()='Dashboard']");
	private final By userDropDown = By.xpath("//li[@class='oxd-userdropdown']");
	private final By logout = By.xpath("//a[normalize-space()='Logout']");
	
	
	public String verifyLogin() {
		return getText(dashboard,WaitStrategy.PRESENCE);
	}
	
	public OrangeHRMHomePage clickUserDropDown() {
		click(userDropDown,WaitStrategy.CLICKABLE,"User Dropdown");
		
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		click(logout,WaitStrategy.CLICKABLE,"Logout Button");
		return new OrangeHRMLoginPage();
	}
	
}
