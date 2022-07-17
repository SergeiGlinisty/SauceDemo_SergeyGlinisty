package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.Constants.SignIn.password;
import static constants.Constants.SignIn.userName;
import static constants.Constants.TextToTests.textToNegativLoginTest;

public class LoginTest extends BaseTest {


    @BeforeClass
    public void initialise() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

    }

    @Test
    public void positiveLoginTest() {

        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());

    }

    @Test
    public void negativeLoginTest() {

        loginPage.setUserName("");
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMassageText(), textToNegativLoginTest);

    }
}
