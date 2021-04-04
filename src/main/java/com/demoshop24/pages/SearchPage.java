package com.demoshop24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demoshop24.base.BasePage;

public class SearchPage extends BasePage {

	private By searchTextBox = By.cssSelector("div#search > input[name='search']");
	private By searchButton = By.cssSelector(".btn.btn-default.btn-lg");
	private By searchCriteria = By.id("input-search");

	private By searchNoFoundMesg = By
			.xpath("//div[@id='content']/p[.='There is no product that matches the search criteria.']");

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void performSearchOperation(String searchKeyword) {

		getSearchTextBox().sendKeys(searchKeyword);
		getSearchButton().click();

	}

	public void performEmptySearchOperation() {

		getSearchTextBox().sendKeys("");
		getSearchButton().click();

	}

	private WebElement getSearchTextBox() {
		return getElement(searchTextBox);
	}

	private WebElement getSearchButton() {
		return getElement(searchButton);
	}

	public WebElement getSearchCriteria() {
		return getElement(searchCriteria);
	}

	private WebElement getSearchNoFoundMesg() {
		return getElement(searchNoFoundMesg);
	}

	public String searchNoFoundMessageText() {

		return getElementText(searchNoFoundMesg);

	}

}
