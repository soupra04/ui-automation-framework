package pages.pageObjectModal.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonToAllPages;
import utils.PropertiesReader;

public class LoginPage_Salesforce_POM extends CommonToAllPages {

	WebDriver driver;

	public LoginPage_Salesforce_POM(WebDriver driver) {

		this.driver = driver;
	}

	// locators

	private By email = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By loginToSandBox = By.xpath("//input[@id='Login']");

	// Actions
	public void loginWithValidCredsInSalesforce(String eml, String pwd) {
		driver.get(PropertiesReader.readkey("salesforce_url"));
		enterInput(email, eml);
		enterInput(password, pwd);
		clickElement(loginToSandBox);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
