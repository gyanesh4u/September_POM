package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import utils.ExcelReader;

public class PimTest extends LoginBaseTest {

	@Step("Employee test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("this test is performing new employee...")
	@Owner("Gyanesh")
	@Test(dataProvider = "addEmployee")
	public void addEmployeeTest(String firstName, String lastName) throws InterruptedException {
		dp.clickOnPIM();
		System.out.println("Adding employee: " + firstName + " " + lastName);
		pp.addEmployee(firstName, lastName);
	}

	@DataProvider
	public Object[][] addEmployee() {
	    return new Object[][] {
	        {"gyanesh", "kamal"},
	        {"nimisha", "jaya"}
	    };
	}

}
