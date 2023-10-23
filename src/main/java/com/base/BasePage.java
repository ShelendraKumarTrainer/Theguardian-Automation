package com.base;

import java.text.MessageFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.waits.ExplicitWaitActions;

public class BasePage {

	private Logger logger = LogManager.getLogger(BasePage.class);

	private ExplicitWaitActions explicitWaitActions;

	protected BasePage() {

		if (explicitWaitActions == null) {
			explicitWaitActions = new ExplicitWaitActions();
		}

	}

	public void click(WebElement element, String elementName) {

		explicitWaitActions.waitForElementToBeClickable(element, elementName);
		element.click();
		logger.info(elementName + "is clicked.");

	}

	public void sendKeys(WebElement element, String elementName, String value) {

		explicitWaitActions.waitForElementToBePresent(element, elementName);
		element.clear();
		logger.info(elementName + "is cleared.");
		element.sendKeys(value);
		logger.info(MessageFormat.format("{0} value is entered in {1}", elementName, value));
	}

	public void pressKey(WebElement element, String elementName, Keys key) {

		explicitWaitActions.waitForElementToBePresent(element, elementName);
		element.sendKeys(key);
		logger.info(MessageFormat.format("[{0}] key is Pressed", key.name()));

	}

	public boolean isElementSelected(WebElement element, String elementName) {

		explicitWaitActions.waitForElementToBePresent(element, elementName);
		boolean status = element.isSelected();
		logger.info(MessageFormat.format("[{0}] isSelected status is [{1}]", elementName, status));
		return status;

	}

	public boolean isElementDisplayed(WebElement element, String elementName) {

		explicitWaitActions.waitForElementToBePresent(element, elementName);
		boolean status = element.isDisplayed();
		logger.info(MessageFormat.format("[{0}] isDisplayed status is [{1}]", elementName, status));
		return status;

	}

	public String getText(WebElement element, String elementName) {

		explicitWaitActions.waitForElementToBePresent(element, elementName);
		String text = element.getText();
		logger.info(MessageFormat.format("[{0}] is a text value of [{1}]", text, elementName));
		return text;
	}

}
