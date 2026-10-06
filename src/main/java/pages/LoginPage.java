package pages;

import basepages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private final String url;

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By button = By.cssSelector("button[type='submit']");
    private final By successMessage = By.id("flash");

    public LoginPage(WebDriver driver, String url, int timeout) {
        super(driver, timeout);
        this.url = url;
    }

    public void login(String username, String password) {
        clearAndSendKey(this.username, username);
        clearAndSendKey(this.password, password);
        click(button);

    }

    public String getLoginMessage() {

        return getText(successMessage);
    }

    public void openLoginPage() {

        driver.get(url);
    }
}
