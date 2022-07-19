import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Locators extends BaseTest {

    //xpath
//Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
    //https://www.saucedemo.com/
    WebElement attribute = driver.findElement(By.xpath("//div[@class='login_logo']"));

    //Поиск по тексту, например By.xpath("//tag[text()='text']");
    //https://www.saucedemo.com/inventory.html
    WebElement text = driver.findElement(By.xpath("//button[text()='Open Menu']"));

    //Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
    //https://www.saucedemo.com/
    WebElement containsAttribute = driver.findElement(By.xpath("//div[contains(@class,'bot')]"));

    //Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
    //https://www.saucedemo.com/
    WebElement containsText = driver.findElement(By.xpath("//noscript[contains(text(),'to enable')]"));

    //ancestor, например //*[text()='Enterprise Testing']//ancestor::div
    //https://www.saucedemo.com/inventory.html
    WebElement ancestor = driver.findElement(By.xpath("//*[text()='Add to cart']//ancestor::body"));

    //descendant
    //https://www.saucedemo.com/inventory-item.html?id=4
    WebElement descendant = driver.findElement(By.xpath("//div[@class='header_secondary_container']//descendant::button"));

    //following-sibling
    //https://www.saucedemo.com/cart.html
    WebElement following_sibling = driver.findElement(By.xpath("//a[@id ='item_5_title_link']//following-sibling::div"));

    //parent
    //https://www.saucedemo.com/cart.html
    WebElement parent = driver.findElement(By.xpath("//span[contains(text(), 'Your')]//parent::*"));

    //preceding - sibling
    //https://www.saucedemo.com/checkout-step-one.html
    WebElement preceding_sibling = driver.findElement(By.xpath("//div[@id= 'checkout_info_container']//preceding-sibling::*"));

    //*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
    //https://www.saucedemo.com/checkout-step-one.html
    WebElement two_conditions = driver.findElement(By.xpath("//div[@id='header_container' and contains(@class, 'header')]"));

    //css
//.class
    WebElement element = driver.findElement(By.cssSelector(".login_wrapper"));
    //.class1.class2
    WebElement elements = driver.findElement(By.cssSelector(".page_wrapper.contents_wrapper"));
    //.class1 .class2
    WebElement overview = driver.findElement(By.cssSelector(".summary_info .summary_info_label"));
    //#id
    WebElement id = driver.findElement(By.cssSelector("#root"));
    //tagName
    List<WebElement> tagName = driver.findElements(By.cssSelector("div"));
    //tagName.class
    WebElement tagNameClass = driver.findElement(By.cssSelector("div.page_wrapper"));
    //[attribute=value]
    WebElement attributeValue = driver.findElement(By.cssSelector("[style='height: 100%;']"));
    //[attribute~=value]
    WebElement buttonRemoveShirt = driver.findElement(By.cssSelector("[class~='btn']"));
    //[attribute|=value]
    WebElement buttonRemove = driver.findElement(By.cssSelector("[name|='remove-sauce']"));
    //[attribute^=value]
    WebElement linkStart = driver.findElement(By.cssSelector("a[href^='#']"));
    //[attribute$=value]
    WebElement linkEnd = driver.findElement(By.cssSelector("div[id$='ner']"));
    //[attribute*=value]
    WebElement linkContains = driver.findElement(By.cssSelector("div[class*='or']"));
}



