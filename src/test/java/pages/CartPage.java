package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    private String productQuantityLocator = "//*[contains(text(),'%s')]/../../..//div[@class='cart_quantity']";
    private String productPriceLocator = "//*[contains(text(),'%s')]/../../..//div[@class='inventory_item_price']";
    private  static final By CART_ITEM = By.cssSelector(".cart_item");
    private  static final  By PRODUCT_NAME = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    private static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    private static final String URL = "https://www.saucedemo.com/cart.html";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public  CartPage  openPage () {
        driver.get(URL);
        return this;
    }

    @Override
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        return this;
    }

   @Step("Валицая колличество товаров")
    public CartPage validateNumberOfProducts(int number){
        Assert.assertEquals(driver.findElements(CART_ITEM).size(),number,"Колл элементов");
        return this;
    }

    @Step("Валидация товра")
    public CheckoutPage validateProductDetails(String productName, int quantity, double price) {
        String actualQuantity = driver.findElement(
                By.xpath(String.format(productQuantityLocator, productName))).getText();
        Assert.assertEquals(actualQuantity, String.valueOf(quantity),
                "Quantity is invalid");
        String actualPrice = driver.findElement(
                By.xpath(String.format(productPriceLocator, productName))).getText();
        Assert.assertEquals(actualPrice, String.valueOf(price),
                "Price is invalid");
        return new CheckoutPage(driver);
    }
}
