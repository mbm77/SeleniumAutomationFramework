package com.mbm.dataprovider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class DataDrivenTestUsingJsonTest {

	@Test(dataProvider="jsonDataProvider2")
	public void dataDrivenTestUsingjson(LinkedHashMap<String,Object> map) {
		System.out.println(map);
	}
	
	//dependecies : jackson-databind and jackson-core
	@DataProvider
	public Object[] jsonDataProvider1() {
		try {
			HashMap<String,Object> map = new ObjectMapper()
			.readValue(new File(System.getProperty("user.dir")+"/src/test/resources/json/config.json"),
					new TypeReference<HashMap<String,Object>>(){});
			HashMap<String,Object> map2 = new ObjectMapper()
					.readValue(new File(System.getProperty("user.dir")+"/src/test/resources/json/config2.json"),
							new TypeReference<HashMap<String,Object>>(){});
			Object[] data = new Object[] {map,map2};
			return data;
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//dependencies : commom-io and json-path 
	@DataProvider
	public Object[] jsonDataProvider2() {
		try {
			String jsonData = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/test/resources/json/config3.json"),"UTF-8");
			JSONArray jsonArray = JsonPath.read(jsonData, "$");
			
			Object[] data = new Object[jsonArray.size()];
			for(int i=0;i<jsonArray.size();i++) {
				data[i] = jsonArray.get(i);
			}
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
