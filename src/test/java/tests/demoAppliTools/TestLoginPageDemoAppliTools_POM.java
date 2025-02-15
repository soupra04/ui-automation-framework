package tests.demoAppliTools;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageObjectModal.demoApplitools.DashboardPageAppliTools_POM;
import pages.pageObjectModal.demoApplitools.LoginPageAppliTools_POM;
import utils.PropertiesReader;

public class TestLoginPageDemoAppliTools_POM extends CommonToAllTest{
	
	@Test
	
	public void test_positive() {
		
		LoginPageAppliTools_POM loginPageAppliTools = new LoginPageAppliTools_POM(DriverManager.getDriver());
		
		loginPageAppliTools.loginWithValidCredsinDemo(PropertiesReader.readkey("applitools_username"), PropertiesReader.readkey("applitools_password"));
		
		DashboardPageAppliTools_POM dashboardPageAppliTools = new DashboardPageAppliTools_POM(DriverManager.getDriver());
		String logginText = dashboardPageAppliTools.loggedInUserName();
		
		assertThat(logginText).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(logginText, PropertiesReader.readkey("expected_username_applitools"));
	}

}
