package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user_email")
	WebElement enterMail;
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement enterPassword;
	@FindBy(xpath = "//input[@value='Log In']")
	WebElement clickLogin;
	@FindBy(xpath = "//a[@class='link-below-button']")
	WebElement clickForgot;

	public WebElement enterMail() {
		return enterMail;
	}

	public WebElement enterPassword() {
		return enterPassword;
	}

	public WebElement clickLogin() {
		return clickLogin;
	}

	public WebElement clickForgot() {
		return clickForgot;
	}

}
