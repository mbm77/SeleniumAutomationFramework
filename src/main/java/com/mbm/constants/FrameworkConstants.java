package com.mbm.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mbm.enums.ConfigProperties;
import com.mbm.utils.ReadPropertyFile;

public final class FrameworkConstants {
	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final String JSONCONFIGFILEPATH = RESOURCESPATH + "/config/config.json";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static final String EXCELPATH = RESOURCESPATH+"/excel/testdata.xlsx";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	private static String date = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss").format(new Date());

	private static final int EXPLICITWAIT = 20;

	private FrameworkConstants() {

	}
	
	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH;
	}
	
	
	
	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}
	
	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}
	
	public static String getExcelpath() {
		return EXCELPATH;
	}
	
	public static String getJsonConfigFilePath() {
		return JSONCONFIGFILEPATH;
	}

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getExtentReportFilePath() {
		if (ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return EXTENTREPORTFOLDERPATH + "index.html";
		} else {
			return EXTENTREPORTFOLDERPATH +date+ "/index.html";
		}

	}
}
