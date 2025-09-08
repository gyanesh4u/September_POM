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

	public DashBoardPage(WebDriver driver, WaitUtil wait) {
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public boolean dashBoardText() {

		wait.waitForVisibility(dashBoardText);
		return dashBoardText.isDisplayed();

	}
}
