package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver(String browser) {


        if (browser == null || browser.isEmpty()) {

            throw new RuntimeException(
                    "Browser configuration is missing or empty");

        } else if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());

        } else {
            throw new RuntimeException(
                    "Unsupported browser: " + browser);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() !=null){
            driver.get().quit();
            driver.remove();

        }
    }
}
