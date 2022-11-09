package udemySelemium.E2EPractices;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LanchPopUp;
import pageObjects.LoginPage;

public class FlipkartTest extends BrowsersSelection {
public static Logger log=LogManager.getLogger(FlipkartTest.class.getName());
public WebDriver driver;
	@BeforeTest
	public void utilites() throws IOException {
		driver = installingBrowserDriver();
		log.info("broser installliser");
		

	}

	@AfterTest
	public void close() {
		driver.close();
		log.info("driver browser closed");
	}

	@Test(dataProvider = "getData")
	public void testutilites(String username, String password, String userreport) throws IOException {
		driver.get(prob.getProperty("URL"));
		HomePage hp = new HomePage(driver);
		LanchPopUp lpup = new LanchPopUp(driver);
		if (lpup.nothanks().isDisplayed()) {
			lpup.nothanks().click();

		}

		// assertTrue(hp.titelverify().getText().equals("Featured Courses"));
		// assertEquals(hp.titelverify().getText(), "Featured Courses");
		// assertTrue(hp.navbar().isDisplayed(),"navigation bar is not presenrt");
		hp.login().click();
		log.info("clicked on login");
		LoginPage lp = new LoginPage(driver);
		lp.enterMail().sendKeys(username);
		lp.enterPassword().sendKeys(password);
		System.out.println(userreport);
		lp.clickLogin().click();

	}

	@DataProvider
	public Object[][] getData() {
		// row stands for many different data types test shoud run
		// coloun stands for how many values per each test
		String[][] data = new String[2][3];
		// 0th row
		log.info("first testing data of user name");
		data[0][0] = "sdgjafsj@hsfdhsh.com";
		data[0][1] = "jdfgcjsdfggfjdsgj";
		data[0][2] = "restricted user";
		// 1st roww
		log.info("send data");
		data[1][0] = "hsgdfjd@jsgdj.com";
		data[1][1] = "hsdgfjhjdgf";
		data[1][2] = "non rected user";
		return data;
	}

}
