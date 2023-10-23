package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.driver.DriverFactory;

public class NewsPage extends BasePage {

	@FindBy(xpath = "//h1[text()='News']")
	private WebElement newsText;

	@FindBy(xpath = "(//span[@class='js-headline-text'])[1]")
	private WebElement firstNewsArticle;

	private NewsPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public boolean isNewsTextDisplayed() {
		return super.isElementDisplayed(newsText, "News Text");
	}

	public String getFirstNewsTitle() {
		return super.getText(firstNewsArticle, "First News Article");
	}

	private static NewsPage instance;

	public static NewsPage getInstance() {
		synchronized (NewsPage.class) {

			if (instance == null) {
				instance = new NewsPage();
			}
		}
		return instance;
	}

}
