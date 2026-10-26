
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class CucumberHooks {

    private static final ThreadLocal<LoginPage> loginPage =
            new ThreadLocal<>();

    private static final ThreadLocal<SecureAreaPage> secureAreaPage =
            new ThreadLocal<>();

    @Before
    public void setUp() {
        ConfigReader config = new ConfigReader();

        String browser = config.getProperty("browser");
        String url = config.getProperty("url");
        int timeout = config.getIntProperty("timeout");

        DriverFactory.createDriver(browser);

        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        loginPage.set(new LoginPage(driver, url, timeout));
        secureAreaPage.set(new SecureAreaPage(driver, timeout));
    }

    @After
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
        } finally {
            loginPage.remove();
            secureAreaPage.remove();
        }
    }

    public static LoginPage getLoginPage() {
        LoginPage page = loginPage.get();

        if (page == null) {
            throw new IllegalStateException(
                    "LoginPage is not initialized. Check Cucumber hooks."
            );
        }

        return page;
    }

    public static SecureAreaPage getSecureAreaPage() {
        SecureAreaPage page = secureAreaPage.get();

        if (page == null) {
            throw new IllegalStateException(
                    "SecureAreaPage is not initialized. Check Cucumber hooks."
            );
        }

        return page;
    }
}
