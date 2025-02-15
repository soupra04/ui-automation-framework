package tests.salesfoce;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageObjectModal.salesforce.CreateQuoteFromBoM;
import pages.pageObjectModal.salesforce.DashboardPage_Salesforce_POM;
import pages.pageObjectModal.salesforce.LoginPage_Salesforce_POM;
import utils.PropertiesReader;

public class TestCreateQuote extends CommonToAllTest {
	
	@Test
	public void testCreationOfQuote() { 
		
		LoginPage_Salesforce_POM loginPageSalesforcePom = new LoginPage_Salesforce_POM(DriverManager.getDriver());

		loginPageSalesforcePom.loginWithValidCredsInSalesforce(PropertiesReader.readkey("salesforce_email"),
				PropertiesReader.readkey("salesforce_password"));
		
		DashboardPage_Salesforce_POM dashboardPageSalesforcePom = new DashboardPage_Salesforce_POM(
				DriverManager.getDriver());
		String loggedinText = dashboardPageSalesforcePom.loggedinText();
		
		assertThat(loggedinText).isNotBlank().isNotNull().isNotEmpty();
		
		CreateQuoteFromBoM createQuoteFromBoM = new CreateQuoteFromBoM(DriverManager.getDriver());
		createQuoteFromBoM.createQuoteFromBom();
		
		
		
		
	}
	

}
