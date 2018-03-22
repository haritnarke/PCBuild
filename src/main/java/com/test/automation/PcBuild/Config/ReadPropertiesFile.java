package com.test.automation.PcBuild.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public String PropertiesValue(String key) throws IOException {

		File src = new File(
				"C:\\Users\\madhav\\eclipse-workspace\\PcBuild\\src\\main\\java\\com\\test\\automation\\PcBuild\\DataFolder\\config.properties");

		FileInputStream fileInput = null;
		fileInput = new FileInputStream(src);

		Properties prop = new Properties();
		prop.load(fileInput);
		String value = prop.getProperty(key);
		return value;

	}
}
