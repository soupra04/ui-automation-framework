package tests.orangeHR;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageObjectModal.orangeHr.DashboardPage_POM_OHR;
import pages.pageObjectModal.orangeHr.LoginPage_POM_OHR;
import utils.PropertiesReader;

public class TestOrangeHR_POM extends CommonToAllTest {

	// @Test
	public void testLoginPositive() {
		LoginPage_POM_OHR loginPagePomOhr = new LoginPage_POM_OHR(DriverManager.getDriver());
		loginPagePomOhr.loginToHRCreds(PropertiesReader.readkey("orghr_username"),
				PropertiesReader.readkey("orghr_password"));

		DashboardPage_POM_OHR dashboardPagePomOhr = new DashboardPage_POM_OHR(DriverManager.getDriver());
		String loggedInusername = dashboardPagePomOhr.loggedInUserName();

		assertThat(loggedInusername).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(loggedInusername, PropertiesReader.readkey("expected_username_ohr"));

	}

	@Test(priority = 1)

	public void testLoginNegative() {

		LoginPage_POM_OHR loginPagePomOhr = new LoginPage_POM_OHR(DriverManager.getDriver());
		String error_msg_ohr = loginPagePomOhr.loginToHRInvalidCred(PropertiesReader.readkey("orghr_invalidUserName"),
				PropertiesReader.readkey("orghr_invalidPassword"));

		assertThat(error_msg_ohr).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(error_msg_ohr, PropertiesReader.readkey(error_msg_ohr));

	}

}
