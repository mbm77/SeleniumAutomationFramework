package com.mbm.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mbm.constants.FrameworkConstants;
import com.mbm.driver.DriverManager;
import com.mbm.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {
		
	}
	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.NONE) {
			DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
