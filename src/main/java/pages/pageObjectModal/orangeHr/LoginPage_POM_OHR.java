package pages.pageObjectModal.orangeHr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonToAllPages;
import utils.PropertiesReader;

public class LoginPage_POM_OHR extends CommonToAllPages {

	// https://awesomeqa.com/hr/web/index.php/auth/login

	// pparam cons
	WebDriver driver;

	public LoginPage_POM_OHR(WebDriver driver) {
		this.driver = driver;

	}

	// pagelocators

	private By username = By.xpath("//input[@placeholder='Username']");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By submit_btn = By.xpath("//button[@type='submit");
	private By error_msg_ohr = By.xpath("//p[text()='Invalid credentials']");

	// page actions

	public void loginToHRCreds(String user, String pwd) {
		driver.get(PropertiesReader.readkey("orange_hr"));
		visibilityOfElement(username);
		enterInput(username, user);
		enterInput(password, pwd);
		clickElement(submit_btn);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String loginToHRInvalidCred(String user, String pwd) {

		driver.get(PropertiesReader.readkey("orange_hr"));
		visibilityOfElement(username);
		enterInput(username, user);
		enterInput(password, pwd);
		clickElement(submit_btn);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String error_message_text_oh = driver.findElement(error_msg_ohr).getText();
		return error_message_text_oh;
	}

}
