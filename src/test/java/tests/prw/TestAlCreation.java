package tests.prw;

import org.testng.annotations.Test;

import base.CommonToAllTest;

import static org.assertj.core.api.Assertions.assertThat;

import driver.DriverManager;
import pages.pageObjectModal.prw.ICConsole;
import pages.pageObjectModal.prw.PrwLoginPage;
import utils.PropertiesReader;

public class TestAlCreation extends CommonToAllTest{
	
	@Test
	
	public void testAlCreation() {
		
		PrwLoginPage prwLoginPage = new PrwLoginPage(DriverManager.getDriver());
		String text = prwLoginPage.loginPage(PropertiesReader.readkey("prwqa1_eml"), PropertiesReader.readkey("prwqa1_pwd"));
		ICConsole alConsole = new ICConsole(DriverManager.getDriver());
		alConsole.createAssteList();
		assertThat(text).isNotNull().isNotBlank();
		assertThat(text).isEqualTo(PropertiesReader.readkey("prwqa1_text"));
	
	}

}