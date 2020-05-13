package test;

import org.testng.annotations.Test;

import static testdata.TestData.*;

public class SauceDemoTest extends BaseTest {

    @Test(description = "Проверка валидации полей на странице логина")
    public void loginFormTest() {
        loginPage
                .openPage()
                .login(USERNAME, EMPTY)
                .openPage()
                .login(EMPTY, PASSWORD)
                .openPage()
                .login(USERNAME, PASSWORD);
    }

    @Test(description = "Проверка добавления продукта в корзину и валидация отображения информация о продукте в ней")
    public void productPageTest() {
        productsPage
                .openPage()
                .addToCart(PRODUCTNAME)
                .removeFromCart(PRODUCTNAME)
                .addToCart(PRODUCTNAME)
                .chainLink()
                .openPage()
                .validateNumberOfProducts(1)
                .validateProductDetails(PRODUCTNAME, 1, 29.99);
    }

    @Test(description = "Проверка валидации полей на форме подверждения+проверка отображения сообщений об ошибки(первый шаг)")
    public void checkoutPageTest() {
        checkoutPage
                .openPage()
                .clickContinue()
                .verifyCheckoutErrorMessage("Error: First Name is required")
                .cleanCheckoutForm()
                .fillCheckoutForm(FIRSTNAME, EMPTY, EMPTY)
                .clickContinue()
                .verifyCheckoutErrorMessage("Error: Last Name is required")
                .cleanCheckoutForm()
                .fillCheckoutForm(FIRSTNAME, LASTNAME, EMPTY)
                .clickContinue()
                .verifyCheckoutErrorMessage("Error: Postal Code is required")
                .clickErrorButton()
                .verifyErrorMessageIsNotDisplayed()
                .cleanCheckoutForm()
                .fillCheckoutForm(FIRSTNAME, LASTNAME, ZIPCODE)
                .clickContinue()
                .openPage()
                .fillCheckoutForm("dope", EMPTY, EMPTY)
                .clickContinue()
                .clickErrorButton();
    }

    @Test(description = "Проверка отображения информации о товаре на странице подверждения(второй шаг)+ проверки перенапрвлений со страницы")
    public void checkoutPageStepTwoTest() {
        productsPage
                .openPage()
                .addToCart(System.getProperty("productName"));
        checkoutPageStepTwo
                .openPage()
                .clickCancelBtn("https://www.saucedemo.com/inventory.html")
                .openPage()
                .validateNumberOfProducts(1)
                .validateProductDetails(PRODUCTNAME, 1, "$29.99")
                .clickFinishBtn("https://www.saucedemo.com/checkout-complete.html");
    }
}


