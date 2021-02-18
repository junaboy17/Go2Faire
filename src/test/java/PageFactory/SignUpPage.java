package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AppBase.DriverFactory;
import AppBase.SeleniumHelper;

public class SignUpPage {

	public SignUpPage(WebDriver driver) {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	SeleniumHelper helper = new SeleniumHelper();
	
	@FindBy(xpath= "//div[@id='items_top_area_ttl']")
	public WebElement registrationTitle;
	
	@FindBy(xpath= "//input[@id='txtEmail']")
	public WebElement emailTextBox;
	
	@FindBy(xpath= "//input[@id='txtUserName']")
	public WebElement usernameTextBox;
	
	@FindBy(xpath= "//input[@id='txtPassword']")
	public WebElement passwordTextBox;
	
	@FindBy(xpath= "//input[@id='txtCnfPassword']")
	public WebElement confirmPasswordTextBox;
	
	@FindBy(xpath= "//input[@id='txtFirstName']")
	public WebElement firstNameTextBox;
	
	@FindBy(xpath= "//input[@id='txtLastName']")
	public WebElement lastNameTextBox;
	
	@FindBy(xpath= "//input[@type='checkbox']")
	public WebElement newsLetterCheckBox;
	
	@FindBy(xpath= "//input[@id='btnRegister']")
	public WebElement createAccountBtn;
	
	@FindBy(xpath= "//div[@class='forgot_row']")
	public WebElement forgotPasswordLink;
	
	
	public String readTitle() {
		return helper.getWebElement(registrationTitle).getText();
	}
	
	public SignUpPage enterEmail(String email, String... clear) {
		helper.enterKeys(email, emailTextBox, clear);
		return this;
	}
	
	public SignUpPage enterUsername(String username, String... clear) {
		helper.enterKeys(username, usernameTextBox, clear);
		return this;
	}
	
	public SignUpPage enterPassword(String password, String... clear) {
		helper.enterKeys(password, passwordTextBox, clear);
		return this;
	}
	
	public SignUpPage enterConfirmPassword(String confirmPassword, String... clear) {
		helper.enterKeys(confirmPassword, confirmPasswordTextBox, clear);
		return this;
	}
	
	public SignUpPage enterFirstName(String firstName, String... clear) {
		helper.enterKeys(firstName, firstNameTextBox, clear);
		return this;
	}
	
	public SignUpPage enterLastName(String lastName, String... clear) {
		helper.enterKeys(lastName, lastNameTextBox, clear);
		return this;
	}
	
	public SignUpPage clickNewsLetterCheckBox() {
		helper.getWebElement(newsLetterCheckBox).click();
		return this;
	}
	
	public SignUpPage clickCreateAccountBtn() {
		helper.getWebElement(createAccountBtn).click();
		return this;
	}
	
	public SignUpPage clickForgotPasswordLink() {
		helper.getWebElement(forgotPasswordLink).click();
		return this;
	}
}
