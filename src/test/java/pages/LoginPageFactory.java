package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By BUTTON_INPUT = By.cssSelector(".btn_action");
    private static final String LOGIN_URL = "https://www.saucedemo.com/";
    @FindBy(id = "user-name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(css = ".btn_action")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public LoginPageFactory openPage() {
        driver.get(LOGIN_URL);
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    protected LoginPageFactory isPageOpened() {
        return this;
    }

    public LoginPageFactory loginSet(String name, String password){
        userNameInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }
}
