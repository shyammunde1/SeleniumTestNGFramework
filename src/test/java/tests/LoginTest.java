package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SecureAreaPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!"},
                {"sam", "SuperSecretPassword!", "Your username is invalid!"},
                {"tomsmith", "wrongPassword", "Your password is invalid!"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedMessage) {
        //open login webpage
        loginPage.openLoginPage();
        //passing the username and password
        loginPage.login(username, password);
        //verify the login success
        String actualMessage = loginPage.getLoginMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message: " + expectedMessage +
                        "but actual message was: " + actualMessage);
    }

    @Test
    public void verifySecureArea() {

        loginPage.openLoginPage();
        loginPage.login("tomsmith", "SuperSecretPassword!");
        SecureAreaPage secureAreaPage = pageObjectManager.getSecureAreaPage();
        String actualMessage = secureAreaPage.getSecureAreaMessage();
        String expectedMessage = "You logged into a secure area!";
        //String expectedMessage = "wrong message";

        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message: " + expectedMessage +
                        "but actual message was: " + actualMessage);
    }

}
