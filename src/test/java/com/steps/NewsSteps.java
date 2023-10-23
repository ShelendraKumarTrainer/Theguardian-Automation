package com.steps;

import org.testng.Assert;
import com.driver.DriverFactory;
import com.pages.GooglePage;
import com.pages.NewsPage;
import com.properties.ConfigLoader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewsSteps {

	private String newsTitle;

	@When("User enters application url.")
	public void user_enters_application_url() {
		DriverFactory.getInstance().getDriver().get(ConfigLoader.getInstnace().getPropertyValue("app_url"));
	}

	@Then("News Page is launched.")
	public void news_page_is_launched() {

		Assert.assertTrue(NewsPage.getInstance().isNewsTextDisplayed());
	}

	@When("User copy the First News Title")
	public void user_copy_the_first_news_title() {
		newsTitle = NewsPage.getInstance().getFirstNewsTitle();
	}

	@When("User Searches that Artical in Google search Engine")
	public void user_searches_that_artical_in_google_search_engine() {
		DriverFactory.getInstance().getDriver().get(ConfigLoader.getInstnace().getPropertyValue("google_url"));
	}

	@Then("Two or more articles should be displayed.")
	public void two_or_more_articles_should_be_displayed() {

		GooglePage.getInstance().searchNewsArticle(newsTitle);

		Assert.assertTrue(GooglePage.getInstance().isSearchResultsMatched(newsTitle.split(" ")[0]));

	}


}
