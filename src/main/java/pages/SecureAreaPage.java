package pages;

import basepages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {



     By secureAreaMessage = By.id("flash");

    public SecureAreaPage(WebDriver driver,int timeout) {
      super(driver, timeout);

    }

    public String getSecureAreaMessage(){
        return getText(secureAreaMessage);
    }
}
