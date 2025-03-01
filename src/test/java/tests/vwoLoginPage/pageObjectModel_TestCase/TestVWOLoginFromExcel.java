package tests.vwoLoginPage.pageObjectModel_TestCase;

import org.testng.annotations.Test;
import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageObjectModal.vwo.LoginPage_POM;
import tests.UtilsExcelReader;

public class TestVWOLoginFromExcel extends CommonToAllTest {

    @Test(dataProvider = "getData", dataProviderClass = UtilsExcelReader.class)
    public void testLoginWithExcelData(String email, String password) {
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        loginPagePom.loginWith_excel(email, password); // ✅ Passing data from Excel
    }
}
