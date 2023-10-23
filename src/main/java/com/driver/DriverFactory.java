package com.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private DriverFactory() {

	}

	private static DriverFactory instance;

	public static DriverFactory getInstance() {
		synchronized (DriverFactory.class) {
			if (instance == null) {
				instance = new DriverFactory();
			}
		}
		return instance;
	}

	public void setDriver(WebDriver driverObj) {
		driver.set(driverObj);

	}

	public WebDriver getDriver() {
		return driver.get();
	}

}
