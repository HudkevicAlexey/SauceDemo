package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final String LOGIN_URL = "https://www.saucedemo.com/inventory.html";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы")
    public ProductsPage openPage() {
        driver.get(LOGIN_URL);
        waitForNumberOfElements(By.cssSelector(".btn_inventory"), 6);
        return this;
    }

    @Override
    protected ProductsPage isPageOpened() {
        return this;
    }

    @Step("Доваление в корзину")
    public ProductsPage addToCart(String productName) {
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
        waitForNumberOfElements(By.cssSelector(".btn_inventory"), 6);
        return this;
    }

    @Step("Удаление из корзины")
    public ProductsPage removeFromCart(String productName) {
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
        return this;
    }

    public CartPage chainLink() {
        return new CartPage(driver);
    }
}



