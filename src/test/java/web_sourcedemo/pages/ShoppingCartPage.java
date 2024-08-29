package web_sourcedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {
    By lstProduct = By.cssSelector("div[data-test='inventory-item']");
    By lstProduct_title = By.cssSelector("a[data-test*='title-link']");
    By btnCart = By.cssSelector("a[data-test='shopping-cart-link']");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    private WebElement getProduct(String title) {
        return driver.findElements(lstProduct)
                .stream()
                .filter(element -> element.findElement(lstProduct_title).getText().equals(title))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public boolean isProductInCart(String title) {
        return getProduct(title).isDisplayed();
    }
    public ShoppingCartPage open() {
        driver.findElement(btnCart).click();
        return this;
    }
    public CheckoutPage checkout() {
        driver.findElement(By.cssSelector("button[data-test='checkout']")).click();
        return new CheckoutPage(driver);
    }
}