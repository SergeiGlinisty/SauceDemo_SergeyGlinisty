package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector(".error-message-container");
    private String errorLoginContainer = "//h3[@data-test= 'error' and text()='%s']/ancestor::div[@class='error-message-container error']";

    private String errorText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean loginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMassageText() {
        return driver.findElement(errorMessage).getText();
    }


    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }

    public void setUserName(String userName) {
        driver.findElement(usernameInput).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public WebElement getContainerErrorText() {
        return driver.findElement(By.xpath(String.format(errorLoginContainer)));
    }
}
