package com.mbm.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager() {
		
	}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	
	static void setExtentTest(ExtentTest extentTest) {
		extTest.set(extentTest);
	}
	
	public static ExtentTest getExtentTest() {
		return extTest.get();
	}
	
	static void unload() {
		extTest.remove();
	}
}
