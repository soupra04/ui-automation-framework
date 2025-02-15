package tests.callifyLoginPage;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageObjectModal.callify.CallifyLoginPage_POM;
import pages.pageObjectModal.callify.DashboardPage_POM_Callify;
import utils.PropertiesReader;

public class TestCallifyLogin_POM extends CommonToAllTest {
	
	
	@Test
	public void testPositive() {
		
		CallifyLoginPage_POM callifyLoginPagePom = new CallifyLoginPage_POM(DriverManager.getDriver());
		callifyLoginPagePom.loginWithValidCredentialsInCallify(PropertiesReader.readkey("callify_validEmail"), PropertiesReader.readkey("callify_validPassword"));
		
		DashboardPage_POM_Callify dashboardPagePOMCallify = new DashboardPage_POM_Callify();
		String loggedInCallifyUsername = dashboardPagePOMCallify.loggedInCallifyUsername();
		
		assertThat(loggedInCallifyUsername).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(loggedInCallifyUsername, PropertiesReader.readkey("expected_name_onCallify_dashbaord"));
		
	}

}
