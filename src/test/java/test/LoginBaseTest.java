package test;

import org.testng.annotations.BeforeMethod;

import base.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import utils.ConfigReader;

public class LoginBaseTest extends BasePage {
	@Step("valid login test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("this test is performing login with valid credentials")
	@Owner("Gyanesh")
	@BeforeMethod
	public void login() {
		dp = lp.doLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	}
}
