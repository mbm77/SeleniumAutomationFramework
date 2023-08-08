package com.mbm.pages;

import org.openqa.selenium.By;

import com.mbm.enums.WaitStrategy;

public final class AmazonHomePage extends BasePage{
	
	private final By hamburgerMenu = By.id("nav-hamburger-menu");
	
	public AmazonHamburgerMenuPage clickHamburger(){
		click(hamburgerMenu, WaitStrategy.CLICKABLE,"Hamburger Button");
		return new AmazonHamburgerMenuPage();
	}
}
