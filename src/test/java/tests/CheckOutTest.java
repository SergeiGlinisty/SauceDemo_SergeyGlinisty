package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static constants.Constants.CheckOutData.*;
import static constants.Constants.ItemName.productsName;
import static constants.Constants.SignIn.password;
import static constants.Constants.SignIn.userName;
import static constants.Constants.TextToTests.CHECKOUT_ERROR_TEXT;
import static constants.Constants.TextToTests.CHECKOUT_TEXT;

public class CheckOutTest extends BaseTest {


    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkOutInfoPage = new CheckOutInfoPage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
    }

    @Test(description = "checking transition to checkoutOverviewPage", enabled = true, groups = {"Regression"})
    public void checkoutOverview() {
        loginPage.login(userName, password);
        productsPage.clickAddToCartButton(productsName);
        productsPage.clickCartButton();
        cartPage.clickCheckoutButton();
        checkOutInfoPage.enterCheckoutInfo(firstName, lastName, postalCode);
        Assert.assertEquals(checkOutOverviewPage.getCheckoutOverviewText(), CHECKOUT_TEXT);
    }

    @Test(description = "negative checkout test", enabled = true, groups = {"Regression", "Negative"})
    public void negativeCheckout() {
        loginPage.login(userName, password);
        productsPage.clickAddToCartButton(productsName);
        productsPage.clickCartButton();
        cartPage.clickCheckoutButton();
        checkOutInfoPage.enterCheckoutInfo("","","");
        Assert.assertEquals(checkOutInfoPage.getCheckoutErrorText(), CHECKOUT_ERROR_TEXT);
    }

}
