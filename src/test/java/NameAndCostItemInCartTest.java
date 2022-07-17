import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NameAndCostItemInCartTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get(" https://www.saucedemo.com");
    }

    @Test
    public void nameAndCostItemInCart() {

        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement buttonLogin = driver.findElement(By.cssSelector("[id='login-button']"));
        buttonLogin.click();
        WebElement buttonAddToCart = driver.findElement(By.cssSelector("[name='add-to-cart-sauce-labs-bike-light']"));
        buttonAddToCart.click();
        WebElement buttonCart = driver.findElement(By.cssSelector(".shopping_cart_link"));
        buttonCart.click();
        WebElement nameItem = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        String actualResultNameItem = nameItem.getText();
        String expectedResultNameItem = "Sauce Labs Bike Light";//.inventory_item_price
        Assert.assertEquals(actualResultNameItem, expectedResultNameItem, "The item isn't in the cart");
        WebElement costItem = driver.findElement(By.cssSelector(".inventory_item_price"));
        String actualResultCostItem = costItem.getText();
        String expectedResultCostItem = "$9.99";
        Assert.assertEquals(actualResultCostItem, expectedResultCostItem, "The cost isn't in the cart");
    }
}

