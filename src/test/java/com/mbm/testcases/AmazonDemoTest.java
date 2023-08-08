package com.mbm.testcases;

import java.util.Map;
import java.util.Objects;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mbm.annotations.FrameworkAnnotation;
import com.mbm.enums.CategoryType;
import com.mbm.pages.AmazonHomePage;

public final class AmazonDemoTest extends Base{
	
	private AmazonDemoTest() {
		
	}
	
	@FrameworkAnnotation(author={"mbm","amuthan"},category= {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	@Test
	public void amazonTestLaptops(Map<String,String> map) {
	/*	ExtentManager.getExtentTest().assignAuthor("mbm")
									 .assignAuthor("amuthan")
									 .assignCategory("smoke")
									 .assignCategory("Regression"); */
		
		String title = new AmazonHomePage()
				.clickHamburger().clickComputer()
				.clickOnSubMenuItemLaptop(map.get("menutext")).getTitle();
		Assert.assertTrue(Objects.nonNull(title));
		
	}
	
	@FrameworkAnnotation(author={"mbm","amuthan"},category= {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	@Test
	public void amazonTestMobiles(Map<String,String> map) {
		String title = new AmazonHomePage()
				.clickHamburger().clickComputer()
				.clickOnSubMenuItemAllMobilePhones(map.get("menutext")).getTitle();
		Assert.assertTrue(Objects.nonNull(title));
		
	}

}
