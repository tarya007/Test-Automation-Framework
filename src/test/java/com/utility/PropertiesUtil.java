package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.ENV;

public class PropertiesUtil {
	public static String readProperties(ENV env, String propertyName) {
		File propFile = new File(System.getProperty("user.dir")+"\\config\\" + env + ".properties");
		FileReader filereader = null;
		Properties properties = new Properties();
		try {
			filereader = new FileReader(propFile);
			properties.load(filereader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		 
		String value = properties.getProperty(propertyName.toUpperCase());
		return value;
	}

}
