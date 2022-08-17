package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends HomePage {

    private final By addToCartButton = By.cssSelector("button[id^='add-to-cart']");
    private final By productLink = By.cssSelector(".inventory_item_name");
    private final String productContainerLocator = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private final By productsPageHeader = By.cssSelector(".peek");
    private final By descriptionProducts = By.cssSelector(".inventory_item_desc");
    private final By descriptionPrice = By.cssSelector(".inventory_item_price");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    public String getItemDescription(String productsName) {
        WebElement getDescription = getProductContainerByName(productsName);
        return getDescription.findElement(descriptionProducts).getText();

    }

    public String getItemPrice(String productsName) {
        WebElement getDescription = getProductContainerByName(productsName);
        return getDescription.findElement(descriptionPrice).getText();

    }


    public void openItemByName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(productLink).click();
    }

    public void clickAddToCartButton(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(addToCartButton).click();
    }


    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator, productsName)));
    }


    public boolean isProductPresentByName(String productName) {
        try {
            getProductContainerByName(productName);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}