package com.demoshop24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demoshop24.base.BasePage;

public class CartItemPage extends BasePage {

	private By addToCartButton = By.xpath("//*[@id='button-cart']");
	private By quantityField = By.xpath("//div[@id='cart']/button[@type='button']");
	private By viewCartButton = By.linkText("View Cart");
	private By removeFromCartButton = By.xpath("//button[@data-original-title='Remove']");
	private By updateCartButton = By.xpath("//button[@data-original-title='Update']");
	private By successMsg = By.xpath("//*[contains(text(),'Success: You have added')]");
	private By removeCartMesg = By.xpath("//div[@id='content']/p[.='Your shopping cart is empty!']");

	public CartItemPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private WebElement getQuantityButton() {
		return getElement(quantityField);
	}

	public String getQuantityField() {
		return getElementText(quantityField).trim();
	}

	private WebElement getViewCartButton() {
		return getElement(viewCartButton);
	}

	private WebElement getRemoveFromCartButton() {
		return getElement(removeFromCartButton);
	}

	private WebElement getUpdateCartButton() {
		return getElement(updateCartButton);
	}

	private WebElement getAddToCartButton() {
		return getElement(addToCartButton);
	}

	public String getSuccessMessage() {
		return getElementText(successMsg);
	}
	
	public String getRemoveCartMsg() {
		return getElementText(removeCartMesg);
	}

	public void performViewCartOperation() {
		getAddToCartButton().click();
		getQuantityButton().click();
		getViewCartButton().click();
	}

	public void clickOnAddtoCartButton() {

		getAddToCartButton().click();
		waitForPageLoaded();
	}

	public void clickOnRemoveCartButton() {

		getRemoveFromCartButton().click();
	}

}
