package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends HomePage {

    private final By addToCartButton = By.cssSelector("button[id^='add-to-cart']");
    private final By backToProductsButton = By.cssSelector("button[id^='back-to']");


    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickBackToProductsButton() {
        driver.findElement(backToProductsButton).click();
    }

}
