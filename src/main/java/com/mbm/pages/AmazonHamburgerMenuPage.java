package com.mbm.pages;

import org.openqa.selenium.By;

import com.mbm.enums.WaitStrategy;
import com.mbm.utils.DynamicXpathUtils;

public class AmazonHamburgerMenuPage extends BasePage {
	
	private String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";
	private String linkSubMenu = "//a[text()='%s']";
	
	public AmazonHamburgerMenuPage clickComputer() {
		click(By.xpath(linkComputers), WaitStrategy.CLICKABLE, "Mobile and Computers");
		return this;
	}

	public AmazonLaptopPage clickOnSubMenuItemLaptop(String menutext) {
		String newxpath = DynamicXpathUtils.getXpath(linkSubMenu, menutext);
		actionClick(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);

		if(menutext.contains("Laptops")) {
			 return new AmazonLaptopPage();
		 }
		
		 return null;
	}
	
	public AmazonAllMobilePhonesPage clickOnSubMenuItemAllMobilePhones(String menutext) {
		String newxpath = DynamicXpathUtils.getXpath(linkSubMenu, menutext);
		actionClick(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);
		 
		if(menutext.contains("All Mobile Phones")) {
			 return new AmazonAllMobilePhonesPage();
		 }
		
		 return null;
	}
	
	


}
