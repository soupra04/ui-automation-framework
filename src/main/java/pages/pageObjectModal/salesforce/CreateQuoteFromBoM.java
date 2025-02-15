package pages.pageObjectModal.salesforce;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.CommonToAllPages;

public class CreateQuoteFromBoM extends CommonToAllPages {

    WebDriver driver;

    public CreateQuoteFromBoM(WebDriver driver) {
        this.driver = driver;
    }

    private By boms = By.xpath("//a[@title='BoMs']");
    private By textBoms = By.xpath("//h1[text()='BoMs']");
    private By BoMName = By.xpath("//a[@title='ER121471272LL']");
    private By createNewButton = By.xpath("//button[normalize-space(text())='Create New Quote']");
    private By copyBomsToQuote = By.xpath("//button[text()='Copy BoMs to Quote']");
    private By bomNumberheader = By.xpath("//th[@id='BomSelectorGrid_Name']");
    private By placeToWriteBoMNumber = By.xpath("//th[@id='gsh_BomSelectorGrid_Name']/div/table/tbody/tr/td[2]/input[@type='text']");
    private By quickAddToQuotebutton = By.xpath("//div[@id='BomBar']");
    
    // Modified locator to dynamically find the correct checkbox in the filtered row
    private String selectedBoMRowXpath = "//td[@role='gridcell' and @aria-describedby='BomSelectorGrid_Name' and a[text()='ER121471272LL']]/preceding-sibling::td//input[@type='checkbox']";

    public String createQuoteFromBom() {
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
        WebElement iframeElement = wait1.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@title, 'Select BoMs')]")));
        driver.switchTo().frame(iframeElement);

        // Step 6: Wait for grid presence
        wait1.until(ExpectedConditions.presenceOfElementLocated(bomNumberheader));
        WebElement bomHeader = driver.findElement(bomNumberheader);
        System.out.println("BoM Grid Loaded: " + bomHeader.getText());

        // Step 7: Locate input field, scroll into view, and enter BoM number
        WebElement inputField = wait1.until(ExpectedConditions.visibilityOfElementLocated(placeToWriteBoMNumber));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", inputField);
        inputField.clear();
        inputField.sendKeys("ER121471272LL");
        
        // Step 8: Wait for the BoM table to update
        wait1.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[@aria-describedby='BomSelectorGrid_Name']"), "ER121471272LL"));

        // Step 9: Locate the correct BoM row after filtering
        WebElement correctBoMRow = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectedBoMRowXpath)));
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
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 14: Return entered BoM number
        return inputField.getAttribute("value");
    }
}
