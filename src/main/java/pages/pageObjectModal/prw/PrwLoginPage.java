package pages.pageObjectModal.prw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.CommonToAllPages;
import utils.PropertiesReader;

public class PrwLoginPage extends CommonToAllPages {
	
	WebDriver driver;
	
	public PrwLoginPage(WebDriver driver) {
		this.driver= driver;
		}
	
   private By email = By.xpath("//input[@type='email']");
   private By password = By.xpath("//input[@type='password']");
   private By login = By.xpath("//input[@type='submit']");
   private By prwText = By.xpath("//h1[span[@title='StrataVAR PRW']]");
	
   public String loginPage( String eml, String pwd) {
	   
	   driver.get(PropertiesReader.readkey("prwqa1_url"));
	   enterInput(email, eml);
	   enterInput(password, pwd);
	   clickElement(login);
	   wait1.until(ExpectedConditions.visibilityOfElementLocated(prwText));
	   String textinDashboard = driver.findElement(prwText).getText();
	   return textinDashboard;
	   
	   
	   
	   
   }
}
