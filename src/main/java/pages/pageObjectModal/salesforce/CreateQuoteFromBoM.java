package pages.pageObjectModal.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.CommonToAllPages;

public class CreateQuoteFromBoM  extends CommonToAllPages {
	
	WebDriver driver;

	public CreateQuoteFromBoM(WebDriver driver) {
		this.driver = driver;
	}

	private By boms = By.xpath("//a[@title='BoMs']");
	private By textBoms = By.xpath("//h1[text()='BoMs']");
	private By BoMName = By.xpath("//a[@title='ER121471272LL']");
	private By createNewButton = By.xpath("//button[normalize-space(text())='Create New Quote']");
	private By copyBomsToQuote = By.xpath("//button[text()='Copy BoMs to Quote']");
	private By presenceOfGrid = By.id("gview_BomSelectorGrid");
	private By overlay = By.id("lui_BomSelectorGrid");
	private By loadingIndicator = By.id("load_BomSelectorGrid");
	By gridContainer = By.xpath("//div[contains(@id,'BomSelectorGrid')]");
	private By bomNumberheader = By.xpath("//th[@id='BomSelectorGrid_Name']");
	private By placeToWriteBoMNumber = By.xpath("//th[@id='gsh_BomSelectorGrid_Name']/div/table/tbody/tr/td[2]/input[@type='text']");
    private By selectChecboxafterPlacingBom = By.xpath("(//input[@role='checkbox'])[2]");	
	private By quickAddToQuotebutton = By.xpath("//div[@id='BomBar']");
	 By selectedBoMName = By.xpath("//table[@id='BomSelectorGrid']/tbody/tr[2]/td[3]");
	
	public String createQuoteFromBom() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Step 1: Click "BoMs" menu
		moveToElementAndClick(boms);
		wait.until(ExpectedConditions.visibilityOfElementLocated(textBoms));

		// Step 2: Click "BoM Name"
		moveToElementAndClick(BoMName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(createNewButton));

		// Step 3: Click "Create New Quote" button
		moveToElementAndClick(createNewButton);

		// Step 4: Wait and click "Copy BoMs to Quote"
		wait1.until(ExpectedConditions.elementToBeClickable(copyBomsToQuote));
		moveToElementAndClick(copyBomsToQuote);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		WebElement iframeElement = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@title, 'Select BoMs')]")));
		driver.switchTo().frame(iframeElement);
		
		 // Step 6: Wait for grid presence
        wait.until(ExpectedConditions.presenceOfElementLocated(bomNumberheader));

        // Step 7: Locate the input field and interact with it
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(placeToWriteBoMNumber));
        inputField.click();
        

        // Scroll input field into view
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", inputField);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Debugging delay

        // Step 8: Clear and enter text
        inputField.clear();
        inputField.sendKeys("ER121471272LL");
       
        WebElement checselectChecboxafterPlacingBomkbox = driver.findElement(By.xpath("(//input[@role='checkbox'])[2]"));
        wait1.until(ExpectedConditions.elementToBeClickable(checselectChecboxafterPlacingBomkbox));
        
        if(!checselectChecboxafterPlacingBomkbox.isSelected()) {
        	checselectChecboxafterPlacingBomkbox.click();
        }

        wait.until(ExpectedConditions.attributeToBe(checselectChecboxafterPlacingBomkbox, "checked", "true"));
        
        if (checselectChecboxafterPlacingBomkbox.isSelected()) {
        	
        	System.out.println("CheckBox is checked");
        } else {
        	System.out.println("CheckBox is not checked");
        }
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(quickAddToQuotebutton));
      moveToElementAndClick(quickAddToQuotebutton);
        
      try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
        // Step 9: Return text from an element inside the iframe
        return inputField.getAttribute("value"); // Gets the entered value instead of re-checking header
    }
		
		
		
	
	


}
