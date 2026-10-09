package flows;

import pages.LoginPage;
import pages.SecureAreaPage;
import utils.PageObjectManager;

public class LoginFlow {

    private final LoginPage loginPage;
    private final SecureAreaPage secureAreaPage;

    public LoginFlow(PageObjectManager pageObjectManager) {
        this.loginPage = pageObjectManager.getLoginPage();
        this.secureAreaPage = pageObjectManager.getSecureAreaPage();
    }


    public SecureAreaPage login(String username, String password) {
        loginPage.openLoginPage();
        loginPage.login(username, password);
        return secureAreaPage;
    }

}
