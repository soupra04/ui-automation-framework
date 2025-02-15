package pages.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.CommonToAllPages;
import utils.PropertiesReader;

public class LoginPage_PF extends CommonToAllPages {
	// param
	public LoginPage_PF(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// page locators

	@FindBy(id = "login-username")
	private WebElement username;

	@FindBy(id = "login-password")
	private WebElement password;

	@FindBy(id = "js-login-btn")
	private WebElement signButton;

	@FindBy(id = "js-notification-box-msg")
	private WebElement error_message;

	// Page Actions
	public String loginToVWOInvalidCreds() {
		enterInput(username, PropertiesReader.readkey("invalid_username"));
		enterInput(password, PropertiesReader.readkey("invalid_password"));
		clickElement(signButton);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return error_message.getText();

	}
}
