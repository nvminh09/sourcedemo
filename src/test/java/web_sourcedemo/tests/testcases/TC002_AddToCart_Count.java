package web_sourcedemo.tests.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import web_sourcedemo.enums.AppMenu;
import web_sourcedemo.pages.HeaderPage;
import web_sourcedemo.pages.LoginPage;
import web_sourcedemo.pages.ProductsPage;

import java.io.IOException;

public class TC002_AddToCart_Count extends BaseTest {
    // TODO: Data provider
    String prod1 = "Sauce Labs Onesie";
    @Test
    public void TC002_AddToCart_Count() throws IOException {
        new LoginPage(driver).loginStandardUser();
        new ProductsPage(driver).add(prod1);
        HeaderPage pgHeader = new HeaderPage(driver);
        Assert.assertEquals(pgHeader.getCartCount(), 1);
        new HeaderPage(driver).navigateToMenu(AppMenu.LOGOUT);
    }
}