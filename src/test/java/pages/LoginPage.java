package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector(".error-message-container");


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


    public void Login(String userName, String password) {
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
}
