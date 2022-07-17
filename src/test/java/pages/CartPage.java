package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HomePage {

    private final By cartPageHeader = By.cssSelector(".title");
    private final By continueShoppingButton = By.cssSelector("#continue-shopping");
    private final By checkoutButton = By.cssSelector("#checkout");
    private final By removeButton = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");
    private final By emptyCart = By.cssSelector(".removed_cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageHeaderDisplayed() {
        return driver.findElement(cartPageHeader).isDisplayed();
    }


    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }

    public boolean cartIsEmpty() {
        return driver.findElement(emptyCart).isDisplayed();

    }
}
