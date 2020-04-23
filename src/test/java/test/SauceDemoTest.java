package test;

import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {


    @Test
    public void  loginTest(){
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.validateNumberOfProducts(1);
        cartPage.validateProductDetails("Sauce Labs Backpack",1,29.99);

    }
}
