package com.demoshop24.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@Override
	public void waitForPageTitile(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}

	@Override
	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}

	@Override
	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	@Override
	public void clickOnLinkText(String text) {
		driver.findElement(By.linkText(text)).click();
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
}
