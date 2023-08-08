package com.mbm.testcases;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mbm.driver.Driver;

public class Base {

	protected Base() {

	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {
		Map<String, String> map = (Map<String, String>) data[0];
		Driver.initDriver(map.get("browser"));

	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
