package pages.pageObjectModal.prw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.CommonToAllPages;

public class IcConsoleTest extends CommonToAllPages {

    WebDriver driver;

    public IcConsoleTest(WebDriver driver) {
        this.driver = driver;
    }

    private By rmConsoleTab = By.xpath("//a[@title='Renewal Manager - Console']");
    private By rnConsoleText = By.xpath("//h1[normalize-space(text())='Renewal Manager - Console']");
    private By icTab = By.xpath("(//li[@role='presentation'])[4]/a/div/span[normalize-space(text())='Internal Contracts']");
    private By icText = By.xpath("//lightning-formatted-rich-text[span[normalize-space(text())='Internal Contracts']]");
    private By tablePresent = By.xpath("//table[contains(@class, 'slds-table') and contains(@class, 'extRelList')]");
    private By showIcButton = By.xpath("//lightning-button[.//button[@title='Show related IC Items']]");
    private By showIcItem = By.xpath("//lightning-formatted-rich-text[contains(., 'Internal Contract Items of')]");
    private By createALButton = By.xpath("//button[@title='Create/Add AL']");
    private By addtoAlItemText = By.xpath("//h2[normalize-space(text())='Add to Asset List Items']");
    private By selectAlBox = By.xpath("//button[@aria-label='Select a AL (New/ Existing)']");
    private By newAlOption = By.xpath("//div[@aria-label='Select a AL (New/ Existing)']//lightning-base-combobox-item[span[@title='New']]");
    private By writeALNamebox = By.xpath("(//div[contains(@class, 'slds-form-element__control')]//input[@type='text'])[3]");
    private By loadingIcon = By.xpath("//div[@id='iconstage']");
    private By loadedText = By.xpath("//div[contains(text(), 'Loaded')]");

    public void selectIcItem() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        moveToElementAndClick(rmConsoleTab);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(rnConsoleText));

        moveToElementAndClick(icTab);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(tablePresent));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(loadedText));

        List<WebElement> inProgressRows = driver.findElements(
            By.xpath("//td[.//lightning-formatted-rich-text[.//span[normalize-space()='In Progress']]]")
        );

        WebElement checkbox = null;
        for (WebElement row : inProgressRows) {
            checkbox = row.findElement(By.xpath("preceding-sibling::td//input[@type='checkbox']"));
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkbox);

            if (clickCheckbox(js, checkbox)) {
                System.out.println("✅ Checkbox is successfully selected.");
            } else {
                System.out.println("⚠️ Checkbox could not be selected.");
            }
            break;
        }

        if (checkbox == null || !checkbox.isSelected()) {
            System.out.println("❌ No 'In Progress' rows found or checkbox not selected.");
            return;
        }

        wait1.until(ExpectedConditions.elementToBeClickable(showIcButton));
        moveToElementAndClick(showIcButton);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(showIcItem));

        System.out.println("✅ IC Items Loaded");

        List<WebElement> dueForRenewalRows = driver.findElements(
            By.xpath("//td[.//lightning-formatted-rich-text[.//span[normalize-space()='Due for Renewal']]]")
        );

        WebElement icItemCheckbox = null;
        for (WebElement row : dueForRenewalRows) {
            icItemCheckbox = row.findElement(By.xpath("preceding-sibling::td//input[@type='checkbox']"));
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", icItemCheckbox);

            if (clickCheckbox(js, icItemCheckbox)) {
                System.out.println("✅ IC Item Checkbox selected.");
            } else {
                System.out.println("⚠️ IC Item Checkbox could not be selected.");
            }
            break;
        }

        if (icItemCheckbox == null || !icItemCheckbox.isSelected()) {
            System.out.println("⚠️ No 'Due for Renewal' items found");
        }

        wait1.until(ExpectedConditions.visibilityOfElementLocated(createALButton));
        moveToElementAndClick(createALButton);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(addtoAlItemText));

        moveToElementAndClick(selectAlBox);
        moveToElementAndClick(newAlOption);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(writeALNamebox));

        WebElement alName = driver.findElement(writeALNamebox);
        alName.sendKeys("Soupra");

        System.out.println("✅ 'Soupra' added to AL successfully!");
    }

    private boolean clickCheckbox(JavascriptExecutor js, WebElement checkbox) {
        int attempts = 0;
        while (attempts < 5) {
            if (!checkbox.isSelected()) {
                new Actions(driver).moveToElement(checkbox).click().perform();
                wait1.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("⚠️ Thread was interrupted while waiting after clicking checkbox.");
                    return false;
                }
            }

            if (checkbox.isSelected()) {
                System.out.println("✅ Checkbox is selected on attempt: " + (attempts + 1));
                return true;
            }
            
            System.out.println("🔄 Retrying checkbox selection... Attempt: " + (attempts + 1));
            attempts++;
        }

        System.out.println("⚠️ Checkbox not selected after multiple attempts. Forcing selection via JavaScript.");
        js.executeScript("arguments[0].checked = true;", checkbox);
        return checkbox.isSelected();
    }
}
