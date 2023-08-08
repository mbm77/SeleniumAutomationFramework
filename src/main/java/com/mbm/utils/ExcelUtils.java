package com.mbm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mbm.constants.FrameworkConstants;
import com.mbm.exceptions.FrameworkException;
import com.mbm.exceptions.InvalidPathForExcelException;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getDataFromExcel(String sheetname) {
		List<Map<String, String>> list = null;
		try (FileInputStream fis = new FileInputStream(new File(FrameworkConstants.getExcelpath()));
				XSSFWorkbook workbook = new XSSFWorkbook(fis);) {
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			Map<String, String> map = null;
			list = new ArrayList<>();
			for (int i = 1; i <= rows; i++) {
				map = new HashMap<>();
				for (int j = 0; j < cols; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					DataFormatter formatter = new DataFormatter();
					String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidPathForExcelException("Excel file you trying to read is not found");
		} catch (IOException e) {
			throw new FrameworkException("Some IO Exception happened while reading excel file");
		}
		return list;
	}
}
