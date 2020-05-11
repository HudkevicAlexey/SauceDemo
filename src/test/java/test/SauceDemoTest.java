package test;

import org.testng.annotations.Test;

import static testdata.TestData.*;

public class SauceDemoTest extends BaseTest {

    @Test
    public void flowTest() {
        loginPage
                .openPage()
                .login(System.getProperty("user"), System.getProperty("password"));
//        @Test
//        public void dddd () {
//                .openPage()
//                    .login(EMPTY, PASSWORD)
//                    .openPage()
//                    .login(USERNAME, PASSWORD)
//                    .chainLink()
//                    .addToCart(PRODUCTNAME)
//                    .removeFromCart(PRODUCTNAME)
//                    .addToCart(PRODUCTNAME)
//                    .chainLink()
//                    .openPage()
//                    .validateNumberOfProducts(1)
//                    .validateProductDetails(PRODUCTNAME, 1, 29.99)
//                    .openPage()
//                    .clickContinue()
//                    .verifyCheckoutErrorMessage("Error: First Name is required")
//                    .cleanCheckoutForm()
//                    .fillCheckoutForm(FIRSTNAME, EMPTY, EMPTY)
//                    .clickContinue()
//                    .verifyCheckoutErrorMessage("Error: Last Name is required")
//                    .cleanCheckoutForm()
//                    .fillCheckoutForm(FIRSTNAME, LASTNAME, EMPTY)
//                    .clickContinue()
//                    .verifyCheckoutErrorMessage("Error: Postal Code is required")
//                    .clickErrorButton()
//                    .verifyErrorMessageIsNotDisplayed()
//                    .cleanCheckoutForm()
//                    .fillCheckoutForm(FIRSTNAME, LASTNAME, ZIPCODE)
//                    .clickContinue()
//                    .openPage()
//                    .fillCheckoutForm("dope", EMPTY, EMPTY)
//                    .clickContinue()
//                    .clickErrorButton()
//                    .chainLink()
//                    .openPage()
//                    .clickCancelBtn("https://www.saucedemo.com/inventory.html")
//                    .openPage()
//                    .validateNumberOfProducts(1)
//                    .validateProductDetails(PRODUCTNAME, 1, "$29.99")
//                    .clickFinishBtn("https://www.saucedemo.com/checkout-complete.html");
//        }
//    }
    }
}
