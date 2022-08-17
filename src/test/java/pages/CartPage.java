package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends HomePage {

    @FindBy(css=".title")

    WebElement cartPageHeader;
    @FindBy(css = "#continue-shopping")

    WebElement continueShoppingButton;
    @FindBy(css = "#checkout")

    WebElement checkOutButton;
    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")

    WebElement removeButton;
    @FindBy(css=".removed_cart_item")

    WebElement emptyCart;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isCartPageHeaderDisplayed() {
        return cartPageHeader.isDisplayed();
    }


    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickCheckoutButton() {
        checkOutButton.click();
    }

    public void clickRemoveButton() {
       removeButton.click();
    }

    public boolean cartIsEmpty() {
        return emptyCart.isDisplayed();

    }
}
