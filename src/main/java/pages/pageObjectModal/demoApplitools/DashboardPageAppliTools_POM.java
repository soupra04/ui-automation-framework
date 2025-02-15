package pages.pageObjectModal.demoApplitools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonToAllPages;

public class DashboardPageAppliTools_POM extends CommonToAllPages{
	
	WebDriver driver;
	
	public DashboardPageAppliTools_POM(WebDriver driver) {
		this.driver = driver;
		
	}
	By NameOnDashboard = By.xpath("//h6[@id='time' and contains(text(),'Your nearest branch closes in: 30m 5s')]");
	
	// Page Actions
		public String loggedInUserName() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			presenceOfElement(NameOnDashboard);
			return getElement(NameOnDashboard).getText();
		}
}
