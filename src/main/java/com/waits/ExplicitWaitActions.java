package com.waits;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.driver.DriverFactory;

public class ExplicitWaitActions {

	private Logger logger = LogManager.getLogger(ExplicitWaitActions.class);

	public void waitForElementToBePresent(WebElement element, String elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

			wait.until(ExpectedConditions.visibilityOf(element));

			logger.info(elementName + " is available on screen");
		} catch (Exception e) {
			logger.error("Exception occured while waiting for the element to be visible " + e.getMessage());

		}

	}

	public void waitForElementToBeClickable(WebElement element, String elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

			wait.until(ExpectedConditions.elementToBeClickable(element));

			logger.info(elementName + " is clickable on screen");
		} catch (Exception e) {
			logger.error("Exception occured while waiting for the element to be clickable " + e.getMessage());

		}

	}

}
