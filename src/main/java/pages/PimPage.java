package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class PimPage {
	WebDriver driver;
	WaitUtil wait;

	@FindBy(xpath = "//h6[.='PIM']")
	private WebElement pimText;

	@FindBy(xpath = "//button[.=' Add ']")
	private WebElement addBtn;

	@FindBy(name = "firstName")
	private WebElement firtNameTxt;

	@FindBy(name = "lastName")
	private WebElement lastNameTxt;

	@FindBy(xpath = "//button[.=' Save ']")
	private WebElement saveBtn;

	@FindBy(xpath = "//a[.='Add Employee']")
	private WebElement addEmployee;

	public PimPage(WebDriver driver, WaitUtil wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public boolean pimTextVisibility() {
		return wait.waitForVisibility(pimText).isDisplayed();
	}
	public void refreshPageObjects() {
	    PageFactory.initElements(driver, this); // re-initialize all @FindBy elements
	}

	public void addEmployee(String fName, String lName) throws InterruptedException {
		//wait.waitForVisibility(addBtn).click();
		PageFactory.initElements(driver, this);
		wait.waitForVisibility(addEmployee).click();
		refreshPageObjects();
		wait.waitForVisibility(firtNameTxt).sendKeys(fName);
		wait.waitForVisibility(lastNameTxt).sendKeys(lName);
		wait.waitForVisibility(saveBtn).click();
		PageFactory.initElements(driver, this);
		wait.waitForVisibility(pimText);		
		Thread.sleep(10000);
		
		//wait.waitForVisibility(addEmployee).click();
		

	}
	
}
