package tests.salesfoce;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import base.CommonToAllTest;
import driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.pageObjectModal.salesforce.DashboardPage_Salesforce_POM;
import pages.pageObjectModal.salesforce.ImportBoMs;
import pages.pageObjectModal.salesforce.LoginPage_Salesforce_POM;
import utils.PropertiesReader;

public class TestImportBoM extends CommonToAllTest {

	@Test (priority=1)
	@Description ("Testing Import of Disti BoM")
	@Severity(SeverityLevel.NORMAL)
	 @Owner("QA_Team")
	public void testImportBom() {
		
		LoginPage_Salesforce_POM loginPageSalesforcePom = new LoginPage_Salesforce_POM(DriverManager.getDriver());

		loginPageSalesforcePom.loginWithValidCredsInSalesforce(PropertiesReader.readkey("salesforce_email"),
				PropertiesReader.readkey("salesforce_password"));
		
				
		ImportBoMs importBoM = new ImportBoMs(DriverManager.getDriver());
		String totalPriceofDisti =  importBoM.importDisti();
		double actualPrice = Double.parseDouble(totalPriceofDisti.replace(",", ""));
		assertThat(totalPriceofDisti).isNotNull().isNotBlank();
		assertThat(actualPrice).isEqualTo(27248.00);
		 
	}
	@Test (priority=2)
	@Severity(SeverityLevel.CRITICAL)
	@Description ("Testing Import of Deal Reg BoM")
	 @Owner("QA_Team")
	public void testImportDeal() {
		
		LoginPage_Salesforce_POM loginPageSalesforcePom = new LoginPage_Salesforce_POM(DriverManager.getDriver());

		loginPageSalesforcePom.loginWithValidCredsInSalesforce(PropertiesReader.readkey("salesforce_email"),
				PropertiesReader.readkey("salesforce_password"));
		
		
		ImportBoMs importBoM  = new ImportBoMs(DriverManager.getDriver());
		String totalPriceofDeal = importBoM.importDeal();
		double totalPriceValueofDeal = Double.parseDouble(totalPriceofDeal.replace(",","" ));
		assertThat(totalPriceofDeal).isNotNull();
		assertThat(totalPriceValueofDeal).isEqualTo(18620.09);
		
	}
	
}
