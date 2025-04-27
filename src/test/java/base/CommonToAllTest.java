package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.observer.entity.MediaEntity;

import driver.DriverManager;
import utils.ExtentReportManager;

public class CommonToAllTest {
	protected static ExtentReports extent;
	protected ExtentTest test;
	
     @BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
    @AfterSuite
	public void teardownReport() {
		extent.flush();

	}

	@BeforeMethod
	public void setup() {
		DriverManager.init();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() ==ITestResult.FAILURE) {
			String screenshotPath = ExtentReportManager.captureScreenShot(DriverManager.getDriver(), "LoginFailure");
		test.fail("Test Failed...Check Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		DriverManager.down();

	}
}
