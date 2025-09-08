package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import utils.ConfigReader;

public class LoginTest extends BasePage {

	@Step("valid login test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("this test is performing login with valid credentials")
	@Owner("Gyanesh")
	@Link(url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
	@Test(priority = 3)
	public void loginTest() {
		// LoginPage lp = new LoginPage(driver);
		lp.doLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		boolean status = dp.dashBoardText();
		System.out.println(status);
		Assert.assertTrue(status);
	}

	@Step("title test")
	@Severity(SeverityLevel.MINOR)
	@Description("this test is performing title test")
	@Owner("Gyanesh")
	@Link(url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
	@Test(priority = 2)
	public void titleTest() {
		// LoginPage lp = new LoginPage(driver);
		String title = lp.title();// abstraction
		System.out.println("title is " + title + "...");
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Step("url test")
	@Severity(SeverityLevel.MINOR)
	@Description("this test is performing url test")
	@Owner("Gyanesh")
	@Link(url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
	@Test(priority = 1)
	public void urlTest() {
		// LoginPage lp = new LoginPage(driver);
		String url = lp.getUrlTest();
		System.out.println(url);
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index
	}
}
