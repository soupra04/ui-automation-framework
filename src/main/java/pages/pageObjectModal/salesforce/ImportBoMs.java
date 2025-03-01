package pages.pageObjectModal.salesforce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.CommonToAllPages;

public class ImportBoMs extends CommonToAllPages {

	WebDriver driver;

	public ImportBoMs(WebDriver driver) {

		this.driver = driver;

	}

	private By opportunity = By.xpath("//a[@title='Opportunities']");
	private By selectOpportunity = By.xpath("//a[contains(@class, 'outputLookupLink') and @title='Test Opportunity']");
	private By clickonImportbom = By.xpath("//button[normalize-space(text())='Import BoM']");
	private By clickOnBoMType = By.xpath("//lightning-combobox[@data-type='picklist' and @data-id='bomType']");
	// private By distiBoM = By.xpath("//lightning-combobox[@data-type='picklist'
	// and
	// @data-id='bomType']/div/div[1]/lightning-base-combobox/div/div/div/button[@data-value='Disti
	// BoM']");
	private By distiBoM = By
			.xpath("//lightning-base-combobox-item[span[@class='slds-media__body']/span[@title='Disti BoM']]");

	private By dealReg = By.xpath("//button[@data-value='Deal Registration']");

	// private By distiBoM = By.xpath("//button[span[@part='input-button-value' and
	// normalize-space(text())='Disti BoM']]");
	private By enterPriceText = By.xpath("//h1/span[text()='Enterprise Quoting']");
	private By loadingicon = By.xpath("//div[@id='auraLoadingBox']");
	private By opportunityText = By.xpath("//h1[text()='Opportunities']");
	private By textInOppPage = By
			.xpath("//slot[@name='primaryField']/lightning-formatted-text[normalize-space(text())='Test Opportunity']");
	private By importBoMTextonModal = By.xpath("//h2[normalize-space(text())='Import BoM']");
	// private By chooseFile = By.xpath("//span[@part='button' and
	// normalize-space(text())='Upload Files']");
	private By doneButton = By.xpath("//button[span[normalize-space(text())='Done']]");
	private By importBoMButton = By
			.xpath("//button[contains(@class, 'slds-button_brand') and normalize-space(text())='Import BoM']");
	private By wanringButton = By.xpath("//div/h1[normalize-space(text())='Warning']");
	private By successicon = By.xpath("//lightning-primitive-icon[@variant='success']");
	private By confirmationYesy = By.xpath("//button[@type='button' and normalize-space(text())='Yes']");
	private By successMessage = By.xpath("//div[normalize-space(text())='Import BoM Success']");
	private By clickonBomHeader = By.xpath("//a[@title='BoM Header']");
	private By tostClose = By.xpath("//button[contains(@class, 'toastClose')]");
	private By createNewButton = By.xpath("//button[normalize-space(text())='Create New Quote']");
	private By totalPrice = By.xpath("(//lightning-formatted-number[text()='27,248.00'])[1]");
    private By bomId = By.xpath("//label[contains(text(), 'BoM ID')]/following::input[@class='slds-input'][1]");
	private By dealheader = By.xpath("//a[@title='78738736-4766592185']");
	private By totalPriceDeal = By.xpath("(//lightning-formatted-number[text()='18,620.09'])[1]");
	public String importDisti() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement textHomePage = driver.findElement(enterPriceText);
		System.out.println("This is The Home Screen text" + " | " + textHomePage.getText());

		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(enterPriceText));
		moveToElementAndClick(opportunity);

		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(opportunityText));
		moveToElementAndClick(selectOpportunity);

		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(textInOppPage));
		moveToElementAndClick(clickonImportbom);

		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(importBoMTextonModal));
		moveToElementAndClick(clickOnBoMType);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(dealReg));
		wait1.until(ExpectedConditions.elementToBeClickable(dealReg));
		moveToElementAndClick(distiBoM);

		// Get the absolute file path
		String dir = System.getProperty("user.dir");
		String filePath = dir + "\\souprarenewal22.xlsx"; // Use
		// "\\" for Windows OR "/" for cross-platform

		System.out.println("Uploading file: " + filePath);

		// Locate the file input and send the file path
		WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
		wait1.until(ExpectedConditions.elementToBeClickable(chooseFile));
		// String filePath1 = "D:\\Java
		// workspace\\webUI-automation-framework\\soupraRenewal22.xlsx";
		chooseFile.sendKeys(filePath);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(successicon));
		wait1.until(ExpectedConditions.elementToBeClickable(successicon));
		moveToElementAndClick(doneButton);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement importbutton = driver.findElement(importBoMButton);
		wait1.until(ExpectedConditions.elementToBeClickable(importbutton));
		js.executeScript("arguments[0].click();", importbutton);

		/*
		 * wait1.until(ExpectedConditions.visibilityOfElementLocated(importBoMButton));
		 * wait1.until(ExpectedConditions.elementToBeClickable(importBoMButton));
		 * moveToElementAndClick(importBoMButton);
		 */

		wait1.until(ExpectedConditions.visibilityOfElementLocated(wanringButton));
		moveToElementAndClick(confirmationYesy);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		moveToElementAndClick(clickonBomHeader);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(createNewButton));
		moveToElementAndClick(tostClose);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(createNewButton));

		WebElement totalListP = driver.findElement(totalPrice);
		String totalpriceValue = totalListP.getText();
		System.out.println("total list price of Disti" + " " + totalpriceValue);
		return totalpriceValue;

	}
	
	
	public String importDeal() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement textHomePage = driver.findElement(enterPriceText);
		System.out.println("This is The Home Screen text" + " | " + textHomePage.getText());

		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(enterPriceText));
		moveToElementAndClick(opportunity);

		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(opportunityText));
		moveToElementAndClick(selectOpportunity);

		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(textInOppPage));
		moveToElementAndClick(clickonImportbom);

		//wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(importBoMTextonModal));
		//moveToElementAndClick(clickOnBoMType);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(dealReg));
		
		WebElement dealId = driver.findElement(bomId);
		dealId.sendKeys("78738736-4766592185");
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(importBoMButton));
		  wait1.until(ExpectedConditions.elementToBeClickable(importBoMButton));
		  moveToElementAndClick(importBoMButton);
		  
		  
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(wanringButton));
			moveToElementAndClick(confirmationYesy);

			wait1.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
			moveToElementAndClick(dealheader);

			wait1.until(ExpectedConditions.visibilityOfElementLocated(createNewButton));
			moveToElementAndClick(tostClose);

			wait1.until(ExpectedConditions.visibilityOfElementLocated(createNewButton));
			
			
			WebElement totalListP = driver.findElement(totalPriceDeal);
			String totalpriceValue = totalListP.getText();
			System.out.println("total list price of Deal" + " " + totalpriceValue);
			return totalpriceValue;
		  
		
		
	}

}
