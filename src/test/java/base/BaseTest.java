package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.PageObjectManager;


public class BaseTest {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<PageObjectManager> pageObjectManager =
            new ThreadLocal<>();

    protected final ConfigReader configReader = new ConfigReader();
    protected int timeout;
    protected String url;


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        String browser = configReader.getProperty("browser");
        timeout = configReader.getIntProperty("timeout");
        url = configReader.getProperty("url");
        DriverFactory.createDriver(browser);
        WebDriver currentDriver = DriverFactory.getDriver();
        driver.set(currentDriver);
        currentDriver.manage().window().maximize();
        pageObjectManager.set(
                new PageObjectManager(currentDriver, url, timeout)
        );


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
        } finally {
            driver.remove();
            pageObjectManager.remove();
        }

    }


    public WebDriver getDriver() {
        return driver.get();
    }

    protected PageObjectManager getPageObjectManager() {
        return pageObjectManager.get();
    }
}


