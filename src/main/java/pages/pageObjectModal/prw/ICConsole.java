package pages.pageObjectModal.prw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
    private String selectIcItemCheckbox = "(//lightning-formatted-rich-text[span[normalize-space()='Covered']]/ancestor::tr)[30]/td/preceding-sibling::td//input[@type='checkbox']";
   private By showIcItem = By.xpath("//lightning-formatted-rich-text[contains(., 'Internal Contract Items of')]");
   private By createALButton = By.xpath("//button[@title='Create/Add AL']"); 
	private By alText = By.xpath("//h2[normalize-space(text())='Add to Asset List Items']");
   
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
		
		System.out.println("in progress stage" + inprogressStage.get(0));
		
		WebElement firstInprogressIC = driver.findElement(By.xpath("(//lightning-formatted-rich-text[span[normalize-space()='In Progress']])[1]"));
		
		wait1.until(ExpectedConditions.textToBePresentInElement(firstInprogressIC, "In Progress"));
       
		
		WebElement correctBoMRow = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectedCheckbox)));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", correctBoMRow);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
            // Ensure the element is clickable
            WebElement clickableCheckbox = wait1.until(ExpectedConditions.elementToBeClickable(correctBoMRow));
            clickableCheckbox.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted! Trying JavaScript click for selecting IC.");
            js.executeScript("arguments[0].click();", correctBoMRow);
        }
        
        wait1.until(ExpectedConditions.attributeToBe(correctBoMRow, "checked", "true"));
        System.out.println("Correct ICx is checked successfully");
        
        wait1.until(ExpectedConditions.visibilityOfElementLocated(showIcButton));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		moveToElementAndClick(showIcButton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(showIcItem));
		WebElement icItemText = driver.findElement(showIcItem);
		System.out.println("this is IC item"+icItemText.getText());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WebElement correctIcitem = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectIcItemCheckbox)));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", correctIcitem);
        
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
            // Ensure the element is clickable
             wait1.until(ExpectedConditions.elementToBeClickable(correctIcitem));
             correctIcitem.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted! Trying JavaScript click for selecting Ic Item.");
            js.executeScript("arguments[0].click();", correctIcitem);
        }
        wait1.until(ExpectedConditions.attributeToBe(correctIcitem, "checked", "true"));
        System.out.println("Correct BoX Ic Item is checked successfully");
        
		
		
        wait1.until(ExpectedConditions.visibilityOfElementLocated(createALButton));
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        WebElement addAlButton = driver.findElement(createALButton);
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'start'});", addAlButton);
		moveToElementAndClick(createALButton);
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(alText));
		 
		 
        

}
}