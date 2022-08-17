package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public abstract class HomePage extends BasePage {

    @FindBy(css=".shopping_cart_link")

    WebElement cartButton;

    @FindBy(css="#logout_sidebar_link")

    WebElement linkMenu;
    @FindBy(css="#react-burger-menu-btn")

    WebElement menuButton;
    @FindBy(css=".inventory_item_desc")

    WebElement productDescription;

    @FindBy(xpath="//a[text() = 'Twitter']")

    WebElement twitterLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isProductDescriptionDisplayed() {

        return productDescription.isDisplayed();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickElementMenu() {
        linkMenu.click();
    }

    public void clickTwitterLink() {
        twitterLink.click();

    }

    public String getUrlOpenedPage() {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> allWindowsList = allWindows.stream().toList();
        driver.switchTo().window(allWindowsList.get(1));
        return driver.getCurrentUrl();
    }

    public String returnToPreviousPageAndGetUrl() {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> allWindowsList = allWindows.stream().toList();
        driver.switchTo().window(allWindowsList.get(0));
        return driver.getCurrentUrl();
    }

}









