package web_sourcedemo.tests.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import web_sourcedemo.pages.LoginPage;

import java.io.IOException;
public class TC003_LockedOutUser extends BaseTest {
    @Test
    public void TC003_LockedOutUser() throws IOException {
        LoginPage pgLogin = new LoginPage(driver);
        pgLogin.loginLockOutUser();
        Assert.assertTrue(pgLogin.isUserLockedOut());
    }
}