package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtil;
import utils.WaitUtil;

public class LoginPageBy {

	WebDriver driver;
	WaitUtil wait;
	ElementUtil e;

	private By username = By.name("username");

	private By password = By.name("password");

	private By loginBtn = By.xpath("//button[@type='submit']");

	public LoginPageBy(WebDriver driver) {
		this.driver = driver;
		e = new ElementUtil(driver);
	}

	public void doLogin(String un, String pwd) {
//		driver.findElement(username).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
//		e.getElement(username).sendKeys(un);
//		e.getElement(password).sendKeys(pwd);
//		e.getElement(loginBtn).click();
		e.doSendKeys(username, un);
		e.doSendKeys(password, pwd);
		e.doClick(loginBtn);
	}
	public String titleTest() {
		return driver.getTitle();
	}
}
