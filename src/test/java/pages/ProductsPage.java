package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends HomePage {

    private final By addToCartButton = By.cssSelector("button[id^='add-to-cart']");
    private final By productLink = By.cssSelector(".inventory_item_name");
    private final String productContainerLocator = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private final By productsPageHeader = By.cssSelector(".peek");

    // private final By productDescription = By.cssSelector(".inventory_details_desc_container");
    private final By productPrice = By.xpath("//div[contains(text(),'29.99')]");
    private String productsName;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    // public String getProductDescription(){
    //return products description text
    //   return driver.findElement(productDescription).getText();
    //  }

    public String getProductPrice() {
        //return products price text
        return driver.findElement(productPrice).getText();
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

}