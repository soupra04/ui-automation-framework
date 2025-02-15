package pages.pageObjectModal.callify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.CommonToAllPages;
import utils.PropertiesReader;
import java.time.Duration;

public class CallifyLoginPage_POM extends CommonToAllPages {

	WebDriver driver;

	public CallifyLoginPage_POM(WebDriver driver) {
		this.driver = driver;
	}

	// locators

	private By email = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='password']");
	private By submitButton = By.xpath("//button[normalize-space(text())='Log In']");
	private By publisherButton = By.xpath("//div[@id='tab-publishers']");
	private By AddPublisherButton = By.xpath("//button[span[normalize-space(.)='Add publisher']]");

	// actions

	public void loginWithValidCredentialsInCallify(String eml, String pwd) {
		// Navigate to the Callify login page
		driver.get(PropertiesReader.readkey("callify_url"));

		// Enter email and password
		enterInput(email, eml);
		enterInput(password, pwd);

		// Click the Submit button
		clickElement(submitButton);
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Wait for the publisher button to become visible and clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(publisherButton));

		// Use Actions class to interact with the publisher button
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(publisherButton)).click().build().perform();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// Click the add publisher  button
				clickElement(AddPublisherButton);
		
	}

}
