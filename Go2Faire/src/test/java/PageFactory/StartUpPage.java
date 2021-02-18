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
	
	@FindBy(xpath= "//button[@id='jqSignup']")
	public WebElement signUpBtn;
	
	@FindBy(xpath= "//input[@id='username']")
	public WebElement usernametextbox;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordtextbox;
	
	@FindBy(xpath = "//button[@id='jqLogin']")
	public WebElement redlogin;

	
	public StartUpPage clickLogIn() {
		helper.getWebElement(logInBtn).click();
		return this;
	}
	
	public SignUpPage clickSignUp() {
		helper.getWebElement(signUpBtn).click();
		return new SignUpPage(DriverFactory.getDriver());
	}
	
	public StartUpPage enterUsername() {
		helper.enterKeys("yellow", usernametextbox);
		return this;
	}
	
	public StartUpPage enterPassword() {
		helper.enterKeys("Green1@", passwordtextbox);
		return this;
	}
	
	public StartUpPage clickRedLogin() {
		helper.getWebElement(redlogin).click();
		return this;
	}
}
