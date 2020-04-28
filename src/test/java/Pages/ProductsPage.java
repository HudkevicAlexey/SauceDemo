package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";


    private static final String LOGIN_URL = "https://www.saucedemo.com/inventory.html";

    public ProductsPage(WebDriver driver) {
        super(driver);

    }

    public void openPage() {
        driver.get(LOGIN_URL);
        waitForNumberOfElements(By.cssSelector(".btn_inventory"),6);
    }


    public void addToCart(String productName) {
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
        waitForNumberOfElements(By.cssSelector(".btn_inventory"),6);
    }
}



