package test;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import org.testng.annotations.Test;

import static testdata.TestData.*;

public class SauceDemoTest extends BaseTest {

    @Test(description = "Проверка логина")
    @Description("Проверка валидации полей на странице логина")
    @Link(name="ClickME!", url="https://youtube.com/watch?v=dQw4w9WgXcQ")
    public void loginFormTest() {
        loginPage
                .openPage()
                .login(USERNAME, EMPTY)
                .openPage()
                .login(EMPTY, PASSWORD)
                .openPage()
                .login(USERNAME, PASSWORD);
    }

    @Test(description = "Проверка добавления продукта в корзину")
    @Description("Проверка добавления продукта в корзину и валидация отображения информация о продукте в ней")
    @Link(name="ClickME!", url="https://youtube.com/watch?v=dQw4w9WgXcQ")
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

    @Test(description = "Проверка отображения сообщений об ошибки")
    @Description("Проверка отображения сообщений об ошибки при пропуске полей в форме")
    @Link(name="ClickME!", url="https://youtube.com/watch?v=dQw4w9WgXcQ")
    public void checkoutPageErrorDisplayingCheckTest() {
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
                .verifyErrorMessageIsNotDisplayed();
    }

    @Test(description = "Прохождени страницы подверджения(первый шаг)")
    @Description("Провекрка прохождения формы подверждения покупки с валдиными данными")
    @Link(name="ClickME!", url="https://youtube.com/watch?v=dQw4w9WgXcQ")
    public void checkoutPageFormPassingCheck() {
        checkoutPage
                .openPage()
                .fillCheckoutForm(FIRSTNAME, LASTNAME, ZIPCODE)
                .clickContinue();
    }

    @Test(description = "Проверка страницы подверждения(второй шаг)")
    @Description("Проверка отображения информации о товаре на странице подверждения(второй шаг)+ проверки перенапрвлений со страницы")
    @Link(name="ClickME!", url="https://youtube.com/watch?v=dQw4w9WgXcQ")
    public void checkoutPageStepTwoTest() {
        productsPage
                .openPage()
                .addToCart(PRODUCTNAME);
        checkoutPageStepTwo
                .openPage()
                .clickCancelBtn("https://www.saucedemo.com/inventory.html")
                .openPage()
                .validateNumberOfProducts(1)
                .validateProductDetails(PRODUCTNAME, 1, "$29.99")
                .clickFinishBtn("https://www.saucedemo.com/checkout-complete.html");
    }
}


