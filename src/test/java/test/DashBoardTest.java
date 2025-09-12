package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class DashBoardTest extends LoginBaseTest {
	@Step("Logout test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("this test is performing logout after user login...")
	@Owner("Gyanesh")
	@Test(enabled = false)
	public void verifyLogout() {

		Assert.assertTrue(dp.dashBoardText(), "Dashboard not displayed");
		lp = dp.logout();
		Assert.assertEquals(lp.getUrlTest(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void pimLinkTest() {
		//dp.clickOnPIM();
		//boolean flag = pp.pimTextVisibility();
		//Assert.assertTrue(flag);
	}
}
