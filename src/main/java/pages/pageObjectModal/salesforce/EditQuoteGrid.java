package pages.pageObjectModal.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.CommonToAllPages;

public class EditQuoteGrid extends CommonToAllPages {
	WebDriver driver;

	public EditQuoteGrid(WebDriver driver) {
		this.driver = driver;
	}

	private By quote = By.xpath("//a[@title='VCT Quotes']");
	private By quoteName = By.xpath("//a[@title='QT-000100353']");
	private By editQuoteButton = By.xpath("//li[@data-target-selection-name='sfdc:CustomButton.StrataVAR__CustomerBoM__c.StrataVAR__Edit_Quote']//button[normalize-space(text())='Edit Quote']");
	//private By totalListPrice = By.xpath("//div[@id='qtWrapper']/div[1]/div[1]/div[1]/div/div[1]");
    private By loadingText = By.xpath("//div[contains(@class, 'auraLoadingBox') and contains(@class, 'oneLoadingBox')]//div[contains(@class, 'loadingText')]");
	//private By groupText = By.xpath("//table[@id='qtGrid']/tbody/tr[16]/td[1]/span[3]");
	//private By listPrice = By.xpath("//table[@id='qtGrid']/tbody/tr[3]/td[@aria-describedby='qtGrid_StrataVAR__List_Price__c']");
    private By qty = By.xpath("//table[@id='qtGrid']/tbody/tr[3]/td[@aria-describedby='qtGrid_StrataVAR__Quantity__c']");
    private By totalListPrice = By.xpath("//table[@id='qtGrid']/tbody/tr[3]/td[@aria-describedby='qtGrid_StrataVAR__Total_List_Price__c']");
    
    public void editQuoteGrid() {

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(quote));
		moveToElementAndClick(quote);

		wait.until(ExpectedConditions.visibilityOfElementLocated(quoteName));
		moveToElementAndClick(quoteName);

		wait.until(ExpectedConditions.visibilityOfElementLocated(editQuoteButton));
		moveToElementAndClick(editQuoteButton);

		WebElement iframeElement = wait1.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@title, 'Edit Quote')]")));
		driver.switchTo().frame(iframeElement);
	
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(loadingText));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement totalListPrice = driver.findElement(By.xpath("//div[@id='qtWrapper']/div[1]/div[1]/div[1]/div/div[1]"));
		wait.until(ExpectedConditions.visibilityOf(totalListPrice));
		
		
		System.out.println(totalListPrice.getText());
		
		
		WebElement groupText = driver.findElement(By.xpath("//table[@id='qtGrid']/tbody/tr[16]/td[1]/span[3]"));
		System.out.println(groupText.getText());
	
		WebElement listPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//table[@id='qtGrid']/tbody/tr[3]/td[@aria-describedby='qtGrid_StrataVAR__List_Price__c']")
			));
		Actions actions = new Actions(driver);
        actions.moveToElement(listPrice).doubleClick().perform();
        //listPrice.sendKeys(Keys.CONTROL + "a");
        //listPrice.sendKeys(Keys.DELETE);
        
     // Use JavaScript Executor to ensure the field is enabled and editable
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", listPrice);

        // Clear field using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=''", listPrice);

        // Verify that the field is empty
        System.out.println("After clearing, field value: " + listPrice.getAttribute("value"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Wait briefly to allow the UI to reflect the change
		System.out.println("After clearing, field value: " + listPrice.getAttribute("value"));
		listPrice.sendKeys("100");
		
		
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
    }

}

