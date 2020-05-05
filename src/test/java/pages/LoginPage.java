package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By BUTTON_INPUT = By.cssSelector(".btn_action");
    private static final String LOGIN_URL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.get(LOGIN_URL);
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    protected LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_INPUT));
        return this;
    }

    public LoginPage login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(BUTTON_INPUT).click();
        return this;
    }

    public ProductsPage chainLink() {
        return new ProductsPage(driver);
    }
}

