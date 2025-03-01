package pages.pageObjectModal.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.CommonToAllPages;

public class EndToEndFlow extends CommonToAllPages {

	WebDriver driver;

	public EndToEndFlow(WebDriver driver) {

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
	private By boms = By.xpath("//a[@title='BoMs']");
	private By textBoms = By.xpath("//h1[text()='BoMs']");
	private By BoMName = By.xpath("//a[@title='78738736-4766592185']");
	private By copyBomsToQuote = By.xpath("//button[text()='Copy BoMs to Quote']");
	private By bomNumberheader = By.xpath("//th[@id='BomSelectorGrid_Name']");
	private By placeToWriteBoMNumber = By
			.xpath("//th[@id='gsh_BomSelectorGrid_Name']/div/table/tbody/tr/td[2]/input[@type='text']");
	private By quickAddToQuotebutton = By.xpath("//div[@id='BomBar']");
	private String selectedBoMRowXpath = "//td[@role='gridcell' and @aria-describedby='BomSelectorGrid_Name' and a[text()='78738736-4766592185']]/preceding-sibling::td//input[@type='checkbox']";
	private By loadingText = By.xpath(
			"//div[contains(@class, 'auraLoadingBox') and contains(@class, 'oneLoadingBox')]//div[contains(@class, 'loadingText')]");
	private By exportButton = By.xpath("//li[@id='exportQuoteTab']");
private By quoteTextonExportPage = By.xpath("//label[normalize-space(text())='Quote']");
private By exportQuoteButton = By.xpath("//input[@value='Export Quote']");	
private By clickOnMagnFyingGlas = By.xpath("//img[@title='PQW Template Lookup (New Window)']");
private By quoteToContinue = By.xpath("//input[@type='submit']");

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

		// wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(importBoMTextonModal));
		// moveToElementAndClick(clickOnBoMType);

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

	public void createQuote() {

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Step 1: Click "BoMs" menu
		moveToElementAndClick(boms);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(textBoms));

		// Step 2: Click "BoM Name"
		moveToElementAndClick(BoMName);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(createNewButton));

		// Step 3: Click "Create New Quote" button
		moveToElementAndClick(createNewButton);

		// Step 4: Wait and click "Copy BoMs to Quote"
		wait1.until(ExpectedConditions.elementToBeClickable(copyBomsToQuote));
		moveToElementAndClick(copyBomsToQuote);

		// Step 5: Switch to iframe
		WebElement iframeElement = wait1.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@title, 'Select BoMs')]")));
		driver.switchTo().frame(iframeElement);

		// Step 6: Wait for grid presence
		wait1.until(ExpectedConditions.presenceOfElementLocated(bomNumberheader));
		WebElement bomHeader = driver.findElement(bomNumberheader);
		System.out.println("BoM Grid Loaded: " + bomHeader.getText());

		// Step 7: Locate input field, scroll into view, and enter BoM number
		WebElement inputField = wait1.until(ExpectedConditions.visibilityOfElementLocated(placeToWriteBoMNumber));
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", inputField);
		inputField.clear();
		inputField.sendKeys("78738736-4766592185");

		// Step 8: Wait for the BoM table to update
		wait1.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//td[@aria-describedby='BomSelectorGrid_Name']"), "78738736-4766592185"));

		// Step 9: Locate the correct BoM row after filtering
		WebElement correctBoMRow = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectedBoMRowXpath)));
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", correctBoMRow);

		// Step 10: Select the correct checkbox
		if (!Boolean.parseBoolean(correctBoMRow.getAttribute("checked"))) {
			correctBoMRow.click();
		}

		// Step 11: Confirm checkbox selection
		wait1.until(ExpectedConditions.attributeToBe(correctBoMRow, "checked", "true"));
		System.out.println("Correct BoM CheckBox is checked successfully");

		// Step 12: Click "Quick Add to Quote" button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(quickAddToQuotebutton));
		moveToElementAndClick(quickAddToQuotebutton);

		// Step 13: Delay for UI processing
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// wait1.until(ExpectedConditions.invisibilityOfElementLocated(loadingText));

		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@title, 'BoMs')]")));

		WebElement totalListPrice = driver
				.findElement(By.xpath("//div[@id='qtWrapper']/div[1]/div[1]/div[1]/div/div[1]"));
		
		wait1.until(ExpectedConditions.visibilityOf(totalListPrice));
		wait1.until(ExpectedConditions.elementToBeClickable(totalListPrice));

		System.out.println(totalListPrice.getText());
		moveToElementAndClick(exportButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(quoteTextonExportPage));
		
		/*
		WebElement templateSelect = driver.findElement(By.xpath("//input[@class='pqwTempClass slds-input' and @value='Standard Template']"));
		templateSelect.clear();
		templateSelect.sendKeys("Standard Template"); // Enter text
        templateSelect.sendKeys(Keys.RETURN); // Press Enter
        */
        WebElement exportQuote = driver.findElement(exportQuoteButton);
        
        wait1.until(ExpectedConditions.elementToBeClickable(exportQuote));
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", exportQuote);

        exportQuote.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        wait1.until(ExpectedConditions.visibilityOfElementLocated(quoteToContinue));
        wait1.until(ExpectedConditions.elementToBeClickable(quoteToContinue));
        moveToElementAndClick(quoteToContinue);
        
        try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
