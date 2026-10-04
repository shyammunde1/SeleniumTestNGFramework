package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver(String browser) {


        if (browser == null || browser.isBlank()) {

            throw new RuntimeException(
                    "Browser configuration is missing or empty");

        }

        if (driver.get() != null) {
            quitDriver();

        }

        browser = browser.trim().toLowerCase();
        switch (browser) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            default:
                throw new RuntimeException(
                        "Unsupported browser: " + browser
                );

        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();

        }
    }
}
