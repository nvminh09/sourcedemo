package web_sourcedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web_sourcedemo.config.EnvironmentVariables;
import web_sourcedemo.enums.AppMenu;

import java.time.Duration;
public class HeaderPage extends BasePage {
    By btnMenu = By.cssSelector("div.bm-burger-button");
    By navMenu = By.cssSelector("a.bm-item.menu-item");
    By lblCart = By.cssSelector("a.shopping_cart_link");
    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    public HeaderPage navigateToMenu(AppMenu menu) {
        driver.findElement(btnMenu).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvironmentVariables.WAIT_MAX));
        wait.until(ExpectedConditions.elementToBeClickable(navMenu));

        WebElement btnMenu = driver.findElements(navMenu)
                .stream()
                .filter(element -> element.getText().equalsIgnoreCase(menu.value()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        btnMenu.click();
        return this;
    }
    public int getCartCount() {
        String cartCount = driver.findElement(lblCart).getText();
        return cartCount.isEmpty() ? 0 : Integer.parseInt(cartCount);
    }
}