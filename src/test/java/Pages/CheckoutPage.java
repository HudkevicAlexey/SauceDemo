package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public static final By FIRSTNAME = By.id("first-name");
    public static final By LASTNAME = By.id("last-name");
    public static final By POSTALCODE = By.id("postal-code");
    public static final By CONTINUE = By.cssSelector(".btn_primary");
    public static final By CANCEL = By.cssSelector("a[href='./cart.html']");
    public static final By ERRORMESSAGE = By.xpath("//h3[1]");
    public static final By ERRORBTN = By.cssSelector(".error-button");

    private static final String LOGIN_URL = "https://www.saucedemo.com/checkout-step-one.html";


    public void openPage() {
        driver.get(LOGIN_URL);
    }

    public void succsesfullyFormPass() {
        driver.findElement(FIRSTNAME).sendKeys("Alex");
        driver.findElement(LASTNAME).sendKeys("Hudkevich");
        driver.findElement(POSTALCODE).sendKeys("55555");
        driver.findElement(CONTINUE).click();
    }

    public void emptyFormPassCheck() {
        driver.findElement(CONTINUE).click();
        Assert.assertEquals(driver.findElement(ERRORMESSAGE).getText(), "Error: First Name is required", "Text message is not right");
    }

    public void passCheckoutFormOnlyWithFirstNameCheck() {
        driver.findElement(FIRSTNAME).sendKeys("Alex");
        driver.findElement(CONTINUE).click();
        Assert.assertEquals(driver.findElement(ERRORMESSAGE).getText(), "Error: Last Name is required", "Text message is not right");
    }

    public void cancelBtnCheck() {
        driver.findElement(CANCEL).click();
    }

    public void passCheckoutFormOnlyWithFirstNameAndLastNameCheck() {
        driver.findElement(FIRSTNAME).sendKeys("Alex");
        driver.findElement(LASTNAME).sendKeys("Hudkevich");
        driver.findElement(CONTINUE).click();
    }

    public void errorBtn() {
        driver.findElement(ERRORBTN).click();
        isElementPresent(ERRORMESSAGE);
    }
}

