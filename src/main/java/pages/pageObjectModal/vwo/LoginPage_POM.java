package pages.pageObjectModal.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonToAllPages;
import utils.PropertiesReader;

public class LoginPage_POM extends CommonToAllPages {

	WebDriver driver;

	// adding default constructor

	public LoginPage_POM(WebDriver driver) {

		this.driver = driver;

	}

	// page locators -step 1

	private By username = By.id("login-username");
	private By password = By.id("login-password");
	private By signButton = By.id("js-login-btn");
	private By error_message = By.id("js-notification-box-msg");

	// if you are not using free tiral then dont keep it

	// page actions -Step 2
	public String loginTOVWOwith_InvalidCredes(String user, String pwd) {
		driver.get(PropertiesReader.readkey("url"));
		enterInput(username, user);
		enterInput(password, pwd);
		clickElement(signButton);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String error_message_text = driver.findElement(error_message).getText();
		return error_message_text;

	}

	// valid scenarios
	public void loginTOVWOwith_validCredes(String user, String pwd) {

		driver.get(PropertiesReader.readkey("url"));
		enterInput(username, user);
		enterInput(password, pwd);
		clickElement(signButton);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
