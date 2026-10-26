
package stepdefinitions;

import hooks.CucumberHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.TestDataReader;

public class LoginSteps {

    private final TestDataReader testDataReader = new TestDataReader();

    private String username;
    private String password;
    private String expectedMessage;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        LoginPage loginPage = CucumberHooks.getLoginPage();
        loginPage.openLoginPage();

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page was not displayed"
        );
    }

    @When("the user enters valid credentials")
    public void userEntersValidCredentials() {
        username = testDataReader.getTestData("valid.username");
        password = testDataReader.getTestData("valid.password");
        expectedMessage = testDataReader.getTestData("valid.expectedMessage");

        LoginPage loginPage = CucumberHooks.getLoginPage();
        loginPage.enterCredentials(username, password);
    }

    @When("the user clicks the login button")
    public void userClicksLoginButton() {
        CucumberHooks.getLoginPage().clickLoginButton();
    }


    @Then("the secure area should be displayed")
    public void secureAreaShouldBeDisplayed() {
        SecureAreaPage secureAreaPage = CucumberHooks.getSecureAreaPage();

        String actualMessage = secureAreaPage.getSecureAreaMessage();

        Assert.assertTrue(
                actualMessage.contains(expectedMessage),
                "Expected message: " + expectedMessage
                        + " but actual message was: " + actualMessage
        );
    }

}
