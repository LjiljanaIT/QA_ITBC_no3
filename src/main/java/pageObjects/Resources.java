package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class Resources {
	private static Properties properties;
	private static Resources instance;

	static{
		try{
			instance = new Resources();
		}catch(Exception e){
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static Resources getInstance(){
		return instance;
	}

	private Resources() throws IOException {
		InputStream inputStream = null;
		properties = new Properties();
		String propFileName = "config.properties";
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}

	public static String get(String key){
		return properties.getProperty(key);
	};

	public static By getBy(String key){
		
		return new By.ByXPath(properties.getProperty(key));
	};

	// waiting for msec
	public static void waitFOR(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
