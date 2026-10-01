package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.PageObjectManager;


public class BaseTest {


    protected WebDriver driver;
    protected final ConfigReader configReader = new ConfigReader();
    protected int timeout;
    protected String url;
    protected PageObjectManager pageObjectManager;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        String browser = configReader.getProperty("browser");
        timeout = configReader.getIntProperty("timeout");
        url = configReader.getProperty("url");
        DriverFactory.createDriver(browser);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        pageObjectManager = new PageObjectManager(driver, url, timeout);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
        driver = null;
    }


    public WebDriver getDriver() {
        return driver;
    }
}


