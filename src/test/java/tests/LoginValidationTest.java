package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginValidationTest extends BaseTest {

    @Test
    public void verifyLoginPageTitle() {

        getDriver().get(url);
        //System.out.println("verify the title :"+driver.getTitle());
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
