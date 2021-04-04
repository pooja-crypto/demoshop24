package com.demoshop24.pages;

import org.openqa.selenium.WebDriver;
import com.demoshop24.base.BasePage;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	public String getAccountPageTitle() {
		return getPageTitle();
	}
}
