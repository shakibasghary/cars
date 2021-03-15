package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Base {
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private String projectPropertyFilePath = ".\\src\\test\\resources\\InputData\\projectProp.properties";
	private String log4JFilePath = ".\\src\\test\\resources\\InputData\\log4j.properties";

	public Base() {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(projectPropertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		logger = Logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4JFilePath);
	}

	/**
	 * This method will return value of browser name on projectProp.properties file
	 * such as chrome, firefox, ie, and headless browser
	 * 
	 * @return
	 */
	public static String getBrowserName() {
		String browserName = properties.getProperty("browser");
		return browserName;
	}

	/**
	 * This method will return url of the application we use for this Framework from
	 * projectProp.properties file
	 * 
	 * @return
	 */
	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	/**
	 * This method will return implicitly wait time and parse it into the long data
	 * type as Implicitly Wait method in selenium accepts long dataType.
	 * 
	 * @return
	 */

	public static Long getImpWait() {
		String imptWait = properties.getProperty("implicitlyWait");
		return Long.parseLong(imptWait);
	}

	/**
	 * This method will return pageLoadTimeOut method and parse it's value from
	 * string into long as pageLoadTimeOut only accepts long datatype in selenium
	 * 
	 * @return
	 */
	public static Long getPageLoadTimeOut() {
		String pageLTimeOut = properties.getProperty("pageLoadTimeOut");
		return Long.parseLong(pageLTimeOut);
	}

	/**
	 * This method will initialize the webdriver whenever we call it.
	 */
	public static void initializeDriver() {
		driver.get(getURL());
	}
	
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
