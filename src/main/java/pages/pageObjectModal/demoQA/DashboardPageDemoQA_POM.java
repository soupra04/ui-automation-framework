package pages.pageObjectModal.demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import base.CommonToAllPages;

public class DashboardPageDemoQA_POM extends CommonToAllPages {
	WebDriver driver;

	public DashboardPageDemoQA_POM(WebDriver driver) {
		this.driver = driver;
	}

	private By dashboardHeaderText = By.xpath("//h1[@class='text-center']");
	private By crossButton = By.xpath("//button[@class='close']");
	private By addRwoButton = By.xpath("//button[@id='addNewRecordButton']");
	private By firstName = By.xpath("//input[@id='firstName']");
	private By lastName = By.xpath("//input[@id='firstName']");
	private By email = By.xpath("//input[@id='userEmail']");
	private By age = By.xpath("//input[@id='age']");
	private By salary = By.xpath("//input[@id='salary']");
	private By department = By.xpath("//input[@id='department']");

	public String getDashboardHeaderText() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		presenceOfElement(dashboardHeaderText);
		return getElement(dashboardHeaderText).getText();

	}

	public void clickonCrossButton() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clickElement(crossButton);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(addRwoButton);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearElement(firstName);
		enterInput(firstName, "Soupra");
		clearElement(lastName);
		enterInput(lastName, "Maity");
		clearElement(email);
		enterInput(email, "soupra@example.com");
		clearElement(age);
		enterInput(age, "30");
		clearElement(salary);
		enterInput(salary, "100000");
		clearElement(department);
		enterInput(department, "SDET Engineer");
		

	}

}
