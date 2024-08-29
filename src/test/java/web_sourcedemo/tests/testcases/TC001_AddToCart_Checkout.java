package web_sourcedemo.tests.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import web_sourcedemo.pages.CheckoutPage;
import web_sourcedemo.pages.LoginPage;
import web_sourcedemo.pages.ProductsPage;
import web_sourcedemo.pages.ShoppingCartPage;

import java.io.IOException;

public class TC001_AddToCart_Checkout extends BaseTest {
    // TODO: Data provider
    String prod1 = "Sauce Labs Onesie";
    String prod2 = "Test.allTheThings() T-Shirt (Red)";
    @Test
    public void TC001_AddToCart_Checkout() throws IOException{
        // TODO: login with Standard User
        new LoginPage(driver).loginStandardUser();
        // TODO: add production
        new ProductsPage(driver).add(prod1).add(prod2);
        // TODO: checkout
        CheckoutPage pgCheckout = new ShoppingCartPage(driver).open().checkout().setInformationAndCheckout().finish();
        Assert.assertTrue(pgCheckout.isCheckoutComplete());
    }
}