package com.mbm.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbm.constants.FrameworkConstants;
import com.mbm.enums.ConfigProperties;

public final class ReadJSONConfigFile {
	
	

	private ReadJSONConfigFile() {

	}
		private static Map<String,String> configMap ;
		
	static {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			configMap = objectMapper.readValue(new File(FrameworkConstants.getJsonConfigFilePath()),
					new TypeReference<HashMap<String,String>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}  

	}

	public static String getValue(ConfigProperties key) {
		if (Objects.isNull(configMap.get(key.name().toLowerCase())) || Objects.isNull(key.name().toLowerCase())) {
			throw new NullPointerException("Property name " + key + " is not found. please check config.properties");
		}
		return configMap.get(key.name().toLowerCase());
	}
}
