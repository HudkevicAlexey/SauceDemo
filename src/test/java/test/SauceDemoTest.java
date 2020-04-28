package test;

import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {


    @Test
    public void flowTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.validateNumberOfProducts(1);
        cartPage.validateProductDetails("Sauce Labs Backpack", 1, 29.99);
        checkoutPage.openPage();
        //Всё что выше классная работа 
        //Проверка прохождения пустой формы
        checkoutPage.emptyFormPassCheck();
        //Прохожение формы только по имени
        checkoutPage.passCheckoutFormOnlyWithFirstNameCheck();
        checkoutPage.openPage();
        //Прохождение формы по Имени и Фамилии
        checkoutPage.passCheckoutFormOnlyWithFirstNameAndLastNameCheck();
        //Проверка исчезновения ошибки после нажатия кнопки(ТУТ И ЕСТЬ ПРОБЛЕМА)
        checkoutPage.errorBtn();
        //Проверка кнопки Сancel
        checkoutPage.cancelBtnCheck();
        //Прохождение успешное прохождение формы и переход на checkout step two
        checkoutPage.openPage();
        checkoutPage.succsesfullyFormPass();
        //Проверка отображения товара на странице(По сути таже проверка которую мы делали на классном занятии в на
        //карзины,изменён был только class в xpath quantity + и "price" бы переведён в стринг формат так как в текст был
        //впихнут символ "$"
        checkoutPageStepTwo.openPage();
        checkoutPageStepTwo.validateNumberOfProducts(1);
        checkoutPageStepTwo.validateProductDetails("Sauce Labs Backpack",1,"$29.99");
        //Проверка кнопки СANCEL
        checkoutPageStepTwo.cancelBtnCheck();
        //Поверка кнопи FINISH
        checkoutPageStepTwo.openPage();
        checkoutPageStepTwo.FinishBtnCheck();
    }
}
