package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.Constants.SignIn.password;
import static constants.Constants.SignIn.userName;
import static constants.Constants.TextToTests.*;


public class LoginTest extends BaseTest {


    @BeforeClass
    public void initialise() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

    }

    @Test(description = "positive login test", enabled = true, groups = {"Smoke"})
    public void positiveLoginTest() {

        loginPage.setUserName(userName);

        loginPage.setPassword(password);

        loginPage.clickLoginButton();

        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());

    }

    @Test(description = "negative login test", groups = {"Regression", "Negative"}, dataProvider = "loginDataProvider")
    public void negativeLoginTest(String userName, String password, String expected) {

        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMassageText(), expected);

    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"", password, USERNAME_NOT_ENTERED},
                {userName, "", PASSWORD_NOT_ENTERED},
                {"dfghjgh", password, USERNAME_INCORRECT},
        };
    }
}
