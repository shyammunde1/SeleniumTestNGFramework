package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.TestDataReader;

public class LoginTest extends BaseTest {

    private final TestDataReader testDataReader = new TestDataReader();

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {
                        testDataReader.getTestData("valid.username"),
                        testDataReader.getTestData("valid.password"),
                        testDataReader.getTestData("valid.expectedMessage")
                },
                {
                        testDataReader.getTestData("invalid.username"),
                        testDataReader.getTestData("invalid.password"),
                        testDataReader.getTestData("invalid.expectedMessage")
                },
                {
                        testDataReader.getTestData("wrongPassword.username"),
                        testDataReader.getTestData("wrongPassword.password"),
                        testDataReader.getTestData("wrongPassword.expectedMessage")
                }
        };
    }

    @Test(dataProvider = "loginData", groups = "smoke")
    public void loginTest(String username, String password, String expectedMessage) {
        //open login webpage
        LoginPage loginPage = pageObjectManager.getLoginPage();
        loginPage.openLoginPage();
        //passing the username and password
        loginPage.login(username, password);
        //verify the login success
        String actualMessage = loginPage.getLoginMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message: " + expectedMessage +
                        " but actual message was: " + actualMessage);
    }

    @Test(groups = "smoke")
    public void verifySecureArea() {
        LoginPage loginPage = pageObjectManager.getLoginPage();
        SecureAreaPage secureAreaPage = pageObjectManager.getSecureAreaPage();

        String username = testDataReader.getTestData("valid.username");
        String password = testDataReader.getTestData("valid.password");
        String expectedMessage =
                testDataReader.getTestData("valid.expectedMessage");

        loginPage.openLoginPage();
        loginPage.login(username, password);

        String actualMessage = secureAreaPage.getSecureAreaMessage();

        //String expectedMessage = "wrong message";

        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message: " + expectedMessage
                        + " but actual message was: " + actualMessage);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("===== BEFORE CLASS =====");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("===== AFTER CLASS =====");
    }

}
