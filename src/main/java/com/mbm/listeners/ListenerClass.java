package com.mbm.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mbm.annotations.FrameworkAnnotation;
import com.mbm.reports.ExtentLogger;
import com.mbm.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.createTest(result.getMethod().getDescription());

		ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
