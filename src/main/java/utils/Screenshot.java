package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void failedScreenshot(WebDriver driver, String testName) {
		if (driver == null) {
			System.out.println("driver is null cannot capture screenshot...");
		}
		
		try {
			Thread.sleep(2000);
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);

			String dest = "./snap/" + testName + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(src, new File(dest));
			System.out.println("screenshot saved " + dest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
