package tests.salesfoce;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageObjectModal.salesforce.DashboardPage_Salesforce_POM;
import pages.pageObjectModal.salesforce.LoginPage_Salesforce_POM;
import pages.pageObjectModal.vwo.DashboardPage_POM;
import pages.pageObjectModal.vwo.LoginPage_POM;
import utils.PropertiesReader;

public class TestSalesforceLogin_POM extends CommonToAllTest {

	@Test

	public void testPositive() {
		LoginPage_Salesforce_POM loginPageSalesforcePom = new LoginPage_Salesforce_POM(DriverManager.getDriver());

		loginPageSalesforcePom.loginWithValidCredsInSalesforce(PropertiesReader.readkey("salesforce_email"),
				PropertiesReader.readkey("salesforce_password"));

		DashboardPage_Salesforce_POM dashboardPageSalesforcePom = new DashboardPage_Salesforce_POM(
				DriverManager.getDriver());
		String loggedinText = dashboardPageSalesforcePom.loggedinText();

		assertThat(loggedinText).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(loggedinText, PropertiesReader.readkey("expected_name_onSalesforce"));
	}

}
