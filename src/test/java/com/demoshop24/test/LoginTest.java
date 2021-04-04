package com.demoshop24.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoshop24.pages.LoginPage;

public class LoginTest extends BaseTest {
	String email = System.getProperty("email");
	String password = System.getProperty("password");

	@Test(description = "To verify title of login page")
	public void verifyLoginPageTitle() {
		Assert.assertEquals(page.getPageTitle(), "Account Login");
	}

	@Test(description = "To verify valid login credentials.")
	public void verifyloginCredentials() {
		page.getInstance(LoginPage.class).performLogin(email, password);
		Assert.assertEquals(page.getPageTitle(), "My Account");
	}

	@Test(description = "To verify login with invalid credentails.")
	public void verifyInvalidCredentials() {
		page.getInstance(LoginPage.class).loginWithoutCredentials();
		Assert.assertEquals(page.getInstance(LoginPage.class).getErrorMessageText(),
				"Warning: No match for E-Mail Address and/or Password.");
	}

	@Test(description = "to verify logout functionality.")
	public void verifyLogoutFunctionality() {
		page.getInstance(LoginPage.class).performLogin(email, password);
		page.getInstance(LoginPage.class).getLogoutButton().click();
		Assert.assertEquals(page.getPageTitle(), "Account Logout");
	}

}
