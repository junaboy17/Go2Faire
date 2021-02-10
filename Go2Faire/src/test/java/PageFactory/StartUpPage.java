package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AppBase.DriverFactory;
import AppBase.SeleniumHelper;

public class StartUpPage {

	public StartUpPage(WebDriver driver) {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	SeleniumHelper helper = new SeleniumHelper();
	
	@FindBy(xpath= "//span[contains(text(),'Login')]")
	public WebElement logInBtn;
	
	
	public StartUpPage clickLogIn() {
		helper.getWebElement(logInBtn).click();
		return this;
	}
}
