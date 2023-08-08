package com.mbm.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.mbm.enums.ConfigProperties;
import com.mbm.utils.ReadPropertyFile;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (ReadPropertyFile.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			if (count < retries) {
				count++;
				return true;
			}

		}
		return false;
	}

}
