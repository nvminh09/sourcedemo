package web_sourcedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {
    By drpSort = By.cssSelector("select[data-test='product-sort-container']");
    By lstProduct = By.cssSelector("div[data-test='inventory-item']");
    By lstProduct_title = By.cssSelector("a[data-test*='title-link']");
    By getLstProduct_add = By.cssSelector("button[data-test*='add-to-cart']");
    By getLstProduct_remove = By.cssSelector("button[data-test*='remove']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    private WebElement getProduct(String title) {
        return driver.findElements(lstProduct)
                .stream()
                .filter(element -> element.findElement(lstProduct_title).getText().equals(title))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public ProductsPage sort(String orderBy) {
        WebElement dropdown = driver.findElement(drpSort);
        Select select = new Select(dropdown);
        select.selectByVisibleText(orderBy);
        return this;
    }
    public ProductsPage add(String title) {
        getProduct(title).findElement(getLstProduct_add).click();
        return this;
    }
    public ProductsPage remove(String title) {
        getProduct(title).findElement(getLstProduct_remove).click();
        return this;
    }

}
