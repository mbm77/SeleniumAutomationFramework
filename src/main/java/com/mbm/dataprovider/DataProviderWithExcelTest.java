package com.mbm.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mbm.constants.FrameworkConstants;


public class DataProviderWithExcelTest {

	@Test(dataProvider = "excelDataProvider1")
	public void test1(String username, String password, String fname, String lname) {
		System.out.println(username + " " + password + " " + " " + fname + " " + lname);
	}
	
	@Test(dataProvider = "excelDataProvider2")
	public void test2(Map<String,String> map) {
		System.out.println(map.get("username")+" "+map.get("password"));
	}

	@DataProvider
	public Object[][] excelDataProvider1() {
		
		Object[][] data = null;
		try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/excel/testdata.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);) {
			
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			data = new Object[rows][cols];
			for (int i = 1; i <= rows; i++) {
				for (int j = 0; j < cols; j++) {
					data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}  
		return data;
	}
	
	@DataProvider
	public Object[] excelDataProvider2() {
		
		
		Object[] data = null;
		try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/excel/testdata.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);) {
			XSSFSheet sheet = workbook.getSheet(FrameworkConstants.getIterationdatasheet());
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			Map<String, String> map = null;
			data = new Object[rows];
			for (int i = 1; i <= rows; i++) {
				map = new HashMap<>();
				for (int j = 0; j < cols; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i-1] = map;
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		return data;
	}
}
