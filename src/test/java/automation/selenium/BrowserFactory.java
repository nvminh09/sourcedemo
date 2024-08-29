package automation.selenium;

import automation.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    public static WebDriver launch(Browsers browser) {
        if (browser.equals(Browsers.CHROME)) {
            return new ChromeDriver();
        } else if (browser.equals(Browsers.FIREFOX)) {
            return new ChromeDriver();
        } else if (browser.equals(Browsers.EDGE)) {
            return new ChromeDriver();
        }
        return new ChromeDriver();
    }
}