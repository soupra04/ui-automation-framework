package pages.pageObjectModal.demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.CommonToAllPages;
import driver.DriverManager;
import utils.PropertiesReader;

public class LoginPageDemoQA_POM extends CommonToAllPages {
	
	WebDriver driver;
	
	public LoginPageDemoQA_POM(WebDriver driver) {
		this.driver = driver;
		
	}
	
	private  By thirdActionButton = By.xpath("//span[@id='edit-record-3']");
	
	
	public void logintoDemoQAPortal() {
		
		driver.get(PropertiesReader.readkey("demoqa_url"));
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(thirdActionButton)).click().build().perform();
		
		
		
		
		
	}

}
