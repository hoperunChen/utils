package com.luckyrui.platform.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
	public static final String DEFAULT_PATH = "/config.properties";

	Properties prop = null;

	public PropertiesHandler() {
		init(null);
	}

	public PropertiesHandler(String path) {
		init(path);
	}

	private void init(String path) {
		prop = new Properties();
		if (null == path || path.isEmpty())
			path = DEFAULT_PATH;
		InputStream in = Object.class.getResourceAsStream(path);
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String get(String paramName) {
		String paramValue = "";
		paramValue = prop.getProperty(paramName).trim();
		return paramValue;
	}

}
