package base;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static driver.DriverManager.getDriver;
import utils.PropertiesReader;

//import static com.webautomation.driver.DriverManager.getDriver;

public class CommonToAllPages {

    /**
     * Constructor to initialize any resources needed before each page object call.
     */
    public CommonToAllPages() {
        // Initialize resources like files, database connections, etc., if needed.
    }
    /*
    public void openVWOUrl(){
    	getDriver().get(PropertiesReader.readkey("url"));
    }
*/
    /**
     * Clicks on an element specified by a locator.
     * 
     * @param locator the By locator of the element to click
     */
    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement by) {
        by.click();
    }
    

   
    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }
    
    
    public void clearElement(By by) {
        getDriver().findElement(by).clear();
    }

   

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

   
    public void getText(By by) {
         getDriver().findElement(by).getText();
    }

   
    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    
    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    
    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }
}
