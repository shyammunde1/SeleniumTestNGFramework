package pages;

import basepages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {


    private final By secureAreaMessage = By.id("flash");
    private final By logoutButton = By.cssSelector("a[href='/logout']");

    public SecureAreaPage(WebDriver driver, int timeout) {
        super(driver, timeout);

    }

    public String getSecureAreaMessage() {
        return getText(secureAreaMessage);
    }

    public void clickLogout() {
        click(logoutButton);
    }
}
