package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;

	public static Properties initProperties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			throw new RuntimeException("failed to load config file");
		}
		return prop;
	}

	public static String getProperty(String key) {
		if (prop == null) {
			initProperties();
		}
		return prop.getProperty(key);
	}
}
