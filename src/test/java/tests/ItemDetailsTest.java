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

public class ItemDetailsTest extends BaseTest {


    @BeforeClass

    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(description = "checking return ProductsPage", enabled = true, groups = {"Regression"})
    public void returnToProductsPage() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.openItemByName(productsName);
        itemDetailsPage.clickBackToProductsButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());

    }

    @Test(description = "checking logOut ", enabled = true, groups = {"Smoke"})
    public void logOut() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.clickMenuButton();
        productsPage.clickElementMenu();
        Assert.assertTrue(loginPage.loginButtonDisplayed());
    }

    @Test(description = "checking transition to Cart", groups = {"Regression"})
    public void goToCart() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isCartPageHeaderDisplayed());
    }
}


