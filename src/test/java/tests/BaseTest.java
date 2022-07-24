package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    LoginPage loginPage;
    ProductsPage productsPage;
    ItemDetailsPage itemDetailsPage;
    CartPage cartPage;
    CheckOutInfoPage checkOutInfoPage;
    CheckOutOverviewPage checkOutOverviewPage;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)

    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Undefined browser type");
        }
        wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @BeforeMethod (alwaysRun = true)
    public void openSauseDemo() {
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }


    @AfterClass (alwaysRun = true)
    public void tearDown() {
         driver.quit();

    }
}
