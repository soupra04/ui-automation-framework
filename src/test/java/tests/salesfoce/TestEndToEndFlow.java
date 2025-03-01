package tests.salesfoce;

import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageObjectModal.salesforce.DashboardPage_Salesforce_POM;
import pages.pageObjectModal.salesforce.EndToEndFlow;
import pages.pageObjectModal.salesforce.LoginPage_Salesforce_POM;
import utils.PropertiesReader;

public class TestEndToEndFlow extends CommonToAllTest {
	
	@Test
	public void endToEnd() {
		LoginPage_Salesforce_POM loginPageSalesforcePom = new LoginPage_Salesforce_POM(DriverManager.getDriver());

		loginPageSalesforcePom.loginWithValidCredsInSalesforce(PropertiesReader.readkey("salesforce_email"),
				PropertiesReader.readkey("salesforce_password"));
		
		DashboardPage_Salesforce_POM dashboardPageSalesforcePom = new DashboardPage_Salesforce_POM(
				DriverManager.getDriver());
		
		EndToEndFlow endToEndFlow = new EndToEndFlow(DriverManager.getDriver());
		//endToEndFlow.importDeal();
		endToEndFlow.createQuote();
		
	}

}
