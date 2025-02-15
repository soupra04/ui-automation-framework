package pages.pageObjectModal.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonToAllPages;

public class DashboardPage_Salesforce_POM extends CommonToAllPages {

	WebDriver driver;

	public DashboardPage_Salesforce_POM(WebDriver driver) {

	}

	By namePresentAfterLogin = By.xpath("//span[@title='Enterprise Quoting']");

	public String loggedinText() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		presenceOfElement(namePresentAfterLogin);
		return getElement(namePresentAfterLogin).getText();

	}
}
