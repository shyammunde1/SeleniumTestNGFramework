package utils;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SecureAreaPage;

public class PageObjectManager {

    private final WebDriver driver;
    private final String url;
    private final int timeout;
    private final LoginPage loginPage;
    private final SecureAreaPage secureAreaPage;

    public PageObjectManager(WebDriver driver, String url, int timeout) {
        this.driver = driver;
        this.url = url;
        this.timeout = timeout;
        this.loginPage = new LoginPage(driver, url, timeout);
        this.secureAreaPage = new SecureAreaPage(driver, timeout);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SecureAreaPage getSecureAreaPage() {
        return secureAreaPage;
    }
}
