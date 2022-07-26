package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import static constants.Constants.SignIn.password;
import static constants.Constants.SignIn.userName;
import static constants.Constants.TextToTests.*;

public class ProductsDataProviderTest extends BaseTest {


    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkOutInfoPage = new CheckOutInfoPage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
    }

    @Test(description = "checking products on ProductsPage", enabled = true, groups = {"Regression"}, dataProvider = "ProductsDataProvider")
    public void checkProductsInProductsPage(String productsName, String description, String price) {

        loginPage.login(userName, password);

        Assert.assertTrue(productsPage.isProductPresentByName(productsName));

        Assert.assertEquals(productsPage.getItemDescription(productsName), description);

        Assert.assertEquals(productsPage.getItemPrice(productsName), price);

    }

    @DataProvider(name = "ProductsDataProvider")
    public Object[][] productsTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", DESCRIPTION_BACKPACK, "$29.99"},
                {"Sauce Labs Bike Light", DESCRIPTION_BIKE_LIGHT, "$9.99"},
                {"Sauce Labs Bolt T-Shirt", DESCRIPTION_BOLT_T_SHIRT, "$15.99"},
                {"Sauce Labs Fleece Jacket", DESCRIPTION_JACKET, "$49.99"},
                {"Sauce Labs Onesie", DESCRIPTION_ONESIE, "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", DESCRIPTION_T_SHIRT_RED, "$15.99"},

        };
    }
}
