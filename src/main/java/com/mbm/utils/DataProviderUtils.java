package com.mbm.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.mbm.constants.FrameworkConstants;

public class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();
	
	private DataProviderUtils() {

	}

	@DataProvider(parallel=true)
	public static Object[] getData(Method m) {
		
		String testName = m.getName();
		
		if (list.isEmpty()) {
			list = ExcelUtils.getDataFromExcel(FrameworkConstants.getIterationdatasheet());
		}

		List<Map<String, String>> simpleList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testName)) {
				if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
					simpleList.add(list.get(i));
				}
			}
		}
		return simpleList.toArray();
	}
}
