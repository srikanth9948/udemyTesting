package udemySelemium.E2EPractices;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	static ExtentReports extent; 
	public static ExtentReports getReportsObject() {
		String part=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(part);
		reporter.config().setReportName("web Automtion Results");
		reporter.config().setDocumentTitle("Test Result");
	
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "srikanth");
		return extent;
	}
}
