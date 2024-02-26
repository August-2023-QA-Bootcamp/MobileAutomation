package util;

import java.io.IOException;
import java.util.Properties;

import constant.CapsKey;
import constant.CommonKey;

public class Configuration {

	private Properties properties;
	private String fileName;
	
	/**
	 * Based on Type properties will load
	 * @param type
	 */
	public Configuration(Type type) {
		switch (type) {
		case COMMON:
			fileName = "config.properties";
			break;
		case DESIRE_CAPS:
			fileName = "caps.properties";
			break;
		default:
			fileName = "config.properties";
			break;
		}
		loadProperties();
	}
	
	/*
	 * create a properties object
	 * create a method to initialize properties
	 * load with the filename using inputstream
	 * 
	 * get(Key ) - create 2 constant enum of Keys in both config files
	 * this method will return the value related to the key
	 */
	
	/**
	 * Load Properties will initialize the Properties object
	 * using resorceAsStream from getClass
	 */
	private void loadProperties() {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(getFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * File that has been used to initialize the configuration object
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}
	
	public String get(CommonKey key) {
		return properties.getProperty(key.getValue());
	}
	
	public String get(CapsKey key) {
		return properties.getProperty(key.getValue());
	}
	
	public enum Type
	{
		COMMON, DESIRE_CAPS
	}
}
