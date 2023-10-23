package com.base;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.constants.Constants;
import com.driver.BrowserFactory;
import com.driver.DriverFactory;
import com.properties.ConfigLoader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseTest {

	private static Logger logger = LogManager.getLogger(BaseTest.class);

	@Before
	public static void setUP() {

		WebDriver driver = BrowserFactory.createBrowserInstance(ConfigLoader.getInstnace().getPropertyValue(Constants.BROWSER));
		logger.info("Driver is created");
		DriverFactory.getInstance().setDriver(driver);
		logger.info("Driver object is added to Driver thread pool.");
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		logger.info("Browser is maximized");

	}

	@AfterStep
	public void takeScreenShotAfterStep(Scenario scenario) {

		scenario.attach(getByteScreenshot(), "image/jpg", scenario.getName());
	}

	@After
	public static void tearDown() {
		DriverFactory.getInstance().getDriver().quit();
		logger.info("Browser is closed");
	}

	public byte[] getByteScreenshot() {
		File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(src);
		} catch (IOException e) {
			logger.error(MessageFormat.format("Exception {0} occured while reader config file", e.getMessage()));

		}

		return fileContent;
	}

}
