package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginValidationTest extends BaseTest {

    @Test
    public void verifyLoginPageTitle(){
        driver.get("https://the-internet.herokuapp.com/login");
        //System.out.println("verify the title :"+driver.getTitle());
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
