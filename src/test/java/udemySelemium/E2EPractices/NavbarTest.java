package udemySelemium.E2EPractices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import pageObjects.HomePage;
import pageObjects.LanchPopUp;

public class NavbarTest extends BrowsersSelection{
	public WebDriver driver;
	 public static Logger log=LogManager.getLogger(NavbarTest.class.getName());
	@Test
	public void navthing() throws IOException {
	
		LanchPopUp lpup=new LanchPopUp(driver);
		if (lpup.nothanks().isDisplayed()) {
			lpup.nothanks().click();
			log.info("puped out window");

		}
		HomePage hp=new HomePage(driver);
		hp.navbar().isDisplayed();
		log.info("navbar is displayed");
		assertTrue(hp.navbar().isDisplayed(),"this all nav selentions");
	}
	@BeforeTest
	public void utilites() throws IOException {
		driver = installingBrowserDriver();
		driver.get(prob.getProperty("URL"));
		log.info("sending url and enterrseded the url ");
		
	}
	@AfterTest
	public void close() {
		driver.close();
		log.info("surcesws fulli closed browswer");
	}

}
