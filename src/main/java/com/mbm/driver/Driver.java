package com.mbm.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mbm.constants.FrameworkConstants;
import com.mbm.enums.ConfigProperties;
import com.mbm.utils.ReadPropertyFile;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
				DriverManager.setDriver(new ChromeDriver());
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
				DriverManager.setDriver(new FirefoxDriver());
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
