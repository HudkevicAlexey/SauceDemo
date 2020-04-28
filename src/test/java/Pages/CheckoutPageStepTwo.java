package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPageStepTwo extends BasePage {


    public CheckoutPageStepTwo(WebDriver driver) {
        super(driver);
    }

    private static final By OVERVIEW_CART = By.cssSelector(".cart_list");
    private String productQuantityLocator = "//*[contains(text(),'%s')]/../../..//div[@class='summary_quantity']";
    private String productPriceLocator = "//*[contains(text(),'%s')]/../../..//div[@class='inventory_item_price']";
    public static final By CANCEL_BTN = By.xpath("//a[@class='cart_cancel_link btn_secondary']");
    private static final By FINISH_BTN =  By.xpath("//a[@class='btn_action cart_button']");
    private static final  By ITEM_TOTAL = By.cssSelector(".summary_subtotal_label");
    private static final By TAX = By.cssSelector(".summary_tax_label");
    private static final By TOTAL = By.cssSelector("summary_total_label");

    private static final String LOGIN_URL = "https://www.saucedemo.com/checkout-step-two.html";

    public void openPage() {
        driver.get(LOGIN_URL);
    }

    public void validateNumberOfProducts(int number) {
        Assert.assertEquals(driver.findElements(OVERVIEW_CART).size(), number, "Колл элементов не соответсвует");
    }

    public void validateProductDetails(String productName, int quantity, String price) {
        String actualQuantity = driver.findElement(
                By.xpath(String.format(productQuantityLocator, productName))).getText();
        Assert.assertEquals(actualQuantity, String.valueOf(quantity),
                "Quantity is invalid");
        String actualPrice = driver.findElement(
                By.xpath(String.format(productPriceLocator, productName))).getText();
        Assert.assertEquals(actualPrice, String.valueOf(price),
                "Price is invalid");
    }
    public void cancelBtnCheck(){
        driver.findElement(CANCEL_BTN).click();
    }
    public void FinishBtnCheck(){
        driver.findElement(FINISH_BTN).click();
    }


}
