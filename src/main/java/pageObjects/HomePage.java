package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	By login = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	By register = By.xpath("//a[@href='https://courses.rahulshettyacademy.com/sign_up']");
	By titel=By.xpath("//h2[text()='Featured Courses']");
	By navbar=By.xpath("//div[@role='navigation']");

	public WebElement login() {
		return driver.findElement(login);
	}

	public WebElement register() {
		return driver.findElement(register);
	}
	public WebElement titelverify() {
		return driver.findElement(titel);
	}
	public WebElement navbar() {
		return driver.findElement(navbar);
	}
}
