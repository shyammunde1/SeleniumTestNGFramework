package basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver, int timeout) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));


    }

    public void sendKey(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();

    }
}
