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
    public void goToTwitter() {
        System.out.println("start goToTwitter test ");
        loginPage.setUserName(userName);
        System.out.println("enter userName");
        loginPage.setPassword(password);
        System.out.println("enter password");
        loginPage.clickLoginButton();
        System.out.println("click Login button");
        cartPage.clickTwitterLink();
        System.out.println("click Twitter link");
        cartPage.getUrlOpenedPage();
        System.out.println("get URL Twitter page");
        Assert.assertEquals(cartPage.getUrlOpenedPage(), urlOpenedPage);
        System.out.println("check URL Twitter page");
        cartPage.returnToPreviousPageAndGetUrl();
        System.out.println("return to LoginPage and get LoginPage Url");
        Assert.assertEquals(cartPage.returnToPreviousPageAndGetUrl(), urlCurrentPage);
        System.out.println("check URL LoginPage");
        System.out.println("end goToTwitter test ");
    }
}
