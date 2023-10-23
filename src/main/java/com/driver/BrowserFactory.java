package com.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Constants;

public class BrowserFactory {

	private static Logger logger = LogManager.getLogger(BrowserFactory.class);

	public static WebDriver createBrowserInstance(String browserName) {

		WebDriver driver = null;
		logger.info("Browser name to create driver object is " + browserName);
		if (browserName.equalsIgnoreCase(Constants.CHROME)) {
			driver = new ChromeDriver();
			logger.info("Chrome Browser is launched");
		}

		else if (browserName.equalsIgnoreCase(Constants.FIREFOX)) {
			driver = new FirefoxDriver();
			logger.info("Firefox browser is launched.");
		}

		return driver;
	}

}
