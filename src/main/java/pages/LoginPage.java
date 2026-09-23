package pages;

import basepages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    String url;
    int timeout;

    By username = By.id("username");
    By password = By.id("password");
    By button = By.cssSelector("button[type='submit']");
    By successMessage = By.id("flash");

    public LoginPage(WebDriver driver, String url, int timeout) {
        super(driver, timeout);
        this.url = url;
        this.timeout=timeout;

    }

    public SecureAreaPage login(String username, String password ) {
        sendKey(this.username, username);
        sendKey(this.password, password);
        click(button);
        return new SecureAreaPage(driver,timeout);
    }

    public String getSuccessMessage() {

        return getText(successMessage);
    }

    public void openLoginPage() {

        driver.get(url);
    }
}
