package tests.demoQATestCases;

import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageObjectModal.demoQA.DashboardPageDemoQA_POM;
import pages.pageObjectModal.demoQA.LoginPageDemoQA_POM;
import utils.PropertiesReader;

import static org.assertj.core.api.Assertions.*;

public class TestDemoQA_POM extends CommonToAllTest {
	
	@Test
	public void loginToDemoQA() {
		
		LoginPageDemoQA_POM loginPageDemoQa = new LoginPageDemoQA_POM(DriverManager.getDriver());
		
		
		DashboardPageDemoQA_POM dashboardPageDemoqa = new DashboardPageDemoQA_POM(DriverManager.getDriver());
		
		loginPageDemoQa.logintoDemoQAPortal();
		
		String textMessage = dashboardPageDemoqa.getDashboardHeaderText();
		
		assertThat(textMessage).isNotBlank().isNotNull();
		assertThat(textMessage).isEqualTo(PropertiesReader.readkey("text_in_theUi"));
		
		dashboardPageDemoqa.clickonCrossButton();
		
		
		
	}

}
