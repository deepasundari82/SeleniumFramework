package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Utils.EmailUtils;
import Utils.ExtentReportManager;
import Utils.log;


//import jdk.internal.org.jline.utils.Log;

public class BaseTest {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	
	@BeforeSuite
	public void setupReport(){
		extent=ExtentReportManager.getReportInstance();	
	}
	
	
	@AfterSuite
	public void teardownReport() {
		extent.flush();
		String reportpath=ExtentReportManager.reportPath;
		
		EmailUtils.sendTestReport(reportpath);	
		
	}
	
	
	 @BeforeMethod
	public void setup(){
		 
		log.info("Starting WebDriver...");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Navigating to URL.." );
		driver.get("https://admin-demo.nopcommerce.com/login");
		
	}
	
	 @AfterMethod
	public void tearDown(ITestResult result){	//ITEstResult instance result has the result of our test. 
		 //attaching screenshots 
		 
		 if(result.getStatus()==ITestResult.FAILURE) {
			 String screenshotpath= ExtentReportManager.captureScreenshot(driver, "Login Failure"); 
			 test.fail("Test Failed.. Check Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
			 
		 }
		 
		 
		if(driver!=null) {
			log.info("Closing the Browser");
		driver.close();
	
	}

}
}
