package flows;

import pages.SecureAreaPage;

public class LogoutFlow {

    private final SecureAreaPage secureAreaPage;

    public LogoutFlow(SecureAreaPage secureAreaPage) {
        this.secureAreaPage = secureAreaPage;
    }

    public void logout() {
        secureAreaPage.clickLogout();
    }
}

