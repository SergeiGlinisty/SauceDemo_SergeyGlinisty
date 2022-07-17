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

    @Test
    public void returnToProductsPage() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.openItemByName(productsName);
        itemDetailsPage.clickBackToProductsButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());

    }

    @Test
    public void logOut() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.clickMenuButton();
        productsPage.clickElementMenu();
        //  productsPage.clickElementMenu(elementMenuName);
        Assert.assertTrue(loginPage.loginButtonDisplayed());
    }

    @Test
    public void goToCart() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isCartPageHeaderDisplayed());
    }
}


