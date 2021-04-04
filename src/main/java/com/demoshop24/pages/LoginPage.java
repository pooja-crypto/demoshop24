package com.demoshop24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demoshop24.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By emailAddressTextBox = By.xpath("//*[@id='input-email']");
	private By passwordTextBox = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit'][@value='Login']");
	private By errorMessage = By.cssSelector("div#account-login > .alert.alert-danger.alert-dismissible");
	private By LogoutButton = By.linkText("Logout");

	public By getErrorMessage() {
		return errorMessage;
	}

	private WebElement getEmailAddressTextBox() {
		return getElement(emailAddressTextBox);
	}

	private WebElement getPasswordTextBox() {
		return getElement(passwordTextBox);
	}

	private WebElement getLoginButton() {
		return getElement(loginButton);
	}

	public AccountPage performLogin(String email, String password) {

		getEmailAddressTextBox().sendKeys(email);
		getPasswordTextBox().sendKeys(password);
		getLoginButton().click();
		return getInstance(AccountPage.class);
	}

	public void loginWithoutCredentials() {
		getEmailAddressTextBox().sendKeys("");
		getPasswordTextBox().sendKeys("");
		getLoginButton().click();
	}

	public String getErrorMessageText() {

		return getElementText(errorMessage);

	}

	public WebElement getLogoutButton() {
		return getElement(LogoutButton);
	}

}
