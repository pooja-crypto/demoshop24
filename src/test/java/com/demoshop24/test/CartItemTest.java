package com.demoshop24.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoshop24.pages.CartItemPage;
import com.demoshop24.pages.SearchPage;

public class CartItemTest extends BaseTest {

	@Test(description = "To verify add to cart functionality", dataProvider = "getSearchTestData")
	public void verifyAddToCart(String searchKeyword) {
		page.getInstance(SearchPage.class).performSearchOperation(searchKeyword);
		page.clickOnLinkText(searchKeyword);
		page.getInstance(CartItemPage.class).clickOnAddtoCartButton();
		String successMsg = page.getInstance(CartItemPage.class).getSuccessMessage();
		Assert.assertTrue(successMsg.startsWith("Success:"));
	}

	@Test(description = "To verify title of the search result page", dataProvider = "getSearchTestData")
	public void verifyProductSearchDetailsPage(String searchKeyword) {

		page.getInstance(SearchPage.class).performSearchOperation(searchKeyword);
		page.clickOnLinkText(searchKeyword);
		Assert.assertEquals(page.getPageTitle(), searchKeyword);
	}

	@Test(description = "To verify no. of items displayed in the cart", dataProvider = "getSearchTestData")
	public void verifyCartTotalQuantity(String searchKeyword) throws InterruptedException {
		page.getInstance(SearchPage.class).performSearchOperation(searchKeyword);
		page.clickOnLinkText(searchKeyword);
		page.getInstance(CartItemPage.class).clickOnAddtoCartButton();
		String getQuantityText = page.getInstance(CartItemPage.class).getQuantityField();
		Assert.assertEquals(getQuantityText, "1 item(s) - $602.00");
	}

	@Test(description = "To verify added cart items on view page", dataProvider = "getSearchTestData")
	public void verifyViewPageCartTitle(String searchKeyword) {
		page.getInstance(SearchPage.class).performSearchOperation(searchKeyword);
		page.clickOnLinkText(searchKeyword);
		page.getInstance(CartItemPage.class).performViewCartOperation();
		Assert.assertEquals(page.getPageTitle(), "Shopping Cart");
	}

	@Test(description = "To verify remove item cart functionality", dataProvider = "getSearchTestData")
	public void verifyRemoveCart(String searchKeyword) {
		page.getInstance(SearchPage.class).performSearchOperation(searchKeyword);
		page.clickOnLinkText(searchKeyword);
		page.getInstance(CartItemPage.class).performViewCartOperation();
		page.getInstance(CartItemPage.class).clickOnRemoveCartButton();
		Assert.assertEquals(page.getInstance(CartItemPage.class).getRemoveCartMsg(), "Your shopping cart is empty!");
	}

}
