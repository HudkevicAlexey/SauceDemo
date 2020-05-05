package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    public static final By FIRSTNAME = By.id("first-name");
    public static final By LASTNAME = By.id("last-name");
    public static final By POSTALCODE = By.id("postal-code");
    public static final By CONTINUE = By.cssSelector(".btn_primary");
    public static final By CANCEL = By.cssSelector("a[href='./cart.html']");
    public static final By ERRORMESSAGE = By.xpath("//h3[1]");
    public static final By ERRORBTN = By.cssSelector(".error-button");
    private static final String LOGIN_URL = "https://www.saucedemo.com/checkout-step-one.html";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage openPage() {
        driver.get(LOGIN_URL);
        return this;
    }

    @Override
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE));
        return this;
    }

    public CheckoutPage clickContinue() {
        driver.findElement(CONTINUE).click();
        return this;
    }

    public CheckoutPage verifyCheckoutErrorMessage(String errorMessage) {
        Assert.assertEquals(driver.findElement(ERRORMESSAGE).getText(), errorMessage, "Text message is not right");
        return this;
    }

    public CheckoutPage fillCheckoutForm(String firstName, String lastName, String zipCode) {
        if (!firstName.equals("")) {
            driver.findElement(FIRSTNAME).sendKeys(firstName);
        }
        if (!lastName.equals("")) {
            driver.findElement(LASTNAME).sendKeys(lastName);
        }
        if (!zipCode.equals("")) {
            driver.findElement(POSTALCODE).sendKeys(zipCode);
        }
        return this;
    }

    public CheckoutPage cleanCheckoutForm() {
        driver.findElement(FIRSTNAME).clear();
        driver.findElement(LASTNAME).clear();
        driver.findElement(POSTALCODE).clear();
        return this;
    }

    public CheckoutPage clickErrorButton() {
        driver.findElement(ERRORBTN).click();
        return this;
    }

    public CheckoutPage verifyErrorMessageIsNotDisplayed() {
        Assert.assertTrue(isElementPresent(ERRORMESSAGE), "Error message is not disappeared");
        return this;
    }
    public CheckoutPageStepTwo chainLink(){
        return new CheckoutPageStepTwo(driver);
    }
}

