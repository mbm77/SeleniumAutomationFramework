package com.mbm.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mbm.constants.FrameworkConstants;
import com.mbm.enums.CategoryType;

public class ExtentReport {

	private static ExtentReports extentReports;

	private ExtentReport() {

	}

	public static void initReport() {
		if (Objects.isNull(extentReports)) {
			extentReports = new ExtentReports();
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
					FrameworkConstants.getExtentReportFilePath());
			extentReports.attachReporter(extentSparkReporter);
			extentSparkReporter.config().setTheme(Theme.DARK);
			extentSparkReporter.config().setDocumentTitle("Automation Report");
			extentSparkReporter.config().setDocumentTitle("Test Report");
		}

	}

	public static void flushReport() {
		if (Objects.nonNull(extentReports)) {
			extentReports.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {

		ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
	}

	public static void addAuthor(String[] authors) {
		for (String temp : authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}

	public static void addCategory(CategoryType[] categories) {
		for (CategoryType temp : categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
}
