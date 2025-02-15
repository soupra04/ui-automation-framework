package pages.pageObjectModal.orangeHr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonToAllPages;

public class DashboardPage_POM_OHR extends CommonToAllPages {

	WebDriver driver;

	public DashboardPage_POM_OHR(WebDriver driver) {
		this.driver = driver;
	}

	By userNameOnDashboard = By.xpath("//h6[normalize-space()='PIM");

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
