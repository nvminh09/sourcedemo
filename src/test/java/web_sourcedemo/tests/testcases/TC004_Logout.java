package web_sourcedemo.tests.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import web_sourcedemo.enums.AppMenu;
import web_sourcedemo.pages.HeaderPage;
import web_sourcedemo.pages.LoginPage;

import java.io.IOException;

public class TC004_Logout extends BaseTest {
    @Test
    public void TC004_Logout() throws IOException {
        LoginPage pgLogin = new LoginPage(driver);
        pgLogin.loginStandardUser();
        new HeaderPage(driver).navigateToMenu(AppMenu.LOGOUT);
        Assert.assertTrue(pgLogin.isAt());
    }
}