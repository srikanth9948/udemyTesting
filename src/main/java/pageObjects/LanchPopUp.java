package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanchPopUp {
	

	WebDriver driver;
	public LanchPopUp(WebDriver driver) {
		this.driver=driver;
	}
	By nothanks=By.xpath("//button[text()='NO THANKS']");
	public WebElement nothanks(){
		return driver.findElement(nothanks);
	}
	

}
