package test;


import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)
public class BaseTest {

    private WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutPageStepTwo checkoutPageStepTwo;

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutPageStepTwo = new CheckoutPageStepTwo(driver);
        context.setAttribute("WebDriver", driver);
    }

   @AfterMethod(alwaysRun=true)
   public void closeBrowser() {
       driver.quit();
    }
}


