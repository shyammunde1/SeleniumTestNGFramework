package utils;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SecureAreaPage;

public class PageObjectManager {

    private WebDriver driver;
    private String url;
    private int timeout;

    public PageObjectManager(WebDriver driver, String url, int timeout) {
        this.driver = driver;
        this.url = url;
        this.timeout = timeout;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver, url, timeout);
    }

    public SecureAreaPage getSecureAreaPage() {
        return new SecureAreaPage(driver, timeout);
    }
}
