package web_sourcedemo.pages;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web_sourcedemo.context.UserAccount;

import java.io.File;
import java.io.IOException;
public class LoginPage extends BasePage {
    private static final String ERR_lOCKED_OUT = "Epic sadface: Sorry, this user has been locked out.";
    By txtUsername = By.cssSelector("input[data-test='username']");
    By txtPassword = By.cssSelector("input[data-test='password']");
    By btnLogin = By.cssSelector("input[data-test='login-button']");
    By lblErrMsg = By.cssSelector("div.error-message-container.error");
    String dataLoginStandard = "src/test/resources/TestData/StandardUser.json";
    String dataLoginNotStandard = "src/test/resources/TestData/NotStandardUser.json";
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public boolean isAt() {
        return driver.findElement(txtUsername).isDisplayed();
    }
    public boolean isUserLockedOut() {
        String error = driver.findElement(lblErrMsg).getText();
        if(error.equals(ERR_lOCKED_OUT)) {
            return true;
        }
        return false;
    }
    public void login(String username, String password) {
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }
    public UserAccount getAccStandardUser() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(dataLoginStandard));
        String dtUsername = jsonNode.get("Username").asText();
        String dtPassword = jsonNode.get("Password").asText();
        return new UserAccount(dtUsername, dtPassword);
    }
    public UserAccount getAccNotStandardUser(String userNotStandard) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(dataLoginNotStandard));
        String dtUsername = jsonNode.get(userNotStandard).asText();
        String dtPassword = "secret_sauce";
        return new UserAccount(dtUsername, dtPassword);
    }
    public void loginStandardUser() throws IOException {
        login(getAccStandardUser().getUsername(), getAccStandardUser().getPassword());
    }
    public void loginLockOutUser() throws IOException {
        login(getAccNotStandardUser("LockOutUser").getUsername(),
                getAccNotStandardUser("LockOutUser").getPassword());
    }
}