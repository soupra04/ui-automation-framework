package pages.pageObjectModal.prw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.CommonToAllPages;

public class IcConsoleTest extends CommonToAllPages {

	WebDriver driver;

	public IcConsoleTest(WebDriver driver) {
		this.driver = driver;

	}

	private By rmConsoleTab = By.xpath("//a[@title='Renewal Manager - Console']");
	private By rnConsoleText = By.xpath("//h1[normalize-space(text())='Renewal Manager - Console']");
	private By assignContractAccTab = By
			.xpath("(//li[@role='presentation'])[1]/a/div/span[normalize-space(text())='Assign Contracts : Accounts']");
	private By icTab = By
			.xpath("(//li[@role='presentation'])[4]/a/div/span[normalize-space(text())='Internal Contracts']");
	private By icText = By.xpath("//lightning-formatted-rich-text[span[normalize-space(text())='Internal Contracts']]");
	private By tablePresent = By.xpath("//table[contains(@class, 'slds-table') and contains(@class, 'extRelList')]");
	private String selectedCheckbox = "(//lightning-formatted-rich-text[span[normalize-space()='In Progress']]/ancestor::tr)[1]/td/preceding-sibling::td//input[@type='checkbox']";
	private By showIcButton = By.xpath("//button[@title='Show related IC Items']");
	private String selectIcItemCheckbox = "(//lightning-formatted-rich-text[span[normalize-space()='Covered']]/ancestor::tr)[30]/td/preceding-sibling::td//input[@type='checkbox']";
	private By showIcItem = By.xpath("//lightning-formatted-rich-text[contains(., 'Internal Contract Items of')]");
	private By createALButton = By.xpath("//button[@title='Create/Add AL']");
	private By alText = By.xpath("//h2[normalize-space(text())='Add to Asset List Items']");

	public void selectIcItem() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		moveToElementAndClick(rmConsoleTab);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rnConsoleText));
		moveToElementAndClick(icTab);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(icText));
		WebElement icTextString = driver.findElement(icText);
		System.out.println(icTextString.getText());

		wait1.until(ExpectedConditions.visibilityOfElementLocated(tablePresent));
		WebElement table = driver
				.findElement(By.xpath("//table[contains(@class, 'slds-table') and contains(@class, 'extRelList')]"));

		// Locate all rows where the stage column contains 'In Progress'
		List<WebElement> inProgressrows = driver.findElements(
				By.xpath("//td[.//lightning-formatted-rich-text[.//span[normalize-space()='In Progress']]]"));

		for (WebElement rows : inProgressrows) {
			System.out.println("Selecting the checkbox where stage=In Progress" + rows.getText());

			WebElement checkbox = rows.findElement(By.xpath("preceding-sibling::td//input[@type='checkbox']"));
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkbox);

			// to select the checkbox which is In progress stage
			if (!checkbox.isSelected()) {
				js.executeScript("arguments[0].click();", checkbox);

				System.out.println("Checkbox is selected.");
			} else {
				System.out.println("Checkbox was already selected.");
			}
			
			// Wait for a moment to confirm the checkbox remains selected
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Re-check the checkbox state
			if (!checkbox.isSelected()) {
			    System.out.println("Checkbox got deselected! Retrying selection...");
			    js.executeScript("arguments[0].click();", checkbox);
			    try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Give it some time to stabilize
			}

			System.out.println("Final checkbox state: " + checkbox.isSelected());

			wait1.until(ExpectedConditions.visibilityOfElementLocated(showIcButton));
			

			moveToElementAndClick(showIcButton);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(showIcItem));
		WebElement icItemText = driver.findElement(showIcItem);
		System.out.println("this is IC item"+icItemText.getText());
		
		List<WebElement> inprocessRows = driver.findElements(By.xpath("//td[.//lightning-formatted-rich-text[.//span[normalize-space()='Due for Renewal']]]"));
		
		for (WebElement inprocess : inprocessRows) {
			System.out.println("Selecting IcItem where its Inprocess" + inprocess.getText());
			
			WebElement checkIcItem = inprocess.findElement(By.xpath("preceding-sibling::td//input[@type='checkbox']"));
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkIcItem);

			if(!checkIcItem.isSelected()) {
				js.executeScript("arguments[0].click();", checkIcItem);
				System.out.println("Ic Item is Selected");
			
			} else {
				System.out.println("Already selected");
			}
			
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(createALButton));
		moveToElementAndClick(createALButton);
		
	}
	}
