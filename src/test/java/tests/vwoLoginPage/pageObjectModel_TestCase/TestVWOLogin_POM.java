package tests.vwoLoginPage.pageObjectModel_TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.assertj.core.api.Assertions.*;
import io.qameta.allure.Description;
import pages.pageObjectModal.vwo.DashboardPage_POM;
import pages.pageObjectModal.vwo.LoginPage_POM;
import utils.ExtentReportManager;
import utils.PropertiesReader;

public class TestVWOLogin_POM extends CommonToAllTest {

	@Test(priority = 1)
	@Description("Test Description")
	public void testLoginNegativeVWO() {
		test = ExtentReportManager.createTest("login Test");

		LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
		String error_msg = loginPagePom.loginTOVWOwith_InvalidCredes(PropertiesReader.readkey("invalid_username"),
				PropertiesReader.readkey("invalid_password"));
		test.info("navigate to URL");
		test.info("Adding credentials");
		assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(error_msg, PropertiesReader.readkey(error_msg));

	}

	@Test(priority = 2)

	public void testPositive() {

		LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
		// String error_msg =
		// loginPagePom.loginTOVWOwith_InvalidCredes(PropertiesReader.readkey("invalid_username"),
		// PropertiesReader.readkey("invalid_password"));
		loginPagePom.loginTOVWOwith_validCredes(PropertiesReader.readkey("username"),
				PropertiesReader.readkey("password"));
		test.info("navigate to URL");
		test.info("Adding credentials");
		DashboardPage_POM dashboardPagePom = new DashboardPage_POM(DriverManager.getDriver());
		String loggedInusername = dashboardPagePom.loggedInUserName();
		test.info("Enter into Dashboard");
		assertThat(loggedInusername).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(loggedInusername, PropertiesReader.readkey("expected_username"));
		test.pass("login Successful");
	}

}
