package com.demoshop24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demoshop24.base.BasePage;

public class Header extends BasePage {
	private By myAccount = By.cssSelector("a[title='My Account'] > .hidden-md.hidden-sm.hidden-xs");
	private By login = By.cssSelector(".list-inline  ul > li:nth-of-type(2) > a");

	public Header(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public LoginPage clickOnLogin() {
		getMyAccount().click();
		getLogin().click();
		return getInstance(LoginPage.class);
	}

	private WebElement getMyAccount() {
		return getElement(myAccount);
	}

	private WebElement getLogin() {
		return getElement(login);
	}

}
