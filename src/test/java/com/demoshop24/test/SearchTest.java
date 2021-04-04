package com.demoshop24.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoshop24.pages.SearchPage;
import com.demoshop24.utility.TestUtil;

public class SearchTest extends BaseTest {
	@Test(description = "To verify search operation without search keyword")
	public void verifyEmptyKeywordSearch() {
		page.getInstance(SearchPage.class).performEmptySearchOperation();
		Assert.assertEquals(page.getInstance(SearchPage.class).searchNoFoundMessageText(),
				"There is no product that matches the search criteria.");
	}

	@Test(description = "To verify displayed search results", dataProvider = "getSearchTestData")
	public void verifySearchResults(String searchKeyword) {

		page.getInstance(SearchPage.class).performSearchOperation(searchKeyword);
		String searchResult = driver.findElement(By.linkText(searchKeyword)).getText();
		Assert.assertEquals(searchResult, searchKeyword);
	}

	@Test(description = "To verify displayed search criteria on results page", dataProvider = "getSearchTestData")
	public void verifySearchCriteriaResult(String searchKeyword) {
		page.getInstance(SearchPage.class).performSearchOperation(searchKeyword);
		String searchResultCriteria = page.getInstance(SearchPage.class).getSearchCriteria().getAttribute("value");
		Assert.assertEquals(searchResultCriteria, searchKeyword);
	}

}