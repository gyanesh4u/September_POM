package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtil;

public class LoginPage {
	WebDriver driver;
	WaitUtil wait;
	// 1) locators

	@FindBy(name = "username") // @findBy==>PageFactory
	private WebElement userName;// encapsulation

	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	// 2. Constructor

	public LoginPage(WebDriver driver,WaitUtil wait) { // LoginPage lp=new LoginPage(driver);
		this.driver = driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}

	// 3.Create method that will perform action on the web page
/**
 * this method is use to login using valid credentials
 * @param un
 * @param pass
 */
	//abstraction can be achieved using creating methods that will be used by out test class
	public DashBoardPage doLogin(String un, String pass) {
		 wait.waitForVisibility(userName).sendKeys(un);
	        wait.waitForVisibility(pwd).sendKeys(pass);
	      loginBtn.click();
	        return new DashBoardPage(driver, wait);
//		userName.sendKeys(un);
//		pwd.sendKeys(pass);
//		loginBtn.click();
//		return new DashBoardPage(driver, wait);
	}
	/**
	 * This method is use to test title
	 * @return
	 */

	public String title() {
		return driver.getTitle();
	}

	/**
	 * This method is used to test URL
	 * @return
	 */
	public String getUrlTest() {
		return driver.getCurrentUrl();
	}
}
