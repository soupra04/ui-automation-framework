package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

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
	public void tearDown() {
		DriverManager.down();

	}
}
