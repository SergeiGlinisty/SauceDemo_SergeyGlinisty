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
import static constants.Constants.URL.urlCurrentPage;
import static constants.Constants.URL.urlOpenedPage;

public class CartTest extends BaseTest {


    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(description = "checking add Item to cart", enabled = true, groups = {"Smoke"})
    public void addItemToCart() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(productsName);
        productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isProductDescriptionDisplayed());

    }

    @Test(description = "checking remove item from cart", groups = {"Regression"})
    public void removeItemFromCart() {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(productsName);
        productsPage.clickCartButton();
        cartPage.clickRemoveButton();
        Assert.assertFalse(cartPage.cartIsEmpty());
    }

    @Test(description = "checking transition to website twitter", groups = {"Regression"})
    public void goToTwitterTest() {

        loginPage.setUserName(userName);

        loginPage.setPassword(password);

        loginPage.clickLoginButton();

        cartPage.clickTwitterLink();

        cartPage.getUrlOpenedPage();

        Assert.assertEquals(cartPage.getUrlOpenedPage(), urlOpenedPage);

        cartPage.returnToPreviousPageAndGetUrl();

        Assert.assertEquals(cartPage.returnToPreviousPageAndGetUrl(), urlCurrentPage);

    }
    @Test
    public void runTest() {
        System.out.println(System.getProperty("testProp"));
    }
}
