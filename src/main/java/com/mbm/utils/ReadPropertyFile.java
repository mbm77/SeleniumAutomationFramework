package com.mbm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.mbm.constants.FrameworkConstants;
import com.mbm.enums.ConfigProperties;
import com.mbm.exceptions.PropertyFileUsageException;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties pro = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
			pro.load(fis);
			for (Map.Entry<Object, Object> entry : pro.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	public static String getValue(ConfigProperties key) {
		if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key.name().toLowerCase())) {
			throw new PropertyFileUsageException(
					"Property name " + key + " is not found. please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
