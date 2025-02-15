package pages.pageObjectModal.callify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonToAllPages;

public class DashboardPage_POM_Callify extends CommonToAllPages {
	
	WebDriver driver;
	
	public DashboardPage_POM_Callify() {
		
		this.driver =driver;
	}

	
	   By usernameonDashbaordCallify = By.xpath("//p[text()='Dashboard']");
	   
	   public String loggedInCallifyUsername() {
		   
		   try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		   presenceOfElement(usernameonDashbaordCallify);
			return getElement(usernameonDashbaordCallify).getText();
		   
		   
	   }
}
