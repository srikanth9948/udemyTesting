package udemySelemium.E2EPractices;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowsersSelection {
	public WebDriver driver;
	public Properties prob;
	public WebDriver installingBrowserDriver() throws IOException {
		FileInputStream files = new FileInputStream(
				"C:\\Users\\sri\\eclipse-workspace\\E2EPractices\\DataResources\\Data.properties");
		 prob = new Properties();
		prob.load(files);
		String browsername = System.getProperty("Browser");
		//String browsername = prob.getProperty("Browser");
		System.out.println(prob.getProperty("Browser"));
		if (browsername.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\sri\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browsername.equals("crome")) {
			driver = new ChromeDriver();

		} else if (browsername.equals("edje")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	public String getScreenShot(String testMethodname,WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenfile = ts.getScreenshotAs(OutputType.FILE);
		String dse = System.getProperty("user.dir")+"\\reports\\"+testMethodname+".png";
		try {
			FileUtils.copyFile(screenfile,new File( dse));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dse;
	}
	

}
