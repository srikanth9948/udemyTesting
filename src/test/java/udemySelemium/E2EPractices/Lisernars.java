package udemySelemium.E2EPractices;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Lisernars extends BrowsersSelection implements ITestListener  {
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	ExtentReports extent = ExtentReportNG.getReportsObject();
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		 
	}

	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS,"test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		extenttest.get().fail(result.getThrowable());
		String testmethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch(Exception io) {
			
		}
		extenttest.get().addScreenCaptureFromPath(getScreenShot(testmethodname,driver), result.getMethod().getMethodName());
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
