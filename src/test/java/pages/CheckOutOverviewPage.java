package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutOverviewPage extends HomePage {

    @FindBy(xpath = "//span[text()='Checkout: Overview']")

    WebElement checkOutOverviewPageHeader;

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutOverviewDisplayed() {
        return checkOutOverviewPageHeader.isDisplayed();
    }

    public String getCheckoutOverviewText() {
        return checkOutOverviewPageHeader.getText();
    }
}
