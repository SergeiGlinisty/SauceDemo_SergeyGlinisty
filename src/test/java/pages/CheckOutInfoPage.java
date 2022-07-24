package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInfoPage extends HomePage {

    @FindBy(css = "#first-name")

    WebElement firstNameElement;
    @FindBy(css = "#last-name")

    WebElement lastNameElement;
    @FindBy(css = "#postal-code")

    WebElement postalCodeElement;
    @FindBy(css = "#continue")

    WebElement continueButton;
    @FindBy(xpath = "//h3[text()='Error: First Name is required']")
    WebElement checkoutErrorText;


    public CheckOutInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        firstNameElement.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameElement.sendKeys(lastName);
    }

    public void setPostalCode(String postalCode) {
        postalCodeElement.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
        clickContinueButton();
    }

    public void negativeEnterCheckoutInfo() {
        setFirstName("");
        setLastName("");
        setPostalCode("");
        clickContinueButton();
    }

    public String getCheckoutErrorText() {
        return checkoutErrorText.getText();
    }
}
