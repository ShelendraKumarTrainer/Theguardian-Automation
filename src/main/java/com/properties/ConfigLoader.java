package com.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Constants;

public class ConfigLoader {

	private Logger logger = LogManager.getLogger(ConfigLoader.class);

	private Properties prop;

	private ConfigLoader() {
		FileReader reader = null;
		try {
			reader = new FileReader(Constants.CONFIG_FILE_PATH);
		} catch (FileNotFoundException e) {
			logger.error(MessageFormat.format("Exception {0} occured while reader config file", e.getMessage()));

		}

		prop = new Properties();

		try {
			prop.load(reader);
		} catch (IOException e) {
			logger.error(MessageFormat.format("Exception {0} occured while reader config file", e.getMessage()));

		}

	}

	private static ConfigLoader instance;

	public static ConfigLoader getInstnace() {
		synchronized (ConfigLoader.class) {
			instance = new ConfigLoader();
		}
		return instance;
	}

	public String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

}
