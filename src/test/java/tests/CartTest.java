package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ItemDetailsPage;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.Constants.ItemName.productsName;
import static constants.Constants.SignIn.password;
import static constants.Constants.SignIn.userName;
import static constants.Constants.URL.urlPage;

public class CartTest extends BaseTest {
    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void addItemToCart() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(productsName);
        productsPage.clickCartButton();
        Assert.assertTrue(cartPage.getProductDescription());

    }

    @Test
    public void removeItemFromCart() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(productsName);
        productsPage.clickCartButton();
        cartPage.clickRemoveButton();
        Assert.assertFalse(cartPage.cartIsEmpty());
    }

    @Test
    public void twitterLinkWorks() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        cartPage.clickTwitterLink();
        Assert.assertEquals(cartPage.getCurrentUrl(), urlPage);
    }
}
