package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtil;

public class DashBoardPage {

	WebDriver driver;
	WaitUtil wait;

	@FindBy(xpath = "//h6[.='Dashboard']")
	private WebElement dashBoardText;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement userDropdown;

	@FindBy(xpath = "//a[.='PIM']")
	private WebElement pimLink;

	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logout;

	public DashBoardPage(WebDriver driver, WaitUtil wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public boolean dashBoardText() {

		wait.waitForVisibility(dashBoardText);
		return dashBoardText.isDisplayed();

	}

	public LoginPage logout() {
		wait.waitForVisibility(userDropdown).click();
		wait.waitForVisibility(logout).click();
		return new LoginPage(driver, wait);
	}

	public PimPage clickOnPIM() {
		wait.waitForVisibility(pimLink).click();
		return new PimPage(driver, wait);
	}
}
