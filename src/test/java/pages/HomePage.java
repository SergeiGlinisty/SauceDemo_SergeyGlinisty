package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class HomePage extends BasePage {

    private final By cartButton = By.cssSelector(".shopping_cart_link");

    // private final String menuLocator = "//a[@class ='bm-item menu-item' and text()='Logout']/ancestor::div[@class='bm-menu']";
    private final By linkMenu = By.cssSelector("#logout_sidebar_link");
    private final By menuButton = By.cssSelector("#react-burger-menu-btn");
    private final By productDescription = By.cssSelector(".inventory_item_desc");

    private final By twitterLink = By.xpath("//a[text() = 'Twitter']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean getProductDescriptionElement() {

        return driver.findElement(productDescription).isDisplayed();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    public void clickElementMenu() {
        driver.findElement(linkMenu).click();
    }

    public void clickTwitterLink() {
        driver.findElement(twitterLink).click();

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


}






