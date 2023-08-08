package com.mbm.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mbm.enums.ConfigProperties;
import com.mbm.utils.ReadPropertyFile;
import com.mbm.utils.ScreenshotUtils;

public class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void pass(String message, boolean isScreenshotNeeded) {
		if (ReadPropertyFile.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message, boolean isScreenshotNeeded) {
		if (ReadPropertyFile.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	
	public static void skip(String message, boolean isScreenshotNeeded) {
		if (ReadPropertyFile.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}

	

}
