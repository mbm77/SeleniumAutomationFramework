package com.mbm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.util.concurrent.Uninterruptibles;
import com.mbm.driver.DriverManager;
import  com.mbm.enums.LogType;
import com.mbm.enums.WaitStrategy;
import com.mbm.factories.ExplicitWaitFactory;
import com.mbm.reports.ConsoleLoggerImpl;
import com.mbm.reports.ExtentLogger;
import com.mbm.reports.ExtentLoggerImpl;
import static com.mbm.reports.FrameworkLogger.*;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
		element.click();
		//ExtentLogger.pass(elementname + " is clicked");
		//new ExtentLoggerImpl().log("pass", elementname+" is clicked");//java 7 way
		//new ConsoleLoggerImpl().log("pass", elementname+" is clicked");
		log(LogType.EXTENTANDCONSOLE, elementname+" is clicked --> java 8");
	}
	
	protected void actionClick(By by, WaitStrategy waitStrategy, String elementname) {
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		actions.moveToElement(element).click().perform();
		//ExtentLogger.pass(elementname + " is clicked");
		//new ExtentLoggerImpl().log("pass", (elementname+" is clicked"));//java 7 way
		//new ConsoleLoggerImpl().log("pass", (elementname+" is clicked"));
		log(LogType.EXTENTANDCONSOLE, elementname+" is clicked --> java 8");
	}
	
	protected void jsClick(By by, WaitStrategy waitStrategy, String elementname) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		js.executeScript("arguments[0].click()", element);
		ExtentLogger.pass(elementname + " is clicked");
	}
	
	protected void scrollToElementClick(By by, WaitStrategy waitStrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		
		Rectangle rect = element.getRect();
		int deltaY = rect.y + rect.height;
		new Actions(DriverManager.getDriver())
		.scrollByAmount(0, deltaY)
		.perform();
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
		element.click();
		ExtentLogger.pass(elementname + " is clicked");
		new ExtentLoggerImpl().log("pass", elementname+" is clicked");//java 7 way
		new ConsoleLoggerImpl().log("pass", elementname+" is clicked");
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value + " is entered successfully in " + elementname);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected String getText(By by, WaitStrategy waitStrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		return element.getText();
	}

}
