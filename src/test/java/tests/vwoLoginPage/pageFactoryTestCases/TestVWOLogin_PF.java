package tests.vwoLoginPage.pageFactoryTestCases;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.CommonToAllTest;
import driver.DriverManager;
import pages.pageFactory.LoginPage_PF;
import pages.pageObjectModal.vwo.LoginPage_POM;
import utils.PropertiesReader;




public class TestVWOLogin_PF extends CommonToAllTest {

	
	private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);
	
	@Test

	public void testLoginNegative_PF() {
		
		logger.info("Strating of the Test Cases page factory");

		WebDriver driver = DriverManager.getDriver();
		driver.get(PropertiesReader.readkey("url"));
		
		LoginPage_PF loginPagePom = new LoginPage_PF(driver);
		String error_msg = loginPagePom.loginToVWOInvalidCreds();
				

		assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(error_msg, PropertiesReader.readkey(error_msg));

	}

}
