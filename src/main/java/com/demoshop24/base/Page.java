package com.demoshop24.base;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);
	}

	public abstract String getPageTitle();

	public abstract WebElement getElement(By locator);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPageTitile(String Title);

	public abstract String getElementText(By locator);

	public abstract String getProperty(String key);

	public abstract void clickOnLinkText(String text);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	};

}
