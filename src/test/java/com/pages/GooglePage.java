package com.pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;
import com.driver.DriverFactory;

public class GooglePage extends BasePage {

	@FindBy(name = "q")
	private WebElement searchTextBox;

	@FindBy(xpath = "//iframe[@role= 'presentation']")
	private WebElement staySignOutFrame;

	@FindBy(xpath = "//button[text()='Stay signed out']")
	private WebElement staySignOutBtn;

	@FindBy(xpath = "//a/h3")
	private List<WebElement> seachResults;

	private GooglePage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	private static GooglePage instance;

	public static GooglePage getInstance() {
		synchronized (GooglePage.class) {

			if (instance == null) {
				instance = new GooglePage();
			}
		}
		return instance;
	}

	public void searchNewsArticle(String searchText) {
		DriverFactory.getInstance().getDriver().switchTo().frame(staySignOutFrame);
		super.click(staySignOutBtn, "Stay Signout Btn");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		super.sendKeys(searchTextBox, "Search Text Box", searchText);
		super.pressKey(searchTextBox, "Search Text Box", Keys.ENTER);

	}

	public boolean isSearchResultsMatched(String text) {

		byte count = 0;
		boolean result = false;
		for (WebElement element : seachResults) {
			String title = element.getText();

			if (title.contains(text)) {
				count++;
			}
		}

		if (count >= 2) {
			result = true;
		}

		return result;
	}

}
