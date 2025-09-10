package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	 public String waitForTitleContains(String titleValue,int timeout) {
	    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    	wait.until(ExpectedConditions.titleContains(titleValue));
	    	return driver.getTitle();
	    }
}
