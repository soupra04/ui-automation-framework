package pages.pageObjectModal.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonToAllPages;

public class DashboardPage_POM extends CommonToAllPages {

	WebDriver driver;

	public DashboardPage_POM(WebDriver driver) {
		this.driver = driver;
	}

	By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

	// Page Actions
	public String loggedInUserName() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		presenceOfElement(userNameOnDashboard);
		return getElement(userNameOnDashboard).getText();
	}
}
