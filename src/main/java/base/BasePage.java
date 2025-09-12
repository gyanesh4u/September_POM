package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.PimPage;
import utils.ConfigReader;
import utils.Screenshot;
import utils.WaitUtil;

public class BasePage {
	/**
	 * This is parent class for all the test class
	 * 
	 * @author gyaneshkamal
	 */

	// init our browser enter our url close the browser
	protected WebDriver driver;
	protected LoginPage lp;
	protected Properties prop;
	protected DashBoardPage dp;
	protected PimPage pp;
	protected WaitUtil wait;

	@BeforeSuite

	public void beforeSuite() {

		prop = ConfigReader.initProperties();
	}

	@Epic("Login")
	@Story("Login ST-01")
	@Feature("Orange HRM Login")
	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome")String browserName) {
		// browserName = prop.getProperty("browser");
		if (browserName == null || browserName.isEmpty()) {
			browserName = prop.getProperty("browser");
		}
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			driver = new ChromeDriver();
		}
		System.out.println("opening app on " + browserName + " browser...");
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("url"));
		long implicitWait = Long.parseLong(ConfigReader.getProperty("ITO"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		int explicitWait = Integer.parseInt(ConfigReader.getProperty("ETO")); // default 10s
		wait = new WaitUtil(driver);
		lp = new LoginPage(driver, wait);
		dp = new DashBoardPage(driver, wait);
		pp=new PimPage(driver, wait);

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

	@AfterMethod
	public void captureFailureScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Screenshot.failedScreenshot(driver, result.getName());
		}
	}

}
