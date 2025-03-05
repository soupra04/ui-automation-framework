package pages.pageObjectModal.prw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.CommonToAllPages;

public class ICConsole extends CommonToAllPages {
	
	WebDriver driver;
	
	public ICConsole(WebDriver driver) {
		this.driver = driver;
		
	}
	
	private By rmConsoleTab = By.xpath("//a[@title='Renewal Manager - Console']");
	private By rnConsoleText = By.xpath("//h1[normalize-space(text())='Renewal Manager - Console']");
	private By assignContractAccTab = By.xpath("(//li[@role='presentation'])[1]/a/div/span[normalize-space(text())='Assign Contracts : Accounts']");
	private By icTab = By.xpath("(//li[@role='presentation'])[4]/a/div/span[normalize-space(text())='Internal Contracts']");
	private By icText = By.xpath("//lightning-formatted-rich-text[span[normalize-space(text())='Internal Contracts']]");
	private By tablePresent = By.xpath("//table[contains(@class, 'slds-table') and contains(@class, 'extRelList')]");
   private String selectedCheckbox = "(//lightning-formatted-rich-text[span[normalize-space()='In Progress']]/ancestor::tr)[1]/td/preceding-sibling::td//input[@type='checkbox']";
    private By showIcButton = By.xpath("//button[@title='Show related IC Items']");

	public void createAssteList() {
		
		moveToElementAndClick(rmConsoleTab);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rnConsoleText));
		moveToElementAndClick(icTab);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(icText));
		WebElement icTextString = driver.findElement(icText);
		System.out.println(icTextString.getText());
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(tablePresent));
		WebElement table = driver.findElement(By.xpath("//table[contains(@class, 'slds-table') and contains(@class, 'extRelList')]"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

		
		for (int i= 0; i<rows.size(); i++ ) {
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			for (int j=0; j<columns.size();j++) {
				System.out.printf("%-20s", columns.get(j).getText());
			}
			System.out.println();
		}
		
		List<WebElement> inprogressStage = driver.findElements(By.xpath("//lightning-formatted-rich-text[span[normalize-space()='In Progress']]"));
		
		System.out.println(inprogressStage.get(0));
		
		WebElement firstInprogressIC = driver.findElement(By.xpath("(//lightning-formatted-rich-text[span[normalize-space()='In Progress']])[1]"));
		
		wait1.until(ExpectedConditions.textToBePresentInElement(firstInprogressIC, "In Progress"));
        WebElement correctBoMRow = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectedCheckbox)));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", correctBoMRow);

        if (!Boolean.parseBoolean(correctBoMRow.getAttribute("checked"))) {
            correctBoMRow.click();
        }
        wait1.until(ExpectedConditions.attributeToBe(correctBoMRow, "checked", "true"));
        System.out.println("Correct BoM CheckBox is checked successfully");
        
        wait1.until(ExpectedConditions.visibilityOfElementLocated(showIcButton));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
