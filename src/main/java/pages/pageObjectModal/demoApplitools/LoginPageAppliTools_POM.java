package pages.pageObjectModal.demoApplitools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.CommonToAllPages;
import utils.PropertiesReader;

public class LoginPageAppliTools_POM extends CommonToAllPages {

	WebDriver driver;

	public LoginPageAppliTools_POM(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By signin = By.xpath("//a[@id='log-in']");

	public void loginWithValidCredsinDemo(String user, String pwd) {
		driver.get(PropertiesReader.readkey("applitools_url"));
		enterInput(username, user);
		enterInput(password, pwd);
		clickElement(signin);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> priceList = driver.findElements(By.xpath("//tbody/tr/td[5]/span"));

		double totalAmount = 0.0;

		for (int i = 0; i < priceList.size(); i++) {
			System.out.println(priceList.get(i).getText());
			String amountText = priceList.get(i).getText().replace(",", "").replace("USD", "").trim();
			if (amountText.contains("+")) {

				totalAmount += Double.parseDouble(amountText.replace("+", ""));
			} else if (amountText.contains("-")) {

				totalAmount -= Double.parseDouble(amountText.replace("-", ""));
			}
		}
		System.out.println("Total amount is " + totalAmount);

	}

}
