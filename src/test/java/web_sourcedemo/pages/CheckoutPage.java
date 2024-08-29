package web_sourcedemo.pages;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web_sourcedemo.context.CheckoutInfo;

import java.io.File;
import java.io.IOException;

public class CheckoutPage {
    By txtFirstName = By.cssSelector("input[data-test='firstName']");
    By txtLastName = By.cssSelector("input[data-test='lastName']");
    By txtZipCode = By.cssSelector("input[data-test='postalCode']");
    By btnContinue = By.cssSelector("input[data-test='continue']");
    By btnFinish = By.cssSelector("button[data-test='finish']");
    String dataCheckout = "src/test/resources/TestData/CheckoutInfoUser.json";

    protected final WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isCheckoutComplete() {
        return driver.findElement(By.cssSelector("div[data-test='checkout-complete-container']")).isDisplayed();
    }
    public CheckoutInfo getDataCheckout() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(dataCheckout));
        String firstname = jsonNode.get("Firstname").asText();
        String lastname = jsonNode.get("Lastname").asText();
        String zipcode = jsonNode.get("Zipcode").asText();
        return new CheckoutInfo(firstname, lastname, zipcode);
    }
    public CheckoutPage setInformationAndCheckout() throws IOException {
        CheckoutInfo dtCheckout = getDataCheckout();
        driver.findElement(txtFirstName).sendKeys(dtCheckout.getFirstName());
        driver.findElement(txtLastName).sendKeys(dtCheckout.getLastName());
        driver.findElement(txtZipCode).sendKeys(dtCheckout.getZipCode());
        driver.findElement(btnContinue).click();
        return this;
    }
    public CheckoutPage finish() {
        driver.findElement(btnFinish).click();
        return this;
    }
}